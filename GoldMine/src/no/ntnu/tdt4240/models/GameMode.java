package no.ntnu.tdt4240.models;

import no.ntnu.tdt4240.activities.GameActivity;
import no.ntnu.tdt4240.views.Cell;

public abstract class GameMode {

	protected GameActivity gameActivity;
	
	public GameMode(GameActivity ga) {
		gameActivity = ga;
	}

	public abstract void onClickedCell(Cell cell);
	public abstract int amountOfGold();
	public abstract int numberOfMines();
	
	public abstract boolean isGameOver();
	public abstract int calculateScore(Cell cell);

	public abstract Player decideWinner(Player player1, Player player2);
	
}
