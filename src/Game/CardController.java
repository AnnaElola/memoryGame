package Game;

import java.util.List;

import javafx.event.*;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

public class CardController {

	private Card firstCard, secondCard;
	private PlayField playField;
	private List<Card> cardList;
	
	public CardController(List<Card> cardList, PlayField playField) {
			this.cardList = cardList;
			this.playField = playField;
			
			//Lägg till mouselistener
			for(Card card : cardList) {
				
				card.getCircle().setOnMouseClicked (new EventHandler<javafx.scene.input.MouseEvent>() { 
			         @Override 
			         public void handle(javafx.scene.input.MouseEvent e) { 
				        	 if (card.getCardState() == CardState.HIDDEN) {
				        		 
				        		 card.showCard();
				        		 
				        		 //Vänta 0.5 sek på att kalla på nästa funktion
				        		 Timeline timeline = new Timeline();
				        		 timeline.getKeyFrames().add (new KeyFrame(Duration.millis(500),
				        			        ae -> rememberCard(card)));
				        			timeline.play();
 
				        	 } 		 
			         } 
			      });		
			}
	}
	
	public void rememberCard (Card card) {
		
		if (firstCard == null) 
			firstCard = card;
	 		
	 	else if (secondCard == null) {
	 		secondCard = card;	
	 		checkMatchingCards();
	 	}
	}
	
	public void checkMatchingCards() {
		
		if (firstCard.getColor() == secondCard.getColor()) {
			firstCard.matchedCards();
			secondCard.matchedCards();
			//Kolla om alla kort är matchade
			if(checkAllMatched())
				playField.setText("You won!");
		} 
			
		else {
			firstCard.hideCard();
			secondCard.hideCard();
		}
		
		firstCard = null;
		secondCard = null;
		
	}
	
	public boolean checkAllMatched() {
		Boolean allMatched = true;
		
		for(Card c : cardList){
			if(c.getCardState() != CardState.MATCHED)
				allMatched = false;
		}
		
		return allMatched;
	}
}
