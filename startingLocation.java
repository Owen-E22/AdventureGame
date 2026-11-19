package application;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;


public class startingLocation extends Location{
	
	private boolean hasGold = false;
	
	public startingLocation() {
		
		
	} 
	
	private Main game;
	public startingLocation(Main game) {
        this.game = game;
    }//make player go to castle no matter what
	
	
	@Override
	public void story(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		buttonReset(option1, option2, option3, option4);
		if(!hasBeenHere) {
		option1.setVisible(true);
		option2.setVisible(false);
		outputBox.setText("""
			    You wake up finding yourself lying in soft grass.

			    You sit up slowly, taking in your surroundings.

			    "Ugh, my head hurts."

			    "Where am I?"

			    You look around and see four cobblestone roads converging at an intersection.

			    "Hmmm... some roads? I wonder where they lead?"

			    As you approach the intersection, you notice a crude map drawn on a piece of wood.

			    Options:

			    - Option1: Follow one of the four roads
			   
			    """);
		
		option1.setText("Follow a Road");
		option3.setVisible(false);
		

		option1.setOnAction(e -> {
			buttonReset(option1, option2, option3, option4);
		    crossroads(outputBox, option1, option2, option3, option4);
		});
		}
		else {
			buttonReset(option1, option2, option3, option4);
			returned(outputBox);
			
		}
		
	}
	
	
	
	
	
	public void crossroads(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		if(!hasBeenHere) {
		option1.setVisible(true);
		option2.setVisible(false);
		option3.setVisible(false);
		
		option1.setText("Travel to Castle");
		outputBox.setText("""
				
				You see on the map that there is a castle to the North
				
				"I bet if I go to the castle I can find out where I am and what this place is"
				
				You decide to head to the Castle to find some answers
				
				""");
		hasBeenHere = true;
		
		option1.setOnAction(e -> {
			game.setCurrentLocation(game.getCastle());
			
			game.getCurrentLocation().story(outputBox, option1, option2, option3, option4);
			game.updateMap(game.getMapBox());
		});
		}
		else {
			option1.setVisible(false);
			option2.setVisible(false);
			option3.setVisible(false);
			outputBox.setText("""
					
					You reach the crossroads 
					
					Choose a direction to travel
					
					""");
		}
	}
	
	public void returned(TextArea outputBox) {
		
		
		//TODO if hasGold = false prompt to look around again
		outputBox.clear();
		outputBox.setText("""
				
				You reach the crossroads
				
				Choose a direction to travel
				
		    """);
		
	}
	

	public void instructions(TextArea outputBox, Button option1, Button option2, Button option3) {
		
		option1.setText("Start Adventure");
		option2.setVisible(false);
		option3.setVisible(false);
		outputBox.setText("Instructions:\n\n"
				+""
				+ "- The world map is located on the left side of the screen\n"
				+ "- You may move North, South, East, and West using the buttons at the top of your screen if a location is there\n"
				+ "- When prompted, use the 'Option' buttons at the bottom of your screen to choose your path and progress\n\n"
				+ ""
				+ "Whats the goal of this game? \n"
				+ "Thats for you to find out\n"
				+ "Good luck adventurer\n\n"
				+ ""
				+ "Click 'Start Adventure' below to begin!");
		
	}


	public boolean isHasGold() {
		return hasGold;
	}


	public void setHasGold(boolean hasGold) {
		this.hasGold = hasGold;
	}
	
	
}
