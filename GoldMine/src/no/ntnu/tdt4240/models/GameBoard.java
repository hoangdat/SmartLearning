package no.ntnu.tdt4240.models;

import android.content.Context;
import android.text.InputFilter.LengthFilter;
import android.view.ViewGroup.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;

public class GameBoard {

	private Cell[][] gameBoard = new Cell[15][28];
	//FIX: private
	private int width = 28;
	public int height = 15;

	public Context context;
	
	public GameBoard(Context context) {
		this.context = context;
		createDummyBoard();
	}

	
	private void createDummyBoard() {
		for (int col = 0; col < width; col++) {
			for (int row = 0; row < height; row++) {
				gameBoard[row][col] = new Gold(context);
			}
		}
		
		
	}



	public void addGold(int gold) {
		while (gold > 0) {
			int xValue = (int) (Math.random() * height);
			int yValue = (int) (Math.random() * width);

			if (gameBoard[xValue][yValue] == null) {
				gameBoard[xValue][yValue] = new Gold(null);
				gold--;
			}
		}
	}

	public void addMines(int mines) {
		while (mines > 0) {

			int xValue = (int) (Math.random() * height);
			int yValue = (int) (Math.random() * width);

			if (gameBoard[xValue][yValue] == null) {
				gameBoard[xValue][yValue] = new Mine(null);
				mines--;
			}
		}
	}

	public void addBlanks() {

		for (int a = 1; a < height; a++) {
			for (int b = 1; b < width; b++) {

				if (gameBoard[a][b] == null) {
					int numberOfAdjacentGold = 0;
					int numberOfAdjacentMines = 0;

					for (int c = a - 1; c < a + 1; c++) {
						for (int d = b - 1; d < b + 1; d++) {
							if (c > 0 && d > 0 && c < height && d < width) {

								if (gameBoard[c][d] instanceof Gold) {
									numberOfAdjacentGold++;
								}
								if (gameBoard[c][d] instanceof Mine) {
									numberOfAdjacentMines++;
								}
							gameBoard[a][b]=new Blank(null, numberOfAdjacentGold, numberOfAdjacentMines);
							}
						}
					}
				}
			}
		}
	}

	public void createBoard(int gold, int mines) {
		addGold(gold);
		addMines(mines);
		addBlanks();
	}

	public Cell[][] getGameBoard() {
		return gameBoard;
	}


}
