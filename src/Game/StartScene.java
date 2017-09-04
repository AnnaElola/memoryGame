package Game;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class StartScene {

	private Scene scene;
	private String nameOfPlayer;
	private int numberOfCards;
	private Button buttonStart;
	private TextField playerName ;
	
	public StartScene() {
		Text textPlayer = new Text("Player name:");
		textPlayer.setFont(new Font(20));
		
		playerName = new TextField();
		
		HBox hBox = new HBox();
		hBox.setAlignment(Pos.CENTER);
		hBox.setSpacing(20);
		ObservableList hBoxList = hBox.getChildren();
		hBoxList.addAll(textPlayer, playerName);
		
		Text textCards = new Text("Number of cards?");
		textCards.setFont(new Font(20));
		
	    ToggleGroup group = new ToggleGroup();
	    
	    RadioButton button1 = new RadioButton("8");
	    button1.setUserData(8);
	    button1.setToggleGroup(group);
	    button1.setSelected(true);
	    
	    RadioButton button2 = new RadioButton("12");
	    button2.setUserData(12);
	    button2.setToggleGroup(group);
	    
	    RadioButton button3 = new RadioButton("16");
	    button3.setUserData(16);
	    button3.setToggleGroup(group);
	    
	    RadioButton button4 = new RadioButton("20");
	    button4.setUserData(20);
	    button4.setToggleGroup(group);
	    
	    group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				numberOfCards = (int) group.getSelectedToggle().getUserData();
				
			}
	      });
	    
		HBox hBox2 = new HBox();
		hBox2.setAlignment(Pos.CENTER);
		hBox2.setSpacing(20);
		ObservableList hBoxList2 = hBox2.getChildren();
		hBoxList2.addAll(textCards, button1, button2, button3, button4);

		buttonStart = new Button("Start");
		buttonStart.setStyle("-fx-outer-border: DARKORANGE; -fx-body-color: CORAL;" + 
				"  -fx-background-color: -fx-outer-border, -fx-body-color;" + 
				"  -fx-background-insets: 0, 2;" + 
				"  -fx-background-radius: 6px, 6px; -fx-font-size: 20px");

		HBox hBox3 = new HBox();
		hBox3.setAlignment(Pos.CENTER);
		ObservableList hBoxList3 = hBox3.getChildren();
		hBoxList3.addAll(buttonStart);
		
		VBox vBox = new VBox(hBox, hBox2, hBox3);
		vBox.setSpacing(40);
		vBox.setAlignment(Pos.CENTER);
		vBox.setStyle("-fx-background-color: BISQUE");
		
		scene = new Scene(vBox, 500, 400);
		
	}
	
	public int getNumberOfCards() {
		return numberOfCards;
	}
	
	public Scene getScene() {
		return scene;
	}
	
	public Button getButtonStart() {
		return buttonStart;
	}
	
	public String getPlayerName() {
		return playerName.getText();
	}
}
