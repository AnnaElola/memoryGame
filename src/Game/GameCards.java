package Game;

import java.util.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class GameCards {
	
	private List<Card> cardList;
	
	public GameCards(int numberOfCards) {
		//Fulkodning.. 
		if(numberOfCards == 0)
			numberOfCards = 8;
		
		cardList = new ArrayList<Card>();

		Color[] colorList = new Color[]{Color.AQUAMARINE, Color.CADETBLUE, Color.BLUEVIOLET, Color.CORAL, Color.DARKGREEN,
										Color.DEEPPINK, Color.DARKRED, Color.DODGERBLUE, Color.SPRINGGREEN, Color.YELLOW};
		
		for(int i=0; i<numberOfCards/2; i++) {
			//Skapa ett par av korten
			cardList.add(new Card(colorList[i]));
			cardList.add(new Card(colorList[i]));
		}
		Collections.shuffle(cardList);
	}
	
	public List<Card> getCardList(){
		return cardList;
	}
	
	public List<Circle> getCircleList(){
		List<Circle> circleList = new ArrayList<Circle>();
		
		for(Card c : cardList) {
			circleList.add(c.getCircle());
		}
		
		return circleList;
	}

}
