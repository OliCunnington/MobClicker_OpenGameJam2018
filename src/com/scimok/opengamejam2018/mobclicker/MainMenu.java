package com.scimok.opengamejam2018.mobclicker;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.Cursor;
import javafx.scene.Scene;


public class MainMenu extends Application{

	public static void main(String[] args) {
		
		launch(args);
		
	}
	
	@Override
	public void start(Stage primaryStage){
		
		primaryStage.setTitle("Mob Clicker 2018");
		
		//Button inits
		Button startBtn = new Button();
		startBtn.setText("Start");
		startBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				
			}
			
		});
		
		Button highScoreBtn = new Button();
		highScoreBtn.setText("Highscores");
		highScoreBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				//Launches Game TODO
			}
			
		});
		
		//setup
		StackPane root = new StackPane();
		root.getChildren().add(startBtn);
		root.getChildren().add(highScoreBtn);
		Scene scene = new Scene(root, 512, 512);
		scene.setCursor(Cursor.CROSSHAIR);
		scene.getCursor();
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	

}
