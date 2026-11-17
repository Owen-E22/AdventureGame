package application;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Beach extends Location{
	
	private boolean hasSteeringWheel = false;

	public boolean isHasSteeringWheel() {
		return hasSteeringWheel;
	}



	public void setHasSteeringWheel(boolean hasSteeringWheel) {
		this.hasSteeringWheel = hasSteeringWheel;
	}

	private Main game;
	public Beach(Main game) {
        this.game = game;
    }

	public Beach() {
		
	}

	

	//OK Ive outlined the Beach and Forest so far for you to complete
	//All of the methods you'll have to add the "TextArea outputBox, Button option1, Button option2, Button option3, Button option4" sorry
	//I was trying to go fast so I could get it done
	//I think most variables youll need are already made but im not 100% sure
	//if confused look at Castle for reference, It has any kind of operation youll need anywhere else
	//just copy paste code below into each method and alter as necessary
	
	//option4 is basically just for the shop in the village so dont worry about using it just put it as a parameter just in case
	/*
	 * option1.setVisible(false);
	 * option2.setVisible(false);  if there is less than 3 options just set option3, 2 - false
	 * option3.setVisible(false);
	 * 
	 * option1.setText("");  sets text of button, change for each set of choices
	 * option2.setText("");  
	 * option3.setText("");  if no option 3 then delete this
	 * 
	 * outputBox.setText("""
	 * 
	 * 			outputed text goes here(storyline)
	 * 
	 * 				""");
	 * 
	 * option1.setOnAction(e -> {
	 * 			call option method corrosponding to choice with all parameters
	 * 		});
	 * option2.setOnAction(e -> {
	 * 			call option method corrosponding to choice with all parameters     
	 * 		});
	 * option3.setOnAction(e -> {
	 * 			call option method corrosponding to choice with all parameters    again if no option 3 then delete
	 * 		});
	 * 
	 
	 */
	
	
	
	@Override
	public void story(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		
		//The beach is where the King is able to be found once you get the steering wheel for the boat and the key to his prison
		//The prison will be a cave on the cliff face that you have to use the boat to get too
		//The player will learn this from other people around the map
		
		
		//Some kind of intro to the beach 
		//you see a dock
		
		
		//Options:
		
		//Dock
		//Stroll
		//goForASwim
	}
	
	public void dock() {
		//go out on dock 
		//there is a boat
			
		
		//Options:
		
		//take out boat
		//goForASwim
		//goFishing
		
		
	}
	public void stroll() {
		//walk up and down the beach 
		//nothing happens 
		
		//Options:
		
		//Continue - calls story() again to get other options again
	}
	public void goForASwim() {
		//you dive in the water and get eaten by a shark or something
		
		//make it crazy
		
		//then call GameSave.death(parameters)
	}
	
	
	public void takeBoat() {
		//If(hasSteeringWheel){           use game.getBeach().setHasSteeringWheel(true) in forest to change to true
			//you can take out the boat
		//else
			//cant take out boat  
		
		//Options:
		
		//sail North
		//Sail South
		//Exit Boat
	}
	public void goFishing() {
		
		//math.random to make it a 1 in 6 chance  or something to get fish
		//use outputBox.appendText(); to say if you got a fish or not
		//fish can be sold at sellShop in village (when a fish is caught just say in output "Hmm I wonder if I can sell this somewhere" or something like that)
		
		//Options:
		
		//call dock() again to reset player options
	}
	
	
	
	public void sailNorth() {
		//brief commentary about sailing
		
		//talk about seeing some kind of opening in the cliff face
		
		//if you have hideout key
			//you can sailToCave()
		
		//Options:
		
		//returnToDock
		//Maybe - sailToCave()
	}
	public void sailSouth() {
		//brief commentary about sailing 
		//nothing actually happens
		//can make something fun up that happens
		
		//Options:
		
		//returnToDock
	}
	
	public void returnToDock() {
		//return to the dock
		
		//call dock() with "Continue" button
	}
	public void sailToCave() {
		
		
		//commentary about weaving around jagged rocks as you approach the opening
		//you step of boat and head into the darkness
		
		//you reach a strange door and use the key 
		//you see a man inside
		//you ask his name and he says its Aldric (the old king)
		//you say your hear to help him defeat Dark King
		//He says he is too out of shape from hiding and gives you his sword saying only you can do it
		
		//you take sword and return to boat
		
		
		//Options:
		
		//returnToDock
		
		//
	}
}
