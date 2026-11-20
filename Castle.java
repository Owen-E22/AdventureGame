package application;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Castle extends Location{
	
	
	
	
	//check button visibility
	//Aldric in Beach will tell person to go to hut to train sword
	
	
	private Main game;
	public Castle(Main game) {
        this.game = game;
    }
	
	boolean obeyDarkKing = false;
	boolean giveLamb = false;
	
	public boolean isObeyDarkKing() {
		return obeyDarkKing;
	}

	public void setObeyDarkKing(boolean obeyDarkKing) {
		this.obeyDarkKing = obeyDarkKing;
	}

	boolean hasLamb = false;

	public boolean isHasLamb() {
		return hasLamb;
	}

	public void setHasLamb(boolean hasLamb) {
		this.hasLamb = hasLamb;
	}

	public boolean isGiveLamb() { 
		return giveLamb; 
	}
	public void setGiveLamb(boolean giveLamb) { 
		this.giveLamb = giveLamb;
	}

	public Castle() {
		
		
	}

	

	@Override
	public void story(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		buttonReset(option1, option2, option3, option4);
		if(!hasBeenHere) {
			buttonReset(option1, option2, option3, option4);
			outputBox.setText("""
				    
				   The gates towering above you as you aproach the enormous castle
				    
				    You go through gates and enter the great room 
				    
				    The ceiling stands 100 feet high
				    
				    "Wow this place is massive"
				    
				    You look around and see a door to your left and to your right
				    
				    The door to your right seems to lead into a dining room and the door on the left leads down to the dungeon
				    
				    At the other end of the great room you see an ominous throne
				    
				    The back  of the throne is built of tall spears and the seat of healmets of fallen enemies
				    
				    Against the walls stand shadowy guards lurking in the darkness
				    
				    On it sits a tall figure in black spiky armour
				    
				    His head covered by a dark cloak
				    
				    "Huh, I wonder who that is"
				    
				    
				    - Option1: Go to the dining room
				    - Option2: Go down into dungeon
				    - Option3: Approch the throne
				    
				    """);
			
			option1.setText("Dining room");
			option2.setText("Dungeon");
			option3.setText("Approach Throne");
			
			

			option1.setOnAction(e -> {
				buttonReset(option1, option2, option3, option4);
			    //option1 button story
				diningRoom(outputBox, option1, option2, option3, option4);
			});

			option2.setOnAction(e -> {
				buttonReset(option1, option2, option3, option4);
			    //option2 button story
				dungeon(outputBox, option1, option2, option3, option4);
			});
			option3.setOnAction(e -> {
				buttonReset(option1, option2, option3, option4);
			    //option3 button story
				throne(outputBox, option1, option2, option3, option4);
			});
			hasBeenHere = true;
			}
			else {
				buttonReset(option1, option2, option3, option4);
				//second time player has come to loc
				returned(outputBox, option1, option2, option3, option4);
				
			}
		
	}
	
	
	public void diningRoom(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		buttonReset(option1, option2, option3, option4);
		option1.setVisible(true);
		option2.setVisible(false);
		option3.setVisible(false);
		
		outputBox.setText("""
				
				You enter the dining room and see empty plates on the tables
				
				"Huh, I bet they are having some sort of feast tonight"
				
				you circle the long table and arrive at the far wall
				
				On the wall there seems to be a missing portrate
				
				"I wonder who that was"
				
				Suddenly a guard grabs your arm and escorts you out of the dining room
				
				He brings you towards the throne
				
				""");
		
		
		option1.setText("Continue");
		option1.setOnAction(e -> {
			buttonReset(option1, option2, option3, option4);
			throne(outputBox, option1, option2, option3, option4);
		});
	}
	public void dungeon(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		buttonReset(option1, option2, option3, option4);
		option1.setVisible(true);
		option2.setVisible(false);
		option3.setVisible(false);
		
		outputBox.setText("""
				
				You decend into the darkness as you follow the spiral staircase
				
				You reach the bottom after what feels like forever
				
				chained against the wall sits an old, frail looking man
				
				Old man: "Please help"
				
				Before you can respond a guard grabs you and escorts you back upstairs
				
				He brings you towards the throne
				
				""");
		
		
		option1.setText("Continue");
		option1.setOnAction(e -> {
			throne(outputBox, option1, option2, option3, option4);
		});
	}
	public void throne(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		
		option1.setText("Ask about Dark Crown");
		option2.setText("Ask about king");
		option3.setVisible(false);
		
		
		outputBox.setText("""
				
				You begin to approch the throne and are quickly stopped by the shadowy guards
				
				They lower their swords, blocking your path
				
				"Whoa, I come in peace"
				
				The dark kings voice echos throughtout the great room
				
				"LET HIM PASS!"
				
				The guards slowly lift their blades
				
				You walk up to the throne
				
				"KNEEL!"
				
				you tremble in fear as your knees hit the ground
				
				"WHY IS IT YOU HAVE COME HERE!"
				
				"Im trying to find out what this place is your highness"
				
				"THIS IS THE KINGDOM OF ELDERMERE"
				"WE, THE DARK CROWN, HAVE TAKEN THIS REALM FROM THE PREVIOUS KING FOR OURSELVES"
				
				
				- Option1: Ask what the Dark Crown intends to do
				- Option2: Ask about the previous king
				- Option3: Ask morea about the kingom of Eldermere
				""");
		
		option1.setOnAction(e -> {
			buttonReset(option1, option2, option3,option4);
		    //option1 button story
			darkCrown(outputBox, option1, option2, option3, option4);
		});

		option2.setOnAction(e -> {
			buttonReset(option1, option2, option3, option4);
		    //option2 button story
			previousKing(outputBox, option1, option2, option3, option4);
		});
	}
	
	//first choices at castle
	public void darkCrown(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		option1.setVisible(true);
		option2.setVisible(true);
		option3.setVisible(true);

		option1.setText("Submit to Dark Crown");
		option2.setText("Do the right thing");
		option3.setText("Run");
		
		outputBox.setText("""
				
				"What do you intend to do with this realm?"
				
				"WE ARE TAKING ITS WEALTH AND POWER FOR OUSELVES!"
				"SOON THIS REALM WILL BE JUST ANOTHER FALLEN KINGDOM ON OUR PATH TO DOMINION!"
				"YOU HAVE TWO OPTIONS STRANGE TRAVELER!"
				
				"SUBMIT TO THE DARK CROWN!"
				"OR DIE!"
				
				- Option1: Submit to the Dark Crown
				- Option2: Stand up for what is right
				- Option3: Run away
				""");
		
		option1.setOnAction(e -> {
			buttonReset(option1, option2, option3, option4);
		    //option1 button story
			submitToDarkCrown(outputBox, option1, option2, option3, option4);
		});

		option2.setOnAction(e -> {
			buttonReset(option1, option2, option3, option4);
		    //option2 button story
			standUp(outputBox, option1, option2, option3, option4);
		});
		option3.setOnAction(e -> {
			buttonReset(option1, option2, option3, option4);
		    //option3 button story
			runAway(outputBox, option1, option2, option3, option4);
		});
		
	}
	public void previousKing(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		option1.setVisible(true);
		option2.setVisible(true);
		option3.setVisible(false);

		option1.setText("\"Whatever is necessary\"");
		option2.setText("\"Peace and Justice\"");
		
		
		outputBox.setText("""
				
				
				"Wait, you took this kingdom from the previous king?"
				
				"YES, THE PREVIOUS KING, KING ALDRIC WAS WEAK"
				"HE WANTED PEACE AND JUSTICE"
				"THERE IS NO PLACE FOR THAT IN THIS WORLD"
				
				"ME AND MY FORCES OVERTOOK THE CASTLE AND GAINED CONTROL OF THE KINGDOM"
				"KING ALDRIC'S BODY WAS NEVER FOUND"
				"HE MUST HAVE BURNED IN THE WRECKAGE"
				
				"HIS FORCES MAY HAVE BEEN WEAK, BUT ALRIC WAS A TRUE WARRIOR"
				"HIS SWORD OF RADIENCE IS THE ONLY REAL THREAT TO US"
				"TOO BAD IT BURNED WITH HIM"
				
				"WHAT DO YOU THINK TRAVELER?"
				"DO YOU BELIEVE IN USING WHATEVER MEANS NECESSARY TO DO WHAT IS NEEDED?"
				
				
				- Option1: Agree with the Dark King
				- Option2: Agree with King Aldric
				
				
				""");
		
		
		
		option1.setOnAction(e -> {
			buttonReset(option1, option2, option3, option4);
		    //option1 button story
			agreeWithDarkKing(outputBox, option1, option2, option3);
		});

		option2.setOnAction(e -> {
			buttonReset(option1, option2, option3, option4);
		    //option2 button story
			agreeWithAldric(outputBox, option1, option2, option3);
		});
		
	}

	//Throne darkCrown options
	public void submitToDarkCrown(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		obeyDarkKing = true;
		option1.setVisible(true);
		option2.setVisible(true);
		option3.setVisible(false);

		option1.setText("Travel to Village");
		option2.setText("Coninue journey");
		
		
		outputBox.setText("""
				
				Out of the fear of what might happen if you disobey, you agree to submit to the Dark Crown
				
				"GOOD CHOICE"
				
				"SEND THE TRAVELER INTO THE VILLAGE TO FETCH ME A LAMB FOR TONIGHTS FEAST"
				
				The guards escort you out of the castle and show you the way to the village
				
				As the guards recede back into the castle walls, you hear the kings warning
				
				"IF YOU RETURN WITHOUT A LAMB, YOU WILL NOT LIVE TO SEE ANOTHER DAY!"
				
				You quickly run away from the castle
				
				
				- Option1: Travel to the village in search of a lamb
				- Option2: Ignore the kings command and continue on your jouney
				""");
		
		
		
		option1.setOnAction(e -> {
			buttonReset(option1, option2, option3, option4);
		    //option1 button story
			travelToVillage(outputBox, option1, option2, option3, option4);
		});

		option2.setOnAction(e -> {
			buttonReset(option1, option2, option3, option4);
		    //option2 button story
			outputBox.setText("""
					
					Choose a direction to travel
					""");
		});
		
	}
	public void standUp(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		outputBox.setText("""
				
				"I will never bow down to someone like you!"
				"What your doing is wrong!"
				
				"YOU DARE DEFY ME YOU USELESS SCUM!"
				
				"EXECUTE HIM"
				
				Before you can react, a guard beside you unsheaths his sword
				
				"NO! Please!"
				
				Without a second thought the guard swings his sword toward you
				
				The last thing you see is the dark grimace of the guard as his sword completes it's course
				""");
		GameSave.death(outputBox, option1, option2, option3);
	}
	public void runAway(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		option1.setVisible(true);
		option2.setVisible(false);
		option3.setVisible(false);
		
		option1.setText("Continue");

		outputBox.setText("""
				
				You pretend to think about a response to the king while you plan your escape route
				
				Quickly, you sprint towards the castle gate
				
				"GET HIM!"
				
				Dodging and weaving between guards, you finally reach fresh air 
				
				You dont stop running until you reach the crossroads where you woke up
				
				""");
		
		option1.setOnAction(e -> {
			game.setCurrentLocation(game.getStart());
			
			game.getCurrentLocation().story(outputBox, option1, option2, option3, option4);	
		});
	}
	public void travelToVillage(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		option1.setVisible(true);
		option2.setVisible(false);
		option3.setVisible(false);

		option1.setText("Continue");
		
		outputBox.setText("""
				
				Fearing the kings wrath, you quickly make your way to the village
				
				
				
				""");
		option1.setOnAction(e -> {
			game.setCurrentLocation(game.getVillage());
			
			game.getCurrentLocation().story(outputBox, option1, option2, option3, option4);
			game.updateMap(game.getMapBox());
		});
		
	}
	
	//Throne previousKing options
	public void agreeWithDarkKing(TextArea outputBox, Button option1, Button option2, Button option3) {
		option1.setVisible(false);
		option2.setVisible(false);
		option3.setVisible(false);

		
		
		outputBox.setText("""
				
				After hearing the Dark Kings violent story you decide to go along with what he says 
				
				"I agree that sometimes you gotta do what you gotta do no matter the cost"
				
				"AHH GOOD"
				
				"YOU KNOW I LIKE YOU TRAVELER"
				"I DON'T THINK I'LL KILL YOU"
				
				"YOU HAVE GAINED MY FAVOR TODAY"
				"ANOTHER DAY YOU MIGHT NOT BE SO LUCKY"
				
				"YOU MAY LEAVE NOW"
				
				You rise from your knee
				
				"Thank you your Highness, I am greatful"
				
				Without wasting any time, you leave the castle thankful you made it out with your life
				
				"Hmmm... it seems the The Dark Crown will bring ruin to this once prospering kingdom"
				
				"I wonder if there is any way to stop them?"
				
				You ponder this question as the castle fades behind you
				
				---------------------------------------------------------
				
				Choose a direction to travel
				
				""");
	}
	public void agreeWithAldric(TextArea outputBox, Button option1, Button option2, Button option3) {
		option1.setVisible(false);
		option2.setVisible(false);
		option3.setVisible(false);

		outputBox.setText("""
				
				"I think no matter what is needed, violence is never the answer"
				"Peace and justice should always be a priority"
				
				"YOU FOOL"
				"PERHAPS I AM THE ONLY ONE WHO SEE'S IT"
				
				The Dark King pauses for a second and lets out a sigh
				
				"YOU KNOW I GREW A LIKING TO YOU TRAVELER"
				"TOO BAD I MUST KILL YOU NOW"
				
				"GUARD"
				
				With one word and a flick of his hand, a guard behind you unsheaths his sword
				
				you feel a sharp pain in your chest and your vision goes black
				
				""");
		
		GameSave.death(outputBox, option1, option2, option3);
		
	}
	
	
	//after you have been to location before
	public void returned(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		if(obeyDarkKing && !giveLamb) {
			if(!hasLamb) {
				option1.setVisible(false);
				option2.setVisible(false);
				option3.setVisible(false);
			
				outputBox.setText("""
					
					You return to the castel without the lamb that The Dark King had requested
					
					"WHERE IS MY LAMB TRAVELER!"
					
					"I don't have one"
					
					"YOU DISSAPOINT ME"
					
					The Dark King waves his hand at the guard nearby
					
					The guard's sword slices through your neck like butter before you can even blink
					
					""");
			
				GameSave.death(outputBox, option1, option2, option3);
				giveLamb = true;
			}
			else{
			
				option1.setVisible(false);
				option2.setVisible(false);
				option3.setVisible(false);
			
				outputBox.setText("""
					
					"I have brought you the lamb you requested"
					
					"SO YOU HAVE TRAVELER"
					
					"EXCELLENT WORK. YOU HAVE EARNED YOUR LIFE FOR NOW"
					
					You give a guard the lamb and leave quickly
					
					""");
			
				giveLamb = true;
			}
		}
		else if(game.getVillage().isHasSword() || (game.getBeach().isHasKingsSword() && !game.getHut().isTrained())) {
			option1.setVisible(false);
			option2.setVisible(false);
			option3.setVisible(false);
			
			outputBox.setText("""
					
					"YOU DARE BRING A WEAPON INTO MY CASTLE"
					
					"KILL THE TRAVELER"
					
					A guard approaches you
					
					You take out your sword thinking you will be able to defend yourself
					
					The guard swings hard and you barely manage to deflect his blow
					
					The blow brings you to your knees with it's force
					
					You manage to block one more swing before the guard makes it past your poor defense
					
					His sword slices your throat and you bleed out on the castle foor
					
					""");
			GameSave.death(outputBox, option1, option2, option3);
		}
		else if(game.getBeach().isHasKingsSword() && game.getHut().isTrained()) {
			//Game ending
			defeatTheDarkKing(outputBox, option1, option2, option3, option4);
			
		}
		else {
			outputBox.setText("""
					
					You enter the castle great room 
					 
				    - Option1: Go to the dining room
				    - Option2: Go down into dungeon
				    - Option3: Approch the throne
				    
					""");
			
			option1.setText("Dining room");
			option2.setText("Dungeon");
			option3.setText("Approach Throne");
			
			

			option1.setOnAction(e -> {
				buttonReset(option1, option2, option3, option4);
			    //option1 button story
				diningRoom(outputBox, option1, option2, option3, option4);
			});

			option2.setOnAction(e -> {
				buttonReset(option1, option2, option3, option4);
			    //option2 button story
				dungeon(outputBox, option1, option2, option3, option4);
			});
			option3.setOnAction(e -> {
				buttonReset(option1, option2, option3, option4);
			    //option3 button story
				throne(outputBox, option1, option2, option3, option4);
			});
		}
		
	}
	
	public void defeatTheDarkKing(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		option1.setVisible(true);
		option2.setVisible(true);
		option3.setVisible(true);
		
		option1.setText("Propose a work contract");
		option2.setText("Ask for his autograph");
		option3.setText("Draw a sketch");
		
		outputBox.setText("""
				
				You re-enter the Castle and approach The Dark king
				
				"I SEE YOU HAVE COME BACK TRAVELER"
				"WHY HAVE YOU RETURNED?"
				
				You come up with a plan to trick The Dark King
				
				
				Options:
				
				- Propose a work contract
				- Ask for his autograph
				- Draw a sketch
				
				""");
		
		option1.setOnAction(e -> {
			workContract(outputBox, option1, option2, option3, option4);
		});
		option2.setOnAction(e -> {
			autograph(outputBox, option1, option2, option3, option4);
		});
		option3.setOnAction(e -> {
			drawSketch(outputBox, option1, option2, option3, option4);
		});
		
		
	}
	
	public void workContract(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		
		option1.setVisible(true);
		option2.setVisible(false);
		option3.setVisible(false);
		
		option1.setText("Continue");
		
		outputBox.setText("""
				
				You decide to propose a work contract between you and The Dark King
				
				"I would like to pledge my allegience to you and become your servant'
				
				You pull out a makeshift contract for you and The Dark King to sign
				
				"AH, VERY GOOD TRAVELER. BRING YOUR PAPER AND QUILL TO ME"
				
				You approach the throne with the quill gripped tightly in your hand
				
				You kneel at The Dark Kings feet pretending to sign the contract
				
				Before The Dark King has a chance to do anything, you tranform the quil into a sword
				
				You drive it up into his chest from your knee
				
				The Dark King falls before you and turns to dust
				
				""");
		
		option1.setOnAction(e -> {
			victory(outputBox, option1, option2, option3, option4);
		});
		
		
	}
	public void autograph(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		option1.setVisible(true);
		option2.setVisible(false);
		option3.setVisible(false);
		
		option1.setText("Continue");
		
		outputBox.setText("""
				
				You decide to ask The Dark King for his autograph
				
				"I was wondering if I could get your autograph your Highness?"
				
				"AH, AN ADMIRER I SEE. VERY WELL THEN COME OVER HERE AND I WILL SIGN YOUR FOREHEAD"
				
				You approach the throne, your quill gripped tightly in your hand
				
				Reaching the throne you hold out the quill towards The Dark King
				
				Before he can take it, you turn it into a sword
				
				The blade extends straight through The Dark Kings skull and he drops to the floor in dust
				
				""");
		
		option1.setOnAction(e -> {
			victory(outputBox, option1, option2, option3, option4);
		});
	}
	public void drawSketch(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		option1.setVisible(true);
		option2.setVisible(false);
		option3.setVisible(false);
		
		option1.setText("Continue");
		
		outputBox.setText("""
				
				You decide to draw a sketch of the king in order to get close ot him
				
				"I would like to draw a portrait of you to honor you"
				
				"AH, THAT WOULD BE MOST EXCELLENT"
				"COME NEXT TO ME SO YOU CAN GET MY GOOD SIDE"
				
				You approach the throne and take out your quill
				
				"May I use my quill to get some measurements?"
				
				"YES YES OF COURSE"
				
				pretending to use your quill to measure his dimentions, you put it up to his face
				
				In one quick motion you turn it into a sword and slice The Dark Kings head off
				
				
				
				
				""");
		
		option1.setOnAction(e -> {
			victory(outputBox, option1, option2, option3, option4);
		});
	}
	
	//Beat the game
	public void victory(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		
		option1.setVisible(false);
		option2.setVisible(false);
		option3.setVisible(false);
		
		outputBox.setText("""

		        Once The Dark King was deafeated, the rest of The Dark Crown were set free from their curse

		        Their armour turned to dust and they turned into people of the Eldermere

		        The whole kingdom is greatful for your help and bravery

		        Aldric retakes the throne and brings peace once more to Eldermere

		        He makes you a knight in his guard and you become a great warrior

		        You end up marrying Aldric's daughter and have 3 wonderful children

		        Once Aldric passes away you take the throne and keep the kingdom safe

		        THE END

		        """);
		
		
		
	}
	

}
