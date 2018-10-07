package com.scimok.opengamejam2018.mobclicker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class GamePane extends AnchorPane{
	
	private List<Monster> monsters;
	double floor;
	Canvas canvas;
	GraphicsContext gc;
	private long lastSpawn;
	
	public GamePane() {
		super();
		lastSpawn = System.currentTimeMillis();
		monsters = new ArrayList<Monster>();
		canvas = new Canvas(512,512);
		floor = canvas.getHeight()-50;
		gc = canvas.getGraphicsContext2D();
		//Basic background
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		gc.setFill(Color.GREEN);
		gc.fillRect(0, floor, canvas.getWidth(), canvas.getHeight());
		this.getChildren().add(canvas);
	}
	
	public void spawnMonster() {
		if(System.currentTimeMillis()>lastSpawn+MainMenu.getSpawnTime()) {
			monsters.add(Monster.initialize(this));
			lastSpawn = System.currentTimeMillis();
		}
	}
	
	public void drawMonsters() {
		for (Monster monster: monsters) {
			double drawStartH = floor-monster.height;
			gc.setFill(monster.mobCol);
			gc.fillRect(monster.spawnW, drawStartH, monster.width, monster.height);
		}
	}
	
	public void evolveMonsters() {
		for(Monster monster: monsters) {
			monster.checkEvolved();
		}
	}
}