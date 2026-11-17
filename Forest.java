package application;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Forest extends Location{
	
	private Main game;
	public Forest(Main game) {
        this.game = game;
    }

	public Forest() {
		
	}

	

	@Override
	public void story(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		//enter forest and see two paths
		
		//Options:
		
		//follow right path
		//follow left path
		
	}
	
	
	
	
	public void rightPath() {
		//you go down the path and see a tree house
		
		// you go up into it and see there is a rope swing to another platform
		
		//Options:
		
		//return to trialhead - story() (add an if statement with a boolean so if you are already in the forest it doesnt say "you enter the forest" in story())\
		//try rope swing
	}
	public void leftPath() {
		//you go down the left path and reach a large fire pit and clearing
		
		// around the fire pit is many logs to sit on 
		// there is a log pile to one side
		
		//Options:
		
		//look around
		//sit by fire pit
	}
	
	public void ropeSwing() {
		//the rope is way too old and rips 
		//you fall to your death
		
		//call GameSave.death()
	}
	
	public void lookAround() {
		//you look around 
		//as you aproach the wood pile you see something hidden behind it
		//you find what looks to be a ships steering wheel
		
		//options:
		
		//sit by fire
		//return to trail head - story()
		
	}
	public void sitAtFirePit() {
		//you sit around waiting for something magical to happen
		//nothing does
		
		//Options:
		
		//look around
		//return to trail head - story()
	}
	
	
	
	

}
