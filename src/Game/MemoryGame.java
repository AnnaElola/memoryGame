package Game;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.Window;  

public class MemoryGame extends Application {

	private static MemoryGame instance;
	private PlayField playField;
	private StartScene startScene;
	private GameCards gameCards;
	private CardController cardController;
	private Stage window;
	
	
	//SINGLETON
	public static MemoryGame getInstance() {
		if(instance == null) {
			instance = new MemoryGame();
		}
		return instance;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		window = primaryStage;
		startScene = new StartScene();
		window.setTitle("Memory game");
		window.setScene(startScene.getScene());
		
		startScene.getButtonStart().setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				gameCards = new GameCards(startScene.getNumberOfCards());
				
				playField = new PlayField(startScene.getNumberOfCards(), startScene.getPlayerName());
				playField.drawBoard(gameCards.getCircleList());
				
				cardController = new CardController(gameCards.getCardList(), playField);
				
				window.setScene(playField.getScene());
				
			}
		});
		
		window.show();

	}
	
	//MAIN
	
	public static void main(String[] args) {
		MemoryGame memoryGame = getInstance();
		launch();
	}

}
