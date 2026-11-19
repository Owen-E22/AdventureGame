package application;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Forest extends Location {

	private Main game;
	private boolean hasFoundSteeringWheel = false;

	public boolean isHasFoundSteeringWheel() {
		return hasFoundSteeringWheel;
	}

	public void setHasFoundSteeringWheel(boolean hasFoundSteeringWheel) {
		this.hasFoundSteeringWheel = hasFoundSteeringWheel;
	}

	public Forest(Main game) {
		this.game = game;
	}

	public Forest() {
		this.game = null;
	}

	@Override
	public void story(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {

		//enter forest and see two paths
		//Options:
		//follow right path
		//follow left path

		buttonReset(option1, option2, option3, option4);

		if (!hasBeenHere) {
			outputBox.setText("You enter the forest and come across two paths. One leads to the right and the other leads to the left.");
			hasBeenHere = true;
		} else {
			outputBox.setText("You return to the forest trailhead. Two paths remain in front of you.");
		}

		option1.setText("Follow Right Path");
		option2.setText("Follow Left Path");

		option1.setVisible(true);
		option2.setVisible(true);
		option3.setVisible(false);
		option4.setVisible(false);

		option1.setOnAction(e -> rightPath(outputBox, option1, option2, option3, option4));
		option2.setOnAction(e -> leftPath(outputBox, option1, option2, option3, option4));
	}


	public void rightPath(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {

		//you go down the path and see a tree house
		// you go up into it and see there is a rope swing to another platform
		//Options:
		//return to trialhead - story() (add an if statement with a boolean so if you are already in the forest it doesnt say "you enter the forest" in story())\\
		//try rope swing

		outputBox.setText("You follow the right path and come across a treehouse. You climb up into it and notice an old rope swing leading to another platform.");

		option1.setText("Return to Trailhead");
		option2.setText("Try Rope Swing");

		option1.setVisible(true);
		option2.setVisible(true);
		option3.setVisible(false);
		option4.setVisible(false);

		option1.setOnAction(e -> story(outputBox, option1, option2, option3, option4));
		option2.setOnAction(e -> ropeSwing(outputBox, option1, option2, option3, option4));
	}


	public void leftPath(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {

		//you go down the left path and reach a large fire pit and clearing
		// around the fire pit is many logs to sit on
		// there is a log pile to one side
		//Options:
		//look around
		//sit by fire pit

		outputBox.setText(""" 
				
				You follow the left path and reach a large clearing with a fire pit. There are several logs around the fire to sit on, and a large pile of wood sits off to one side.
				
				""");

		option1.setText("Look Around");
		option2.setText("Sit by Fire Pit");

		option1.setVisible(true);
		option2.setVisible(true);
		option3.setVisible(false);
		option4.setVisible(false);

		option1.setOnAction(e -> lookAround(outputBox, option1, option2, option3, option4));
		option2.setOnAction(e -> sitAtFirePit(outputBox, option1, option2, option3, option4));
	}


	public void ropeSwing(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {

		//the rope is way too old and rips
		//you fall to your death
		//call GameSave.death()

		outputBox.setText("You grab the old rope and swing toward the other platform. Suddenly, the rope begins to rip. Before you can react, it snaps and you fall to the ground below.");

		option1.setVisible(true);
		option2.setVisible(false);
		option3.setVisible(false);
		option4.setVisible(false);

		GameSave.death(outputBox, option1, option2, option3);
	}


	public void lookAround(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {

		//you look around
		//as you aproach the wood pile you see something hidden behind it
		//you find what looks to be a ships steering wheel
		//options:
		//sit by fire
		//return to trail head - story()

		if (!hasFoundSteeringWheel) {
			outputBox.setText("You look around the clearing. As you approach the wood pile, you see something hidden behind it. You find what looks to be a ship's steering wheel.");

			if (game != null && game.getBeach() != null) {
				game.getBeach().setHasSteeringWheel(true);
				hasFoundSteeringWheel = true;
			}
		} else {
			outputBox.setText("You look around the clearing again, but you have already taken the steering wheel.");
		}

		option1.setText("Sit by Fire Pit");
		option2.setText("Return to Trailhead");

		option1.setVisible(true);
		option2.setVisible(true);
		option3.setVisible(false);
		option4.setVisible(false);

		option1.setOnAction(e -> sitAtFirePit(outputBox, option1, option2, option3, option4));
		option2.setOnAction(e -> story(outputBox, option1, option2, option3, option4));
	}


	public void sitAtFirePit(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {

		//you sit around waiting for something magical to happen
		//nothing does
		//Options:
		//look around
		//return to trail head - story()

		outputBox.setText("You sit around the fire pit waiting for something magical to happen. After a while, you realize nothing is going to happen.");

		option1.setText("Look Around");
		option2.setText("Return to Trailhead");

		option1.setVisible(true);
		option2.setVisible(true);
		option3.setVisible(false);
		option4.setVisible(false);

		option1.setOnAction(e -> lookAround(outputBox, option1, option2, option3, option4));
		option2.setOnAction(e -> story(outputBox, option1, option2, option3, option4));
	}

}