package no.ntnu.tdt4240.models;
import no.ntnu.tdt4240.views.GridView;
import no.ntnu.tdt4240.views.PlayerView;
import android.text.style.ForegroundColorSpan;

public class GameBoard {

	private Cell[][] gameBoard;
	private GridView view;
	private int height = 15;
	private int width = 21;

	public GameBoard(){

		this.gameBoard= new Cell[height+1][width+1];
	}

	public void addGold(int gold){
		while(gold > 0){
			int xValue = (int) (1+Math.random()*height);
			int yValue = (int) (1+Math.random()*width);

			if(gameBoard[xValue][yValue] == null){
				gameBoard[xValue][yValue] = new Gold();
				gold--;
			}
		}
	}

	public void addMines(int mines){
		while(mines > 0){

			int xValue=(int) (1+Math.random()*height);
			int yValue=(int) (1+Math.random()*width);

			if(gameBoard[xValue][yValue]==null){
				gameBoard[xValue][yValue]= new Mine();
				mines--;
			}

		}	
	}

	public void addBlanks(){

		for(int a=1; a<height;a++){
			for(int b=1; b<width; b++){

				if(gameBoard[a][b]==null){
					int numberOfAdjacentGold = 0;
					int numberOfAdjacentMines = 0;

					for(int c=a-1; c<a+1;c++){
						for(int d=b-1; d<b+1; d++){
							if(c>0&&d>0&&c<height&&d<width){
							
							if(gameBoard[c][d].getType()=="gold"){
								numberOfAdjacentGold++;
							}
							if(gameBoard[c][d].getType()=="Mine"){
								numberOfAdjacentMines++;
							}		
							gameBoard[a][b]=new Blank(numberOfAdjacentGold, numberOfAdjacentMines);
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
