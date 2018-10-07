package com.scimok.opengamejam2018.mobclicker;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class Monster extends Button{
	
	private long creationTime;
	private int evolveTime;
	private boolean evolved;
	
	public Monster(GamePane parent) {
		super();
		creationTime = System.currentTimeMillis();
		//Evolve time should be 2-5(4.999999) seconds
		evolveTime = (int)(Math.random()*3000)+2000;
		evolved = false;
		parent.getChildren().add(this);
		this.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				parent.getChildren().remove(this);				
			}	
		});
		
		parent.setBottomAnchor(this, 1.0);
		double rLoc = Math.random()*500;
		parent.setRightAnchor(this, rLoc);
	}
	
	public void evovle() {
		evolved = true;
	}
	
	//TODO checking if System.currentTimeMillis > creationTime + evolveTime...

}
