package no.ntnu.tdt4240.models;

import no.ntnu.tdt4240.activities.GameActivity;
import no.ntnu.tdt4240.views.Cell;
import no.ntnu.tdt4240.views.Gold;

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

	@Override
	public boolean isGameOver() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Player desideWinner(Player player1, Player player2) {
		// TODO Auto-generated method stub
		return null;
	}
}
