package application;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Cave extends Location{

	private boolean hasKey = false;
	private boolean hasReadLetters = false;
	
	
	public boolean isHasReadLetters() {
		return hasReadLetters;
	}

	public void setHasReadLetters(boolean hasReadLetters) {
		this.hasReadLetters = hasReadLetters;
	}

	public boolean isHasKey() {
		return hasKey;
	}

	public Cave() {
		
	}
	
	private Main game;
	public Cave(Main game) {
        this.game = game;
    }

	//key to letter box hidden here

	@Override
	public void story(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		option1.setVisible(true);
		option2.setVisible(true);
		option3.setVisible(true);
		
		option1.setText("Right path");
		option2.setText("Glowing path");
		option3.setText("Mine shaft");
		if(hasKey && game.getVillage().isHasStrangeBox()) {
			readLetters(outputBox, option1, option2, option3, option4);
		}
		else {
			outputBox.setText("""
					
					You reach the entrane to a large cave
					
					"It seems like there is three paths"
					
					On the right is a dark path with no lights
					
					On the left is a path with a strange glow coming from it
					
					And right in fron t of you is a elevator that leads down into a mineshaft
					
					"Where Should I go?"
					
					Options:
					
					- Go down right path
					- Go down glowing path
					- Go into mineshaft
					
					""");
			
		}
		
		option1.setOnAction(e -> {
			rightPath(outputBox, option1, option2, option3, option4);
		});
		option2.setOnAction(e -> {
			glowingPath(outputBox, option1, option2, option3, option4);
		});
		option3.setOnAction(e -> {
			mineShaft(outputBox, option1, option2, option3, option4);
		});
		
	}
	
	
	
	
	public void rightPath(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		option1.setVisible(true);
		option2.setVisible(true);
		option3.setVisible(true);
		
		option1.setText("Go for a swim");
		option2.setText("Boat across");
		option3.setText("Turn back");
		
		outputBox.setText("""
				
				You head down the path, grabbing a torch from the wall to light your way
				
				you soon reach a small body of water 
				
				You see strange but cool looking glowing fish in the water
				
				"Wow this is really cool"
				
				Across the water you see there is more tunnel
				
				You also see a small paddle boat sitting nearby
				
				Options: 
				
				- Go for a swim
				- Take the boat to the other side
				- Turn back
				
				""");
		
		option1.setOnAction(e -> {
			goForASwim(outputBox, option1, option2, option3, option4);
		});
		option2.setOnAction(e -> {
			takeBoat(outputBox, option1, option2, option3, option4);
		});
		option3.setOnAction(e -> {
			turnBack(outputBox, option1, option2, option3, option4);
		});
		
	}
	public void glowingPath(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		option1.setVisible(false);
		option2.setVisible(false);
		option3.setVisible(false);
		
		outputBox.setText("""
				
				You decide to head down the strange glowing path
				
				As you get further down the path, you start to feel off
				
				"Something about this glow doesn't feel right"
				
				You start to feel weird and tingly
				
				Suddenly your legs give out and you fall to a knee
				
				your nose starts to bleed
				
				"Something is definitely not right"
				
				Before you can figure out how to get out you collapse
				
				
				""");
		GameSave.death(outputBox, option1, option2, option3);
	}
	public void mineShaft(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		option1.setVisible(true);
		option2.setVisible(true);
		option3.setVisible(false);
		
		option1.setText("Keep going");
		option2.setText("Turn back");
		
		
		outputBox.setText("""
				
				You stand on the elevator and pull the lever
				
				You slowly decend into the dark mineshaft
				
				The elevator hits the ground with a loud thud
				
				You grab a torch from a nearby wall and light it
				
				The mineshaft is illuminated by your flickering torch as you walk through it
				
				"Wow this place is cool"
				"I wonder if anyone works here anymore?"
				
				As if the cave heard you, the wooden support beam next to you cracks loudly
				
				"Whoa, that cant be good"
				
				Options:
				
				- Keep going down the mineshaft
				- Turn Back
				
				""");
		
		option1.setOnAction(e -> {
			keepGoingMineshaft(outputBox, option1, option2, option3, option4);
		});
		option2.setOnAction(e -> {
			turnBack(outputBox, option1, option2, option3, option4);
		});
		
	}
	
	
	public void keepGoingMineshaft(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		option1.setVisible(false);
		option2.setVisible(false);
		option3.setVisible(false);
		
		outputBox.setText("""
				
				Even though it seems the mineshaft might not be stable you decide to keep going deeper
				
				The support beams continue to creak and make earie noises
				
				After a few minutes, it seems your torch barely makes a dent in the sufficating darkness
				
				You hear a strange noise on the wall and put your torch close to see what it is
				
				"Huh, theres some rocks trickling down the wall?"
				
				The mineshaft suddenly collapses crushing you instantly
				
				""");
		GameSave.death(outputBox, option1, option2, option3);
		
	}
	public void turnBack(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		option1.setVisible(true);
		option2.setVisible(false);
		option3.setVisible(false);
		
		option1.setText("Continue");
		
		
		outputBox.setText("""
				
				You decide to head back to the cave entrance 
				
				""");
		
		option1.setOnAction(e -> {
			story(outputBox, option1, option2, option3, option4);
		});
	}
	
	
	public void goForASwim(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		option1.setVisible(false);
		option2.setVisible(false);
		option3.setVisible(false);
		
		outputBox.setText("""
				
				You decide to jump in the water with the cool glowing fish
				
				As you swim around you notice the glowing fish following you
				
				You reach out to touch one
				
				The instant you touch it the fish swarm you
				
				""");
		
		GameSave.death(outputBox, option1, option2, option3);
	}
	public void takeBoat(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		option1.setVisible(true);
		option2.setVisible(false);
		option3.setVisible(false);
		
		option1.setText("Continue");
		
		if(!game.getTower().isTalkedToPrincess()) {
		outputBox.setText("""
				
				 You put the boat in the water and grab the paddles
				 
				 The glowing fish swim underneath you illumiating the cavern
				 
				 You gently bump into the other side and get out of the boat
				 
				 you start walking down the path and find a small room with a table, a desk, and papers everywhere
				 
				 You open a drawer of the desk and find a small silver key
				 
				 "Huh I wonder what this is for?"
				 
				 Not seeing anything else of use, you head back
				 
				""");
		}
		else {
			outputBox.setText("""
					
					 You put the boat in the water and grab the paddles
					 
					 The glowing fish swim underneath you illumiating the cavern
					 
					 You gently bump into the other side and get out of the boat
					 
					 you start walking down the path and find a small room with a table desk and papers everywhere
					 
					 You open a drawer of the desk and find a small silver key
					 
					 "This must be the key to the box with the letters in it that the princess was talking about!"
					 
					 Not seeing anything else of use, you head back
					 
					""");
		}
		hasKey = true;
		option1.setOnAction(e -> {
			story(outputBox, option1, option2, option3, option4);
		});
	}
	
	
	public void readLetters(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		if(hasKey && game.getVillage().isHasStrangeBox()) {
		option1.setVisible(true);
		option2.setVisible(false);
		option3.setVisible(false);
		
		option1.setText("Continue");
		
		if(!hasReadLetters) {
			if(game.getCurrentLocation() == game.getCave()) {  //already has box and is at cave with key
			outputBox.setText("""
					
					 After getting the key to the box of letters you decide to open it
					 
					 You put the key into the keyhole and turn it
					 
					 You open the box and find a stack of letters
					 
					 "Oh boy, I hope the clue to where Aldric is, is at the top"
					 
					 Thankfully it is
					 
					 You open the first letter
					 ---------------------------
					 
					 To my dearest Daughter,
					 I fear The Dark Crown will finally overpower us soon. I am not sure what will come of this kingdom with them in power. 
					 I am afraid of what they might do to you and pray you will be able to escape before they come for you. 
					 Please help the people of this kingdom stay strong in this coming darkness. I plan to go into hiding in a cave on the cliff's face.
					 It will only be accessable by boat and I will have to hope someone will find this letter and come find me when the time is right.
					 Goodluck my beautiful daughter and stay safe.
					 
					 With love,
					 Aldric
					 
					 ----------------------------
					 "Wow King Aldric has been stuck in a cave this whole time"
					 "I better find a boat to go find him"
					 
					 
					""");
		}
		else if(game.getCurrentLocation() == game.getVillage()) {  //already has key and is at village getting box
			outputBox.setText("""
					
					 After getting the box of letters you decide to open it
					 
					 You put the key into the keyhole and turn it
					 
					 You open the box and find a stack of letters
					 
					 "Oh boy, I hope the clue to where Aldric is, is at the top"
					 
					 Thankfully it is
					 
					 You open the first letter
					 ---------------------------
					 
					 To my dearest Daughter,
					 I fear The Dark Crown will finally overpower us soon. I am not sure what will come of this kingdom with them in power.
					 I am afraid of what they might do to you and pray you will be able to escape before they come for you. 
					 Please help the people of this kingdom stay strong in this coming darkness. I plan to go into hiding in a cave on the cliff's face.
					 It will only be accessable by boat and I will have to hope someone will find this letter and come find me when the time is right.
					 Goodluck my beautiful daughter and stay safe.
					 
					 With love,
					 Aldric
					 
					 ----------------------------
					 "Wow King Aldric has been stuck in a cave this whole time"
					 "I better find a boat to go find him"
					 
					 
					""");
		}
			hasReadLetters = true;
			
			if(game.getCurrentLocation()== game.getVillage()) {
				option1.setVisible(false);
			}
			
			
		}
		}
		
		
	}
	

}
