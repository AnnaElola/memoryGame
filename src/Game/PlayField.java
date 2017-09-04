package Game;

import java.util.List;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class PlayField {

	private int width, height;
	private Text text;
	private Scene scene;
	private String playerName;
	
	public PlayField(int numberOfCards, String playerName) {

		switch (numberOfCards){
			case 8:
			case 0:
				height = 400;
				break;
				
			case 12:
				height = 450;
				break;
				
			case 16:
				height = 550;
				break;
				
			case 20:
				height = 650;
		}
		
		width = 500;
		this.playerName = playerName;
	}
	
	public void drawBoard(List<Circle> circleList){
	
		Text player = new Text("Player: " + playerName);
		player.setFill(Color.SKYBLUE);
		player.setFont(new Font(15));
		
		text = new Text("Let the games begin!");
		text.setFont(new Font(20));
		
		VBox vBox = new VBox();
		vBox.setAlignment(Pos.CENTER);
		vBox.setSpacing(20);
		ObservableList vBoxList = vBox.getChildren();
		vBoxList.addAll(player, text);
		
		FlowPane flowPane = new FlowPane(20, 20);
		flowPane.setMaxWidth(400);
		flowPane.setAlignment(Pos.CENTER);
		
		ObservableList flowPaneList =flowPane.getChildren();	
		flowPaneList.addAll(circleList);
		
		VBox vBox2 = new VBox(50, vBox, flowPane);
		vBox2.setAlignment(Pos.CENTER);
		vBox2.setStyle("-fx-background-color: BISQUE");
		
		scene = new Scene(vBox2, width, height);
		scene.setFill(Color.BISQUE);
		
	}
	
	public Scene getScene() {
		return scene;
	}
	
	public void setText(String text) {
		this.text.setText(text);
	}
	
}
