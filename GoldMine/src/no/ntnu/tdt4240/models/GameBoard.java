package no.ntnu.tdt4240.models;
import android.content.Context;

public class GameBoard{

	private Cell[][] gameBoard;
	private int numberOfRows, numberOfCols;
	public Context context;

	public GameBoard(Context context){
		numberOfRows = 15; 
		numberOfCols = 22;
		gameBoard = new Cell[numberOfRows][numberOfCols];
		this.context = context;
		createBoard(30, 30);
		//ta hensyn til at det ikke kan være flere miner/gull enn ruter
	}

	private void addGold(int gold){
		while(gold > 0){
			int xValue = (int)(Math.random()*numberOfRows);
			int yValue = (int)(Math.random()*numberOfCols);
			if(gameBoard[xValue][yValue] == null){
				gameBoard[xValue][yValue] = new Gold(context);
				gold--;
			}
		}
	}

	private void addMines(int mines){
		while(mines > 0){
			int xValue=(int) (Math.random()*numberOfRows);
			int yValue=(int) (Math.random()*numberOfCols);
			if(gameBoard[xValue][yValue]==null){
				gameBoard[xValue][yValue]= new Mine(context);
				mines--;
			}
		}	
	}

	private boolean isInsideBounds(int row, int col) {
		return row >= 0 && col >= 0 && row < numberOfRows && col < numberOfCols;
	}

	private void addBlanks(){
		for(int row = 0; row < numberOfRows; row++)
			for(int col = 0; col < numberOfCols; col++)
				if(gameBoard[row][col] == null)
					countAdjacentAndCreateBlank(row, col);
	}

	private void countAdjacentAndCreateBlank(int x, int y){
		int adjacentGold = 0, adjacentMines = 0;
		for(int currentRow = x-1; currentRow <= x+1; currentRow++){ //start one up from the cell...
			for(int currentCol = y-1; currentCol <= y+1; currentCol++){ //...and one left from the cell
				if(isInsideBounds(currentRow, currentCol)){
					if(gameBoard[currentRow][currentCol] instanceof Gold)
						adjacentGold++;
					if(gameBoard[currentRow][currentCol] instanceof Mine)
						adjacentMines++;
				}
			}
		}
		gameBoard[x][y] = new Blank(context, adjacentGold, adjacentMines);
	}

	public void createBoard(int gold, int mines){
		addGold(gold);
		addMines(mines);
		addBlanks();
	}

	public Cell[][] getGameBoard() {
		return gameBoard;
	}

	public int getNumberOfRows(){
		return numberOfRows;
	}
	public int getNumberOfCols(){
		return numberOfCols;
	}
	public Cell getCell(int x, int y){
		return gameBoard[x][y];
	}
	public Cell getCell(int pos){
		return getCell( pos/numberOfCols, pos%numberOfCols); 
	}

	public void rippleFrom(int row, int col) {
		/*
		 * Trykk på alle cellene rundt, sjekke om de skal ripples også videre
		 */
	}
}
