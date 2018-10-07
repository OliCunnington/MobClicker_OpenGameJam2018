package com.scimok.opengamejam2018.mobclicker;

public class Monster {
	
	private long creationTime;
	private int evolveTime;
	private boolean evolved;
	
	public Monster() {
		creationTime = System.currentTimeMillis();
		//Evolve time should be 2-5(4.999999) seconds
		evolveTime = (int)(Math.random()*3000)+2000;
		evolved = false;
	}
	
	public void evovle() {
		evolved = true;
	}
	
	//TODO checking if System.currentTimeMillis > creationTime + evolveTime...

}
