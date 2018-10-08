package com.scimok.opengamejam2018.mobclicker;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.Cursor;
import javafx.scene.Scene;


public class MainMenu extends Application{
	
	private boolean inGame = false;
	private static int spawnTime = 1000;

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
		startBtn.setStyle("-fx-background-color: #00aa00");
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
		Text creditsText = new Text();
		creditsText.setText("Thanks to:\n" + 
				"\n" + 
				"itch.io for putting up the Challenge\n" + 
				"Tom for helping on deployment and assistance (WWTD?)\n" + 
				"To all the folks I did this around - Distractions are nice and kind of key for me");
		credits.setBottom(back);
		credits.setCenter(creditsText);
		Scene scene = new Scene(credits, 512, 512);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public void setHighScoreScene(Stage primaryStage) {
		//sets highscore scene
		Button back = new Button();
		Text textScore = new Text("Soon\u2122");
		back.setText("Back");	
		back.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				setMainMenuScene(primaryStage);
			}			
		});
		BorderPane highScores = new BorderPane();
		highScores.setCenter(textScore);
		highScores.setBottom(back);
		Scene scene = new Scene(highScores, 512, 512);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	@SuppressWarnings("static-access")
	public void setGameScene(Stage primaryStage) {
		//sets game scene
		GamePane gamePane = new GamePane();
		inGame = true;
		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				
				gamePane.spawnMonster();
				gamePane.removeMonsters();
				gamePane.evolveMonsters();
				gamePane.drawMonsters();
				gamePane.updateScore();
			
			}
		};
		timer.start();	
		Button back = new Button();
		back.setText("X");
		back.setStyle("-fx-background-color: #ff0000");
		back.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				inGame = false;
				timer.stop();
				setMainMenuScene(primaryStage);
			}			
		});
		Button pauseHelp = new Button();
		pauseHelp.setText("?");
		pauseHelp.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				if(inGame) {
					inGame = false;
					timer.stop();
				}
				else {
					inGame = true;
					timer.start();
				}
			}			
		});
		
		gamePane.getChildren().add(back);
		gamePane.getChildren().add(pauseHelp);
		gamePane.setTopAnchor(back, 5.0);
		gamePane.setRightAnchor(back, 5.0);
		gamePane.setTopAnchor(pauseHelp, 5.0);
		gamePane.setLeftAnchor(pauseHelp, 5.0);
		Scene scene = new Scene(gamePane, 512, 512);
		scene.getRoot().setCursor(Cursor.CROSSHAIR);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void setSpawnTime() {
		if (spawnTime > 100) spawnTime -= 100;
	}
	
	public static int getSpawnTime() {
		return spawnTime;
	}
}
