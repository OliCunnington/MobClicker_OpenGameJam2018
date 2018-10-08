package com.scimok.opengamejam2018.mobclicker;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class GamePane extends AnchorPane{
	
	private List<Monster> monsters;
	protected double floor;
	protected Canvas canvas;
	private long lastSpawn;
	protected Player player;
	private Text scoreText;
	
	@SuppressWarnings("static-access")
	public GamePane() {
		super();
		scoreText = new Text();
		lastSpawn = System.currentTimeMillis();
		monsters = new ArrayList<Monster>();
		canvas = new Canvas(512,512);
		floor = canvas.getHeight()-50;
		player = new Player("test");
		paintBackground();
		scoreText.setText(player.score+" points");
		scoreText.setStyle("-fx-fill: #ffffff");
		this.getChildren().add(scoreText);
		this.setBottomAnchor(scoreText, 5.0);
		this.setLeftAnchor(scoreText, 5.0);
		this.getChildren().add(canvas);
	}
	
	public void spawnMonster() {
		if(System.currentTimeMillis()>lastSpawn+MainMenu.getSpawnTime()) {
			Monster monster = new Monster(this);
			monsters.add(monster);
			lastSpawn = System.currentTimeMillis();
		}
	}
	
	public void paintBackground() {
		Rectangle mainBack = new Rectangle(0,0,512,512);
		mainBack.setStyle("-fx-fill: #000000");
		this.getChildren().add(mainBack);
	}
	
	public void updateScore() {
		scoreText.setText(player.score+" points");
	}
	public void drawMonsters() {
		this.getChildren().removeAll(monsters);
		for (Monster monster: monsters) {
			double drawStartH = floor-monster.height;
			monster.setY(drawStartH);
			monster.setX(monster.spawnW);
			monster.setHeight(monster.height);
			monster.setWidth(monster.width);
			monster.setStyle(monster.mobCol);
		}
		this.getChildren().addAll(monsters);
	}
	
	public void evolveMonsters() {
		for(Monster monster: monsters) {
			monster.checkEvolved();
		}
	}
	
	public void removeMonsters() {
		/*
		Iterator<Monster> iter = monsters.iterator();
		
		while(iter.hasNext()) {
			Monster monster = iter.next();
			if(monster.lives <= 0) {
				iter.remove();
			}
		}
		*/
		for (int i = 0; i <monsters.size(); i++) {
			if (monsters.get(i).lives <= 0) {
				monsters.get(i).setVisible(false);
				player.score += 1;
				if (player.score % 10 == 0) {
					MainMenu.setSpawnTime();
				}
				monsters.remove(i);
			}
		}
	}

}
