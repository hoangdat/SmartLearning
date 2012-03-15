package no.ntnu.tdt4240.models;

import android.content.Context;

public class GameBoard {

	private Cell[][] gameBoard = new Cell[15][28];
	private int nrRows = 15;
	private int nrCols = 28;

	public Context context;
	
	public GameBoard(Context context) {
		this.context = context;
		createDummyBoard();
	}

	
	private void createDummyBoard() {
		for (int row = 0; row < nrRows; row++) {
			for (int col = 0; col < nrCols; col++) {
				gameBoard[row][col] = new Gold(context);
			}
		}
	}

	public void addGold(int gold){
		while(gold > 0){
			int xValue = (int) (Math.random()*nrRows);
			int yValue = (int) (Math.random()*nrCols);

			if(gameBoard[xValue][yValue] == null){
				gameBoard[xValue][yValue] = new Gold(null);
				gold--;
			}
		}
	}
	public void addMines(int mines){
		while(mines > 0){

			int xValue=(int) (Math.random()*nrRows);
			int yValue=(int) (Math.random()*nrCols);

			if(gameBoard[xValue][yValue]==null){
				gameBoard[xValue][yValue]= new Mine(null);
				mines--;
			}
		}	
	}
	public void addBlanks(){

		for(int row=1; row<nrRows;row++){
			for(int col=1; col<nrCols; col++){

				if(gameBoard[row][col]==null){
					int numberOfAdjacentGold = 0;
					int numberOfAdjacentMines = 0;

					for(int rowCheck=row-1; rowCheck<row+1;rowCheck++){
						for(int colCheck=col-1; colCheck<col+1; colCheck++){
							if(rowCheck>0 &&colCheck>0 	&&rowCheck<nrRows &&colCheck<nrCols){
								if(gameBoard[rowCheck][colCheck] != null){
									if(gameBoard[rowCheck][colCheck] instanceof Gold)
										numberOfAdjacentGold++;
									if(gameBoard[rowCheck][colCheck] instanceof Mine)
										numberOfAdjacentMines++;
								}
								gameBoard[row][col]=new Blank(null, numberOfAdjacentGold, numberOfAdjacentMines);
							}
						}
					}
				}
			}	
		}
	}

	public void createBoard(int gold, int mines){
		addGold(gold);
		addMines(mines);
		addBlanks();
	}

	public Cell[][] getGameBoard() {
		return gameBoard;
	}
	public static void main(String[] args){
		new GameBoard();
	}
	public int getNrRows(){
		return nrRows;
	}
	public int getNrCols(){
		return nrCols;
	}
}
