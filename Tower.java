package application;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Tower extends Location{

	
	private boolean talkedToPrincess = false;
	public boolean isTalkedToPrincess() {
		return talkedToPrincess;
	}


	public Tower() {
		
	}
	
	private Main game;
	public Tower(Main game) {
        this.game = game;
    }


	@Override
	public void story(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		
		if(!game.getHut().isBeenToHut()) {
		option1.setVisible(true);
		option2.setVisible(true);
		option3.setVisible(false);
		
		option1.setText("Approach guard");
		option2.setText("Sneak around back");
		
		
		outputBox.setText("""
				
				You approach the tall turret 
				
				You see a guard blocking the door at it's base
				
				"I wonder what's up there"
				
				"It must be something important if it's being guarded"
				
				Options:
				
				- Approach the guard
				- Sneak around the back
				
				
				
				""");
		
		option1.setOnAction(e -> {
			approachGuard(outputBox, option1, option2, option3, option4);
			
		});
		option2.setOnAction(e -> {
			sneakAround(outputBox, option1, option2, option3, option4);
		});
		
		
		}
		else {
			option1.setVisible(true);
			option2.setVisible(true);
			option3.setVisible(true);
			
			option1.setText("Approach guard");
			option2.setText("Sneak around back");
			option3.setText("Distract guard");
			
			
			outputBox.setText("""
					
					You approach the tall turret 
					
					You see a guard blocking the door at it's base
					
					"I wonder what's up there"
					
					"It must be something important if it's being guarded"
					
					Options:
					
					- Approach the guard
					- Sneak around the back
					- Distract guard
					
					
					
					""");
			
			option1.setOnAction(e -> {
				approachGuard(outputBox, option1, option2, option3, option4);
				
			});
			option2.setOnAction(e -> {
				sneakAround(outputBox, option1, option2, option3, option4);
			});
			option3.setOnAction(e -> {
				distractGuard(outputBox, option1, option2, option3, option4);
			});
		}
		
		
		
		
	}
	
	public void climbTower(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		outputBox.setText("""
				
				You make your way slowly up the spiral staircase cautious of any more guards
				
				You make it to the top safely
				
				There you reach a large door with a small cutout for letting in food
				
				you pear in the cutout and see a beautiful pricess sitting on her bed
				
				"Pst. Hello"
				
				Princess: "Why hello, who are you and how did you make it up here?"
				
				"I am a traveler and I've come to help find your father and restore this kingdom"
				"I was told by an old warrior to come talk to you and that you might have clues to where Aldric is hiding"
				
				Princess: "Ahhh I see. Alright taveler, I do not know where my father is but he wrote to me many times about going into hiding"
				"If there is any information about where he is it will be in those letters"
				
				"Well where are these letters"
				
				Princess: "Before The Dark Crown trapped me up here, I put them in a box and gave them to someone in the village"
				"Im not sure where they ended up after that but you should start looking there"
				"Once you find the box, you must use the key that I hid in the cave to open it"
				"But be careful, whatever you do don't go down the glowing path!"
				
				"Ok lets go!"
				
				Princess: "You go alone for now"
				"If I leave The Dark Crown will know something is afoot"
				"Halfway down the stairs there is a small room"
				"Hide in there and I will call the guard up here to distract him"
				
				You go down the stairs and find the small room she was talking about
				
				Her plan works and you sneek back out the entrance
				
				""");
		talkedToPrincess = true;
		option1.setOnAction(e -> {
			leave(outputBox, option1, option2, option3, option4);
		});
	}
	
	
	
	public void approachGuard(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		option1.setVisible(true);
		option2.setVisible(true);
		option3.setVisible(false);
		
		option1.setText("Leave");
		option2.setText("Try to get past guard");
		
		
		
		outputBox.setText("""
				
				You approach the guard
				
				"Hello there, what's up in the tower?"
				
				Guard: "Your not supposed to be here"
				"You need to leave right now"
				
				Options: 
				
				- Leave
				- Try to get past guard
				
				""");
		
		option1.setOnAction(e -> {
			leave(outputBox, option1, option2, option3, option4);
			
		});
		option2.setOnAction(e -> {
			getPastGuard(outputBox, option1, option2, option3, option4);
		});
		
	}
	public void sneakAround(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		option1.setVisible(true);
		option2.setVisible(false);
		option3.setVisible(false);
		
		option1.setText("Continue");
		
		
		
		
		outputBox.setText("""
				
				You sneak around to the back of the tower in the brush looking for another way in
				
				There is nothing but the smooth brick wall of the tower
				
				You realize that there is only one way in and out
				
				""");
		
		option1.setOnAction(e -> {
			leave(outputBox, option1, option2, option3, option4);
			
		});
		
	}
	public void distractGuard(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		option1.setVisible(true);
		option2.setVisible(false);
		option3.setVisible(false);
		
		option1.setText("Continue");
		
		
		
		
		outputBox.setText("""
				
				You remember what the warrior from the hut said about distracting the guard
				
				You pick up a rock nearby and throw it into the bushes off to the side
				
				The guard notices the sudden noise and heads over to check it out
				
				While he is gone you sneak throught the doorway
				
				
				""");
		
		option1.setOnAction(e -> {
			climbTower(outputBox, option1, option2, option3, option4);
			
		});
	}
	
	
	public void getPastGuard(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		option1.setVisible(false);
		option2.setVisible(false);
		option3.setVisible(false);
		
		outputBox.appendText("""
				
				You attempt to ignore the guard and go past him
				
				Guard: "Stop now or face the consequeces!"
				
				Despite the guards warning, you try to shove past him
				
				He doesn't budge
				
				He draws his sword and you feel a burning sensation in your stomach before you fall over
				
				""");
		
		
		//die
	}
	
	public void leave(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		option1.setVisible(false);
		option2.setVisible(false);
		option3.setVisible(false);
		
		outputBox.appendText("""
				
				Choose a direction to travel
				
				""");
	}
	
	
	
	
	
	
	
	
	
}
