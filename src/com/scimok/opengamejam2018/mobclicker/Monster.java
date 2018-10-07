package com.scimok.opengamejam2018.mobclicker;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class Monster extends Button{
	
	private long creationTime;
	private int evolveTime;
	private boolean evolved;
	Color mobCol;
	int spawnW;
	int height = 25;
	int width = 10;
	int lives = 1;
	Random random;
	
	private Monster(GamePane parent) {
		super();
		random = new Random();
		mobCol = Color.rgb(random.nextInt(255), random.nextInt(255),random.nextInt(255), 0.9);
		spawnW = random.nextInt((int)parent.getWidth());
		creationTime = System.currentTimeMillis();
		//Evolve time should be 2-5(4.999999) seconds
		evolveTime = (int)(Math.random()*3000)+2000;
		evolved = false;
		/* This is going to change -- i think
		parent.getChildren().add(this);
		this.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				//parent.getChildren().remove(this);				
			}	
		});
		*/
		this.setHeight(height);
		this.setWidth(width);
	}
	
	public static Monster initialize(GamePane parent) {
		
		Monster monster = new Monster(parent);
		return monster;
	}
	public void evolve() {
		evolved = true;
		height += 10;
		width += 5;
		lives += 2;
		this.setHeight(height);
		this.setWidth(width);
		creationTime = System.currentTimeMillis();
	}
	
	//TODO checking if System.currentTimeMillis > creationTime + evolveTime...
	
	public void checkEvolved() {
		if (System.currentTimeMillis() >= creationTime + evolveTime) {
			evolve();
		};
	}

}
