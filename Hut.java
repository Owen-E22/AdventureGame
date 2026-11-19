package application;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Hut extends Location{
	
	private boolean beenToHut = false;
	private boolean trained = false;

	public boolean isBeenToHut() {
		return beenToHut;
	}
	public boolean isTrained() {
		return trained;
	}


	public Hut() {
		
		
	}
	
	private Main game;
	public Hut(Main game) {
        this.game = game;
    }


	@Override
	public void story(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		if(!beenToHut) {
		buttonReset(option1, option2, option3, option4);
		option1.setVisible(true);
		option2.setVisible(true);
		option3.setVisible(false);
		
		option1.setText("Knock");
		option2.setText("Snoop around");
		
		outputBox.setText("""
				
				You approach an old hut that looks a little run down
				
				"Huh I wonder if anyone is home?"
				
				""");
		
		option1.setOnAction(e -> {
			knock(outputBox, option1, option2, option3, option4);
		});
		option2.setOnAction(e -> {
			snoopAround(outputBox, option1, option2, option3, option4);
		});
		}
		else {
			returned(outputBox, option1, option2, option3, option4);
		}
		
	}
	
	
	public void knock(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		option1.setVisible(true);
		option2.setVisible(false);
		option3.setVisible(false);
		
		option1.setText("Continue");
		
		outputBox.setText("""
				
				You walk up to the slightly rotted door and give it a hard knock
				
				No answer
				
				You knock again
				
				No answer again
				
				"Hello is anyone home!"
				
				Suddenly the door opens a crack
				
				Strange man: "Who are you and what do you want"
				
				"Im not sure who I am and I just want to learn more about this place"
				
				Strange man: "More about this place huh?"
				"Well you don't look like your with The Dark Crown"
				"Alright come in, make it quick"
				
				He rushes you inside and quickly closes and locks the door
				
				""");
		
		option1.setOnAction(e -> {
			enterHut(outputBox, option1, option2, option3, option4);
		});
		
	
	}
	public void snoopAround(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		option1.setVisible(true);
		option2.setVisible(false);
		option3.setVisible(false);
		
		option1.setText("Continue");
		
		outputBox.setText("""
				
				You wander around the Hut looking to see if anyone is inside
				
				You pear in a window 
				
				Suddenly a man apears and yells at you
				
				"Can I please come inside I have ome questions for you"
				
				Strange Man: "Hmmm.. well you don't look like your from The Dark Crown so alright"
				
				He lets you in
				
				""");
		
		option1.setOnAction(e -> {
			enterHut(outputBox, option1, option2, option3, option4);
		});
	}
	
	public void enterHut(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		option1.setVisible(true);
		option2.setVisible(true);
		option3.setVisible(false);
		
		option1.setText("Ask about Aldric");
		option2.setText("Ask about helping");
		
		outputBox.setText("""
				
				"Ok, who are you"
				
				Strange Man: "I was once a warrior under King Aldric"
				"I fought in many battles along our great King"
				"I helped fend off The Dark Crown before they overtook this once great kingdom"
				
				"Wow you helped fight them and knew the king?"
				
				Old Warrior: "Yes I did. Now tell me why you are here Traveler?"
				
				"I want to help defeat The Dark Crown and restore this kingdom to what it once was"
				
				Old Warrior: "But why? What do you have to gain?"
				
				"I don't know but I must have been brought here for a reason right?"
				"Maybe thats because you needed help"
				
				Old Warrior: "Well then there is no time to waste"
				"If you want to defeat The Dark Crown you will need Aldrics help and his sword"
				
				
				Options:
				
				- Ask about Aldric
				- Ask about helping
				
				""");
		
		option1.setOnAction(e -> {
			askAboutAldric(outputBox, option1, option2, option3, option4);
		});
		option2.setOnAction(e -> {
			askAboutHelp(outputBox, option1, option2, option3, option4);
		});
	}
	
	public void askAboutAldric(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		beenToHut = true;
		option1.setVisible(true);
		option2.setVisible(false);
		option3.setVisible(false);
		
		option1.setText("Continue");
		
		
		outputBox.setText("""
				
				"Aldric? The Dark King said he was killed when they overtook the castle"
				
				Old Warrior: "Oh no, he escaped and is in hiding somewhere"
				"Where at I do not know"
				
				"Is there anyone who might know where he is?"
				
				Old Warrior: "Yes I believe so"
				"His daughter has been trapped in the Tower a little bit South of here"
				"If you can free her, she should know where to look next"
				"There might be a guard stationed outside"
				"Make sure to distract him first"
				
				"Great thanks for your help!"
				
				
				
				""");
		
		option1.setOnAction(e -> {
			travel(outputBox, option1, option2, option3, option4);
		});
		
	}
	public void askAboutHelp(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		
		beenToHut = true;
		option1.setVisible(true);
		option2.setVisible(false);
		option3.setVisible(false);
		
		option1.setText("Continue");
		
		outputBox.setText("""
				
				"Ok well how can I help"
				
				Old Warrior: "Well King Aldric has been in hiding somewhere but I'm not sure where"
				"However, his daughter does know where he might be hiding"
				
				"Wait I thought Aldric died?"
				"And he has a daughter? Where is she?"
				
				Old Warrior: "No Aldric escaped and made it look like he had been killed"
				"Aldrics daughter is trapped in the Tower a little bit south of here"
				"She will know where to look next"
				"There might be a guard stationed outside"
				"Make sure to distract him first"
				
				"Ok thanks for the info!"
				
				
				
				""");
		option1.setOnAction(e -> {
			travel(outputBox, option1, option2, option3, option4);
		});
		
	}
	
	
	public void travel(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		
		option1.setVisible(false);
		
		outputBox.appendText("""
				
				Choose a direction to travel
				
				""");
	}
	
	
	public void returned(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		
		if(game.getBeach().isHasKingsSword()) {
			option1.setVisible(false);
			option2.setVisible(false);
			option3.setVisible(false);
			
		outputBox.setText("""
				
				"I found Aldric and got his sword!"
				"He told me to come to you so you could teach me how to fight"
				"That way I can defeat The Dark King"
				
				Old Warrior: "That is excellent!"
				"Lets get to it!"
				
				For the next couple days the Old Warrior trains you on how to use Aldrics sword
				
				After training day and night you he thinks you are finally ready to take out The Dark King
				
				Old Warrior: "I think you are ready"
				"Although you have only been trained for a few days and are not a master,
				you should be able to defend yourself to make an escape if need be"
				"You see the secret to Aldrics sword is it is not an ordinary sword"
				"Not only does it pierce The Dark Crowns armour, but it can actually tranform into a quill"
				"You can use this to conceal or trick The Dark King into letting you close and then strike!"
				"Once The Dark King is defeated, his followers will be set free from their curse"
				
				"Alright I will make you proud, thank you for the training"
				
				You are now ready to take this kingdom back for the people, King Aldric, and your freedom
				
				""");
		}
		else {
			
			option1.setVisible(false);
			option2.setVisible(false);
			option3.setVisible(false);
			
			outputBox.setText("""
					
					Old Warrior: "How is the search for the princess and Aldric going?"
					"Well I hope"
					
					You update him on your journey and stay for a nice cup of tea
					
					""");
			
			
		}
	}
	
	
	

}
