package com.scimok.opengamejam2018.mobclicker;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.Cursor;
import javafx.scene.Scene;


public class MainMenu extends Application{

	public static void main(String[] args) {
		
		launch(args);
		
	}
	
	@Override
	public void start(Stage primaryStage){
		setMainMenuScene(primaryStage);
	}
	
	
	public void setMainMenuScene(Stage primaryStage) {
		//sets main menu scene
		primaryStage.setTitle("Mob Clicker 2018");
		
		//Button inits
		Button startBtn = new Button();
		startBtn.setText("Start");
		startBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				setGameScene(primaryStage);
			}
			
		});
		
		Button highScoreBtn = new Button();
		highScoreBtn.setText("Highscores");
		highScoreBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				setHighScoreScene(primaryStage);
			}
			
		});
		
		Button creditsBtn = new Button();
		creditsBtn.setText("Credits");
		creditsBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				setCreditsScene(primaryStage);
			}
			
		});
		
		//setup
		BorderPane mainMenu = new BorderPane();
		BorderPane extraOptions = new BorderPane();
		mainMenu.setCenter(startBtn);
		extraOptions.setLeft(highScoreBtn);
		extraOptions.setRight(creditsBtn);
		mainMenu.setBottom(extraOptions);
		Scene scene = new Scene(mainMenu, 512, 512);
		primaryStage.setScene(scene);
		primaryStage.show();		
	}
	
	public void setCreditsScene(Stage primaryStage) {
		//sets credits scene
		Button back = new Button();
		back.setText("Back");
		back.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				setMainMenuScene(primaryStage);
			}
			
		});
		BorderPane credits = new BorderPane();
		credits.setCenter(back);
		Scene scene = new Scene(credits, 512, 512);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public void setHighScoreScene(Stage primaryStage) {
		//sets highscore scene
		Button back = new Button();
		back.setText("Back");	
		back.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				setMainMenuScene(primaryStage);
			}
			
		});
		BorderPane highScores = new BorderPane();
		highScores.setCenter(back);
		Scene scene = new Scene(highScores, 512, 512);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void setGameScene(Stage primaryStage) {
		//sets game scene
		Button back = new Button();
		back.setText("X");
		back.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				setMainMenuScene(primaryStage);
			}
			
		});
		//BorderPane game = new BorderPane();
		//BorderPane gameOptions = new BorderPane();
		GamePane gamePane = new GamePane();
		//gameOptions.setRight(back);
		//game.setTop(gameOptions);
		//game.setCenter(gamePane);
		gamePane.getChildren().add(back);
		gamePane.setTopAnchor(back, 5.0);
		gamePane.setRightAnchor(back, 5.0);
		Scene scene = new Scene(gamePane, 512, 512);
		scene.getRoot().setCursor(Cursor.CROSSHAIR);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
