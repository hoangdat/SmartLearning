package no.ntnu.tdt4240.models;

import no.ntnu.tdt4240.activities.GameActivity;

public class NormalMode extends GameMode {

	public NormalMode(GameActivity ga) {
		super(ga);
	}

	@Override
	public void onClickedCell(Cell cell) {
		if (cell != null) {
			if (cell instanceof Mine) {
				gameActivity.switchPlayer();
			} else if (cell != null && cell instanceof Blank) {
				gameActivity.switchPlayer();
			}
			gameActivity.addToScore(calculateScore(cell));
		}
	}

	@Override
	public boolean isItGold() {
		return true;
	}

	@Override
	public boolean isItMines() {
		return true;
	}

	@Override
	public int calculateScore(Cell cell) {

		if (cell instanceof Gold)
			return 751;
		else if (cell instanceof Mine)
			return -1344;
		return 0;
	}
}
