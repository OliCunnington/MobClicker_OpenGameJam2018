package com.scimok.opengamejam2018.mobclicker;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
public class Monster extends Button implements EventHandler<ActionEvent>{
	
	private long creationTime;
	private int evolveTime;
	protected Color mobCol;
	protected int spawnW;
	protected int height = 25;
	protected int width = 10;
	protected int lives = 1;
	protected Random random;
	
	private Monster(GamePane parent) {
		super();
		random = new Random();
		mobCol = Color.rgb(random.nextInt(255), random.nextInt(255),random.nextInt(255), 0.9);
		spawnW = random.nextInt((int)parent.getWidth());
		creationTime = System.currentTimeMillis();
		//Evolve time should be 2-5(4.999999) seconds
		evolveTime = (int)(Math.random()*3000)+2000;
		//addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
		
		this.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				lives -= 1;
			}
			
		});
	

	
	}
	
	public static Monster initialize(GamePane parent) {
		
		Monster monster = new Monster(parent);
		return monster;
	}
	
	public void evolve() {
		height += 10;
		width += 5;
		lives += 2;
		//this.setHeight(height);
		//this.setWidth(width);
		creationTime = System.currentTimeMillis();
	}
	
	//TODO checking if System.currentTimeMillis > creationTime + evolveTime...
	
	public void checkEvolved() {
		if (System.currentTimeMillis() >= creationTime + evolveTime) {
			evolve();
		};
	}

	@Override
	public void handle(ActionEvent event) {
		lives -= 1;
		//this does nothing since the boxes on the screen just use the monster
		//co-ordinates and area not actually the monster........... REEEeeeeRRRReEeEeeEeeeEEEE
	}


}
