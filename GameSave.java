package application;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class GameSave {

    private String gameName;

    //true once the player has died. While true, autosave is paused so a death is never written to the save
    private static boolean playerDead = false;

    public static boolean isPlayerDead() {
        return playerDead;
    }

    public static void setPlayerDead(boolean dead) {
        playerDead = dead;
    }

    public GameSave(String gameName) {    //links this object to a save file (does not touch the file)
        this.gameName = gameName;
    }

    public String getGameName() {  //get name of file
        return gameName;
    }

    //creates the save file, or empties it if it already exists (used for New Game)
    public void reset() {
        try {
            Files.writeString(Path.of(gameName), "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //all locations by the id used in the save file
    private static Map<String, Location> locationMap(Main game) {
        Map<String, Location> map = new LinkedHashMap<>();
        map.put("start", game.getStart());
        map.put("castle", game.getCastle());
        map.put("cliff", game.getCliff());
        map.put("beach", game.getBeach());
        map.put("cave", game.getCave());
        map.put("tower", game.getTower());
        map.put("forest", game.getForest());
        map.put("village", game.getVillage());
        map.put("hut", game.getHut());
        return map;
    }

    private static String idOf(Map<String, Location> map, Location location) {
        for (Map.Entry<String, Location> entry : map.entrySet()) {
            if (entry.getValue() == location) {
                return entry.getKey();
            }
        }
        return "start";
    }

    private static void put(Properties p, String key, boolean value) {
        p.setProperty(key, String.valueOf(value));
    }

    private static boolean get(Properties p, String key) {
        return Boolean.parseBoolean(p.getProperty(key, "false"));
    }

    //writes the current game state (location, items, story progress) to the save file
    public void save(Main game) {
        Properties p = new Properties();
        Map<String, Location> locations = locationMap(game);

        //where the player is
        p.setProperty("location", idOf(locations, game.getCurrentLocation()));

        //which locations have been visited
        for (Map.Entry<String, Location> entry : locations.entrySet()) {
            put(p, "visited." + entry.getKey(), entry.getValue().hasBeenHere);
        }

        //items
        put(p, "start.hasGold", game.getStart().isHasGold());
        put(p, "beach.hasFish", game.getBeach().isHasFish());
        put(p, "beach.hasSteeringWheel", game.getBeach().isHasSteeringWheel());
        put(p, "beach.hasKingsSword", game.getBeach().isHasKingsSword());
        put(p, "cave.hasKey", game.getCave().isHasKey());
        put(p, "castle.hasLamb", game.getCastle().isHasLamb());
        put(p, "village.hasSword", game.getVillage().isHasSword());
        put(p, "village.hasStrangeBox", game.getVillage().isHasStrangeBox());
        put(p, "village.hasVillageGold", game.getVillage().isHasVillageGold());

        //story progress
        put(p, "forest.hasFoundSteeringWheel", game.getForest().isHasFoundSteeringWheel());
        put(p, "cave.hasReadLetters", game.getCave().isHasReadLetters());
        put(p, "castle.obeyDarkKing", game.getCastle().isObeyDarkKing());
        put(p, "hut.beenToHut", game.getHut().isBeenToHut());
        put(p, "hut.trained", game.getHut().isTrained());
        put(p, "tower.talkedToPrincess", game.getTower().isTalkedToPrincess());

        try (Writer writer = Files.newBufferedWriter(Path.of(gameName))) {
            p.store(writer, "Adventure Game Save");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //reads the save file and puts everything back into the game
    //returns false if there was nothing to load (brand new save)
    public boolean load(Main game) {
        Path path = Path.of(gameName);
        if (!Files.exists(path)) {
            return false;
        }

        Properties p = new Properties();
        try (Reader reader = Files.newBufferedReader(path)) {
            p.load(reader);
        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }

        Map<String, Location> locations = locationMap(game);
        Location saved = locations.get(p.getProperty("location"));
        if (saved == null) {
            return false;   //empty or unreadable save, start from the beginning
        }

        game.setCurrentLocation(saved);

        for (Map.Entry<String, Location> entry : locations.entrySet()) {
            entry.getValue().hasBeenHere = get(p, "visited." + entry.getKey());
        }

        game.getStart().setHasGold(get(p, "start.hasGold"));
        game.getBeach().setHasFish(get(p, "beach.hasFish"));
        game.getBeach().setHasSteeringWheel(get(p, "beach.hasSteeringWheel"));
        game.getBeach().setHasKingsSword(get(p, "beach.hasKingsSword"));
        game.getCave().setHasKey(get(p, "cave.hasKey"));
        game.getCastle().setHasLamb(get(p, "castle.hasLamb"));
        game.getVillage().setHasSword(get(p, "village.hasSword"));
        game.getVillage().setHasStrangeBox(get(p, "village.hasStrangeBox"));
        game.getVillage().setHasVillageGold(get(p, "village.hasVillageGold"));

        game.getForest().setHasFoundSteeringWheel(get(p, "forest.hasFoundSteeringWheel"));
        game.getCave().setHasReadLetters(get(p, "cave.hasReadLetters"));
        game.getCastle().setObeyDarkKing(get(p, "castle.obeyDarkKing"));
        game.getHut().setBeenToHut(get(p, "hut.beenToHut"));
        game.getHut().setTrained(get(p, "hut.trained"));
        game.getTower().setTalkedToPrincess(get(p, "tower.talkedToPrincess"));

        return true;
    }

    //readable name of the player's current location, for the welcome back message
    public static String locationName(Main game) {
        String id = idOf(locationMap(game), game.getCurrentLocation());
        if (id.equals("start")) {
            return "The Crossroads";
        }
        return "The " + Character.toUpperCase(id.charAt(0)) + id.substring(1);
    }

    //list of items the player is currently carrying
    public static String inventory(Main game) {
        List<String> items = new ArrayList<>();
        if (game.getVillage().isHasVillageGold() || game.getStart().isHasGold()) items.add("Gold");
        if (game.getBeach().isHasFish()) items.add("Fish");
        if (game.getBeach().isHasSteeringWheel()) items.add("Ship's steering wheel");
        if (game.getCave().isHasKey()) items.add("Small silver key");
        if (game.getVillage().isHasStrangeBox()) items.add("Strange box");
        if (game.getVillage().isHasSword()) items.add("Sword");
        if (game.getBeach().isHasKingsSword()) items.add("King Aldric's sword");
        if (game.getCastle().isHasLamb()) items.add("Lamb");
        return items.isEmpty() ? "Nothing" : String.join(", ", items);
    }

    public static void death(TextArea outputBox, Button option1, Button option2, Button option3) {
    	playerDead = true;   //stops autosave so this death is never saved
    	outputBox.appendText("""
    			
    			----------------------------------------------
    			You have DIED!
    			
    			You made the wrong series of decisions
    			
    			Feel free to try again using the button at the botton of your screen!
    			
    			""");
    	option2.setVisible(false);
    	option3.setVisible(false);
    	option1.setText("Retry Aventure");
    	option1.setOnAction(e -> {
    		//TODO make function to reset save file and start over game
    	});
    }
    public void adventureComplete(TextArea outputBox, Button option1, Button option2, Button option3) {
    	
    	
    	
    	option3.setVisible(false);
    	option1.setText("Retry Aventure");
    	option2.setText("Exit Game");
    	option1.setOnAction(e -> {
    		//TODO make function to reset save file and start over game
    	});
    	option2.setOnAction(e -> {
    		//TODO exit window
    	});
    }

}