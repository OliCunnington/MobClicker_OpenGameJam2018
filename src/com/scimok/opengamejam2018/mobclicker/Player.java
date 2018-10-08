package com.scimok.opengamejam2018.mobclicker;

public class Player {
	
	private String name;
	protected long score;

	public Player(String name) {
		this.name = name;
		score = 0;
	}
	
	public String getName() {
		return name;
	}

}
