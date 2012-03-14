package no.ntnu.tdt4240.models;

public class GameBoard {

	private Cell[][] gameBoard = new Cell[15][28];
	private int height = 15;
	private int width = 28;

	public GameBoard(){
		
		createBoard(10, 10);
	}

	public void addGold(int gold){
		while(gold > 0){
			int xValue = (int) (Math.random()*height);
			int yValue = (int) (Math.random()*width);

			if(gameBoard[xValue][yValue] == null){
				gameBoard[xValue][yValue] = new Gold(null);
				gold--;
			}
		}
	}
	public void addMines(int mines){
		while(mines > 0){

			int xValue=(int) (Math.random()*height);
			int yValue=(int) (Math.random()*width);

			if(gameBoard[xValue][yValue]==null){
				gameBoard[xValue][yValue]= new Mine(null);
				mines--;
			}
		}	
	}
	public void addBlanks(){

		for(int row=1; row<height;row++){
			for(int col=1; col<width; col++){

				if(gameBoard[row][col]==null){
					int numberOfAdjacentGold = 0;
					int numberOfAdjacentMines = 0;

					for(int row2=row-1; row2<row+1;row2++){
						for(int col2=col-1; col2<col+1; col2++){
							if(row2>0&&col2>0&&row2<height&&col2<width){
							
							if(gameBoard[row2][col2] instanceof Gold){
								numberOfAdjacentGold++;
							}
							if(gameBoard[row2][col2] instanceof Mine){
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
}
