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
    buttonReset(option1, option2, option3, option4);

    if (!hasBeenHere) {
        outputBox.setText("""
                
                You make your way down a narrow path until the trees
                begin to clear.

                Before you lies a vast beach stretching along the coastline.
                Waves crash against the shore as the wind wailed and you notice the
                salty smell of the ocean.

                A dock extends out into the water.
                At the end of it, you can see a boat.

                You wonder what might lie beyond the coastline.

                """);

        hasBeenHere = true;
    }
    else {
        outputBox.setText(""" 
        		
        		You return to the beach.
                
                The waves continue to crash against the shore.
                The wooden dock and small boat remain where you left them.""");
    }

    option1.setText("Go to Dock");
    option2.setText("Stroll Along Beach");
    option3.setText("Go for a Swim");

    option1.setOnAction(e -> {
        buttonReset(option1, option2, option3, option4);
        dock(outputBox, option1, option2, option3, option4);
    });

    option2.setOnAction(e -> {
        buttonReset(option1, option2, option3, option4);
        stroll(outputBox, option1, option2, option3, option4);
    });

    option3.setOnAction(e -> {
        buttonReset(option1, option2, option3, option4);
        goForASwim(outputBox, option1, option2, option3, option4);
    });
}


public void dock(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
    option1.setVisible(true);
    option2.setVisible(true);
    option3.setVisible(true);

    outputBox.setText("""
            
            You walk out onto the wooden dock.
            
            The boards creak beneath your feet as the waves
            gently rock a small boat tied to the dock.
            
            The boat looks old, but it might still be seaworthy.
            
            """);

    option1.setText("Take Out Boat");
    option2.setText("Go for a Swim");
    option3.setText("Go Fishing");

    option1.setOnAction(e -> {
        buttonReset(option1, option2, option3, option4);
        takeBoat(outputBox, option1, option2, option3, option4);
    });

    option2.setOnAction(e -> {
        buttonReset(option1, option2, option3, option4);
        goForASwim(outputBox, option1, option2, option3, option4);
    });

    option3.setOnAction(e -> {
        buttonReset(option1, option2, option3, option4);
        goFishing(outputBox, option1, option2, option3, option4);
    });
}

}

		
	}

	public void stroll(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
    option1.setVisible(true);
    option2.setVisible(false);
    option3.setVisible(false);

    outputBox.setText("""
            
            You decide to take a stroll along the beach.

            The soft sand shifts beneath your feet as you walk
            along the shoreline.

            You find a few scattered shells and pieces of driftwood,
            but nothing particularly interesting.

            After a while, you decide to head back.

            """);

    option1.setText("Continue");

    option1.setOnAction(e -> {
        buttonReset(option1, option2, option3, option4);
        story(outputBox, option1, option2, option3, option4);
    });
}

	public void goForASwim(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
    option1.setVisible(false);
    option2.setVisible(false);
    option3.setVisible(false);
    option4.setVisible(false);

    outputBox.setText("""
            
            You decide to take a swim in the ocean.

            The cold water rushes around your body as you dive
            beneath the waves.

            You swim farther from shore, enjoying the peaceful
            sound of the ocean.

            Suddenly, a massive shadow passes beneath you.

            Before you can react, a gigantic shark bursts through
            the water with its jaws wide open!

            You try desperately to swim away, but it is too late.

            The last thing you see is a wall of teeth before
            everything goes black.

            """);

    GameSave.death(outputBox, option1, option2, option3);
}

	

	public void takeBoat(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
    if (hasSteeringWheel) {
        option1.setVisible(true);
        option2.setVisible(true);
        option3.setVisible(true);

        outputBox.setText("""
                
                You climb into the small boat and inspect its controls.

                With the steering wheel secured in place,
                you are finally able to control the boat.

                The open water stretches out before you.

                """);

        option1.setText("Sail North");
        option2.setText("Sail South");
        option3.setText("Exit Boat");

        option1.setOnAction(e -> {
            buttonReset(option1, option2, option3, option4);
            sailNorth(outputBox, option1, option2, option3, option4);
        });

        option2.setOnAction(e -> {
            buttonReset(option1, option2, option3, option4);
            sailSouth(outputBox, option1, option2, option3, option4);
        });

        option3.setOnAction(e -> {
            buttonReset(option1, option2, option3, option4);
            dock(outputBox, option1, option2, option3, option4);
        });
    }
    else {
        option1.setVisible(true);
        option2.setVisible(false);
        option3.setVisible(false);

        outputBox.setText("""
                
                You climb into the boat and attempt to steer it.

                However, the steering wheel is missing!

                Without it, you have no way of controlling the boat.
                You will need to find a replacement before sailing.

                """);

        option1.setText("Return to Dock");

        option1.setOnAction(e -> {
            buttonReset(option1, option2, option3, option4);
            dock(outputBox, option1, option2, option3, option4);
        });
    }
}


	public void goFishing(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
    option1.setVisible(true);
    option2.setVisible(false);
    option3.setVisible(false);

    outputBox.setText("""
            
            You find an old fishing rod resting against the dock.

            You cast your line into the water and wait patiently.

            """);

    int chance = (int)(Math.random() * 6);

    if (chance == 0) {
        outputBox.appendText("""
                
                Suddenly, you feel a tug on the line!

                You reel it in and discover that you caught a fish.

                Hmm, I wonder if I can sell this somewhere?

                """);
    }
    else {
        outputBox.appendText("""
                
                You wait for what feels like forever.

                Eventually, you pull your line back in.
                Nothing but an empty hook.

                Better luck next time.

                """);
    }

    option1.setText("Return to Dock");

    option1.setOnAction(e -> {
        buttonReset(option1, option2, option3, option4);
        dock(outputBox, option1, option2, option3, option4);
    });
}

	
	
	
	public void sailNorth(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
    option1.setVisible(true);
    option2.setVisible(true);
    option3.setVisible(false);

    outputBox.setText("""

            You steer the boat north along the coastline.

            As you travel farther, you notice a steep cliff
            rising above the water.

            Near the base of the cliff, you spot a dark opening
            that appears to lead into a cave.

            Something about the entrance makes you curious.

            """);

    option1.setText("Return to Dock");
    option2.setText("Investigate the Cave");

    option1.setOnAction(e -> {
        buttonReset(option1, option2, option3, option4);
        returnToDock(outputBox, option1, option2, option3, option4);
    });

    option2.setOnAction(e -> {
        buttonReset(option1, option2, option3, option4);
        sailToCave(outputBox, option1, option2, option3, option4);
    });
}
	public void sailSouth(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
    option1.setVisible(true);
    option2.setVisible(false);
    option3.setVisible(false);

    outputBox.setText("""

            You steer the boat south along the coastline.

            The shoreline stretches into the distance, but
            there is nothing particularly interesting to see.

            After a while, you decide to head back to the dock.

            """);

    option1.setText("Return to Dock");

    option1.setOnAction(e -> {
        buttonReset(option1, option2, option3, option4);
        returnToDock(outputBox, option1, option2, option3, option4);
    });
}
	
	public void returnToDock(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
    option1.setVisible(true);
    option2.setVisible(false);
    option3.setVisible(false);

    outputBox.setText("""

            You guide the boat back toward the dock.

            After tying it securely, you climb out and
            step back onto the wooden boards.

            """);

    option1.setText("Continue");

    option1.setOnAction(e -> {
        buttonReset(option1, option2, option3, option4);
        dock(outputBox, option1, option2, option3, option4);
    });
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
