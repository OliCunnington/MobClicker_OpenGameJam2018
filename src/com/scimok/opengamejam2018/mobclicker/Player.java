package com.scimok.opengamejam2018.mobclicker;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private int currency;
	private long score;
	private List<Upgrade> upgrades;

	public Player() {
		currency = 0;
		score = 0;
		upgrades = new ArrayList<Upgrade>();
		
	}
}
