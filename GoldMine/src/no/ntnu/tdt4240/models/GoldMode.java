package no.ntnu.tdt4240.models;

import no.ntnu.tdt4240.activities.GameActivity;

public class GoldMode extends GameMode{
	
	public GoldMode(GameActivity ga) {
		super(ga);
		// TODO Auto-generated constructor stub
	}

	//int numberOfMines=R.xml.;
	int numberOfGold;

	@Override
	public void onClickedCell(Cell cell) {
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
	public int calculateScore(Cell cell) {
		if (cell instanceof Gold)
			return 10;
		else
			return 0;
	}
}
