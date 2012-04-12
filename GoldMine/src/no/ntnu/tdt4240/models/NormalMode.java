package no.ntnu.tdt4240.models;

import no.ntnu.tdt4240.activities.GameActivity;
import no.ntnu.tdt4240.views.Blank;
import no.ntnu.tdt4240.views.Cell;
import no.ntnu.tdt4240.views.Gold;
import no.ntnu.tdt4240.views.Mine;

public class NormalMode extends GameMode {

	public NormalMode(GameActivity ga) {
		super(ga);
	}

	@Override
	public void onClickedCell(Cell cell) {
		if (cell != null) {
			gameActivity.addToScore(calculateScore(cell));
			if (cell instanceof Mine) {
				gameActivity.switchPlayer();
			} else if (cell != null && cell instanceof Blank) {
				gameActivity.switchPlayer();
			}
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
