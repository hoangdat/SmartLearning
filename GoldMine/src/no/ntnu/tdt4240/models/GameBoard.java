package no.ntnu.tdt4240.models;

import no.ntnu.tdt4240.activities.SettingsActivity;
import android.content.Context;

public class GameBoard {

	private Cell[][] gameBoard;
	private int numberOfRows, numberOfCols, numberofmines, amountofgold;
	public Context context;

	public GameBoard(Context context) {
		numberOfRows = 15;
		numberOfCols = 22;
		gameBoard = new Cell[numberOfRows][numberOfCols];
		this.context = context;
		numberofmines = SettingsActivity.getNumberOfMines(context);
		amountofgold = SettingsActivity.getAmountOfGold(context);
		createBoard(amountofgold, numberofmines);
		// ta hensyn til at det ikke kan være flere miner/gull enn ruter
	}

	private void addGold(int gold) {
		while (gold > 0) {
			int x = (int) (Math.random() * numberOfCols);
			int y = (int) (Math.random() * numberOfRows);
			if (gameBoard[y][x] == null) {
				gameBoard[y][x] = new Gold(context);
				gold--;
			}
		}
	}

	private void addMines(int mines) {
		while (mines > 0) {
			int x = (int) (Math.random() * numberOfCols);
			int y = (int) (Math.random() * numberOfRows);
			if (gameBoard[y][x] == null) {
				gameBoard[y][x] = new Mine(context);
				mines--;
			}
		}
	}

	private boolean isInsideBounds(int row, int col) {
		return row >= 0 && col >= 0 && row < numberOfRows && col < numberOfCols;
	}

	private void addBlanks() {
		for (int row = 0; row < numberOfRows; row++)
			for (int col = 0; col < numberOfCols; col++)
				if (gameBoard[row][col] == null)
					countAdjacentAndCreateBlank(row, col);
	}

	private void countAdjacentAndCreateBlank(int row, int col) {
		int adjacentGold = 0, adjacentMines = 0;
		for (int y = row - 1; y <= row + 1; y++) { // start one up from the
													// cell...
			for (int x = col - 1; x <= col + 1; x++) { // ...and one left from
														// the cell
				if (isInsideBounds(y, x)) {
					if (gameBoard[y][x] instanceof Gold)
						adjacentGold++;
					if (gameBoard[y][x] instanceof Mine)
						adjacentMines++;
				}
			}
		}
		gameBoard[row][col] = new Blank(context, adjacentGold, adjacentMines);
	}

	public void createBoard(int gold, int mines) {
		addGold(gold);
		addMines(mines);
		addBlanks();
	}

	public Cell[][] getGameBoard() {
		return gameBoard;
	}

	public int getNumberOfRows() {
		return numberOfRows;
	}

	public int getNumberOfCols() {
		return numberOfCols;
	}

	public Cell getCell(int y, int x) {
		return gameBoard[y][x];
	}

	public Cell getCell(int pos) {
		return getCell(pos / numberOfCols, pos % numberOfCols);
	}

	public void rippleFrom(int row, int col) {
		for (int y = row - 1; y <= row + 1; y++) { 
			for (int x = col - 1; x <= col + 1; x++) { 
				if (isInsideBounds(y, x)) {
					if (gameBoard[y][x].needsRipple())
						rippleFrom(y, x);
					gameBoard[y][x].onClick();
				}
			}
		}
	}
}
