package com.scimok.opengamejam2018.mobclicker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class GamePane extends AnchorPane{
	
	private List<Monster> monsters;
	protected List<double[]> clicks;
	protected int i;
	protected double floor;
	protected Canvas canvas;
	protected GraphicsContext gc;
	private long lastSpawn;
	
	public GamePane() {
		super();
		lastSpawn = System.currentTimeMillis();
		monsters = new ArrayList<Monster>();
		clicks = new ArrayList<double[]>();
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
			Monster monster = Monster.initialize(this);
			monsters.add(monster);
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
	
	public void removeMonsters() {
		for(Monster monster: monsters) {
			if(monster.lives == 0) {
				monsters.remove(monster);
			}
		}
	}
	
	public void checkClicks(List<double[]> clicks) {
		for(double[] clickCoOrd: clicks) {
			/* TODO
			 * 
			 *  THIS THROWS CONCURRENT MODIFCATION EXCEPTION
			 * need to check if coOrds fall inside any monster/box coOrd
			 * 
			 * if coOrd[0] in range monster.spawn & +width
			 * &&
			 * if coOrd[0] in range floor-height & floor
			 * 
			 * remove... last instance of?
			 * 
			 * go through monsters backwards?
			 * if hit, remove coOrd & reduce monster lives by 1 > call remove monster. 
			 * test next coOrd
			 * 
			 *
			for(int i=monsters.size()-1;i<=0;i--) {
				if(clickCoOrd[0]>= monsters.get(i).spawnW && clickCoOrd[0] <= (double)(monsters.get(i).spawnW+monsters.get(i).width)) {
					if(clickCoOrd[1]>= floor-monsters.get(i).height && clickCoOrd[1] <= floor) {
						removeMonster(monsters.get(i));
					}
				}
			}
			clicks.remove(clickCoOrd);
			*/
			
			/* THIS CRASHES THE GAME
			for(i = monsters.size()-1; i<=0 ; i--) {
				monsters.removeIf(e -> ((clickCoOrd[0]>= monsters.get(i).spawnW && clickCoOrd[0] <= monsters.get(i).spawnW+monsters.get(i).width)&&(clickCoOrd[1]>= floor-monsters.get(i).height && clickCoOrd[1] <= floor)));
			}
			clicks.remove(clickCoOrd);
			*/
		}
	}
}