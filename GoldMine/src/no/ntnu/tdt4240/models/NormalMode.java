package no.ntnu.tdt4240.models;

import no.ntnu.tdt4240.activities.GameActivity;

public class NormalMode extends GameMode {

	public NormalMode(GameActivity ga) {
		super(ga);
	}

	@Override
	public void switchPlayer(Cell cell) {
		if (cell != null && cell instanceof Mine) {
			gameActivity.switchPlayer();
		}
		else if (cell != null && cell instanceof Blank){
			gameActivity.switchPlayer();
		}
	}

	@Override
	public boolean isItGold() {
		return true;
	}

	@Override
	public boolean isItMines() {
		return false;
	}

	@Override
	public boolean setTime() {
		return false;
	}

	@Override
	public int calculateScore(Cell cell) {
		return 0;
	}

}
