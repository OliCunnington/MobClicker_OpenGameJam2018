package com.scimok.opengamejam2018.mobclicker;

import java.util.Random;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class Monster extends Rectangle{
	
	private long creationTime;
	private int evolveTime;
	protected String mobCol;
	protected int spawnW;
	protected int height = 25;
	protected int width = 10;
	protected int lives = 1;
	protected Random random;
	private String[] colors = {
			"-fx-fill: #42adf4",
			"-fx-fill: #42f47a",
			"-fx-fill: #a142f4",
			"-fx-fill: #f49b42",
			"-fx-fill: #5942f4",
			"-fx-fill: #f44259",
			"-fx-fill: #bf42f4",
			"-fx-fill: #2f6850",
			"-fx-fill: #b53488",
			"-fx-fill: #92a082",
			"-fx-fill: #07448e",
			"-fx-fill: #f7ac0c"};
	
	protected Monster(GamePane parent) {
		super();
		random = new Random();
		mobCol = getColor();
		spawnW = random.nextInt((int)parent.getWidth()-25);
		creationTime = System.currentTimeMillis();
		//Evolve time should be 2-5(4.999999) seconds
		evolveTime = (int)(Math.random()*3000)+2000;
		addEventFilter(MouseEvent.MOUSE_CLICKED, (e -> lives-=1));	
	}

	public void evolve() {
		height += 10;
		width += 5;
		lives += 2;
		creationTime = System.currentTimeMillis();
	}
	
	
	public void checkEvolved() {
		if (System.currentTimeMillis() >= creationTime + evolveTime) {
			evolve();
		};
	}
	
	public String getColor() {
		return colors[random.nextInt(colors.length)];
	}
}
