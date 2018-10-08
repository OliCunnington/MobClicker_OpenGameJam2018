package com.scimok.opengamejam2018.mobclicker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class GamePane extends AnchorPane{
	
	private List<Monster> monsters;
	protected double floor;
	protected Canvas canvas;
	protected GraphicsContext gc;
	private long lastSpawn;
	protected Player player;
	private Text scoreText;
	
	public GamePane() {
		super();
		scoreText = new Text();
		lastSpawn = System.currentTimeMillis();
		monsters = new ArrayList<Monster>();
		canvas = new Canvas(512,512);
		floor = canvas.getHeight()-50;
		gc = canvas.getGraphicsContext2D();
		player = new Player("test");
		scoreText.setText(player.score+" points");
		scoreText.setStyle("-fx-background-color: #ffff00");
		this.getChildren().add(scoreText);
		this.setBottomAnchor(scoreText, 5.0);
		this.setLeftAnchor(scoreText, 5.0);
		
		//onClick
		/*
		this.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				checkClicks(arg0.getSceneX(),arg0.getSceneY());
				System.out.println(arg0.getSceneX()+","+arg0.getSceneY());
			}
			
		});
		
		//Basic background
		
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		gc.setFill(Color.GREEN);
		gc.fillRect(0, floor, canvas.getWidth(), canvas.getHeight());
		*/
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
		
	}
	
	public void updateScore() {
		scoreText.setText(player.score+" points");
	}
	public void drawMonsters() {
		this.getChildren().removeAll(monsters);
		this.paintBackground();
		for (Monster monster: monsters) {
			double drawStartH = floor-monster.height;
			monster.setY(drawStartH);
			monster.setX(monster.spawnW);
			monster.setHeight(monster.height);
			monster.setWidth(monster.width);
			monster.setStyle("-fx-background-color: #ffffff");
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
				monsters.remove(i);
			}
		}
	}
	
	public void checkClicks(double x, double y) {
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
			 */
		
		//This is not crashing... but it does not seem to be changing anything either
		//threw an index out of bounds though, seem to be unable to recreate
		
		// DUUUUH its when you click and there are no monsters spawned
		/*
			for(int i=monsters.size()-1;i<=0;i--) {
				if(x >= monsters.get(i).spawnW && x <= monsters.get(i).spawnW+monsters.get(i).width) {
					if(y >= floor-monsters.get(i).height && y <= floor) {
						monsters.get(i).lives -= 1;
						break;
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
