package com.scimok.opengamejam2018.mobclicker;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private String name;
	private int currency;
	protected long score;
	private List<Upgrade> upgrades;

	public Player(String name) {
		this.name = name;
		currency = 0;
		score = 0;
		upgrades = new ArrayList<Upgrade>();
	}
	
	public String getName() {
		return name;
	}
	public void setScore() {
		score++;
	}
	
	public long getScore() {
		return score;
	}
	
	public void setCurrency(int cashMoney) {
		currency += cashMoney;
	}
	
	public int getCurrency() {
		return currency;
	}
	
	public void setUpgrade(Upgrade upgrade) {
		upgrades.add(upgrade);
	}
	
	public List<Upgrade> getUpgrades(){
		return upgrades;
	}
	
	public boolean isUpgraded(Upgrade upgrade) {
		return upgrades.contains(upgrade);
	}
}
