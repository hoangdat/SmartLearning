package no.ntnu.tdt4240.models;

import no.ntnu.tdt4240.activities.GameActivity;

public abstract class GameMode {

	protected GameActivity gameActivity;
	
	public GameMode(GameActivity ga) {
		gameActivity = ga;
	}

	public abstract void switchPlayer(Cell cell);
	public abstract boolean isItGold();
	public abstract boolean isItMines();
	public abstract boolean setTime();
	
	public abstract int calculateScore(Cell cell);
	
}
