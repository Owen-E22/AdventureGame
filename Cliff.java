package application;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Cliff extends Location{

	public Cliff() {
		
		
	}

	

	@Override
	public void story(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		option1.setVisible(true);
		option2.setVisible(true);
		option3.setVisible(false);
		
		option1.setText("Go to the edge");
		option2.setText("Sit under tree");
		
		
		outputBox.setText("""
				
				You treck up a long switchback trail finally making it to the summit
				
				At the top stands an enormous tree swaying in the wind
				
				Some of it's leaves fall off and glide off on the wind
				
				You look out over the vast sea below
				
				"Wow it is so peacful up here"
				
				You enjoy a couple minutes to yourself taking in the beauty of nature
				
				Options: 
				
				- Go to the edge of the cliff
				- Sit under the tree
				
				""");
		
		option1.setOnAction(e -> {
			goToEdge(outputBox, option1, option2, option3, option4);
		});
		option2.setOnAction(e -> {
			sitUnderTree(outputBox, option1, option2, option3, option4);
			
		});
		
		
	}
	
	public void goToEdge(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		option1.setVisible(true);
		option2.setVisible(false);
		option3.setVisible(false);
		
		option1.setText("Go to trail");
		
		
		outputBox.setText("""
				
				You walk over to the edge of the cliff
				
				You peer over the side at the large waves crashing against the rocks hundreds of feet below
				
				The wind picks up and causes you to lose balance
				
				You stumble and fall to the ground to stop yourself from tumbling over the edge
				
				Adrenaline pumps through your veins
				
				You realize how quickly a life can end and how precious life is
				
				"It seems I've been given another chance"
				
				"I guess I should use it"
				
				Options:
				
				- Go back to trail
				- Pick a direction to travel
				
				""");
		
		option1.setOnAction(e -> {
			story(outputBox, option1, option2, option3, option4);
		});
		
	}
	public void sitUnderTree(TextArea outputBox, Button option1, Button option2, Button option3, Button option4) {
		option1.setVisible(true);
		option2.setVisible(false);
		option3.setVisible(false);
		
		option1.setText("Go to trail");
		
		
		outputBox.setText("""
				
				You go up to the large tree and take a seet at it's base
				
				A squirrel crawls down the tree and stands next to you
				
				It looks at you with curious eyes
				
				You hold out your hand towards the small creature
				
				It comes close and gives your hand a sniff before cuddling up to you
				
				A sense of peace comes over you as you cherish this moment in nature
								
				""");
		
		option1.setOnAction(e -> {
			story(outputBox, option1, option2, option3, option4);
		});
	}
	

}
