package Game;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Card {

	private Circle circleCard;
	private Color color;
	private CardState cardState;
	
	public Card(Color color) {
		circleCard = new Circle(40);		
		circleCard.setFill(Color.WHITE);
		circleCard.setStroke(Color.DARKSLATEGRAY);
		
		this.color = color;
		
		cardState = CardState.HIDDEN;
	}
	
	public void showCard() {
		circleCard.setFill(color);
		cardState = CardState.SHOWING;
	}
	
	public void hideCard() {
		circleCard.setFill(Color.WHITE);
		cardState = CardState.HIDDEN;
	}
	
	public void matchedCards() {
		cardState = CardState.MATCHED;
	}
	
	public Circle getCircle() {
		return circleCard;
	}
	
	public Color getColor() {
		return color;
	}
	
	public CardState getCardState() {
		return cardState;
	}
	
	
}
