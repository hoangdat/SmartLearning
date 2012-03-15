package no.ntnu.tdt4240.views;

import java.security.PublicKey;

import no.ntnu.tdt4240.models.GameBoard;
import no.ntnu.tdt4240.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;

public class MineFieldView extends View {

	private static final int CELL_SIZE = 50;
    private static final int WIDTH = 1000 / CELL_SIZE;
    private static final int HEIGHT = 480 / CELL_SIZE;
    private static GameBoard gameboard;
    
	public MineFieldView(Context context) {
		super(context);
//		gameboard = GameBoard.getGameBoard();
	}
	
	public void setGameBoard(GameBoard gameBoard) {
		this.gameboard = gameBoard;
	}
	
	public void showMineField(TableLayout mineField) {
		// remember we will not show 0th and last Row and Columns
		// they are used for calculation purposes only
//		for (int row = 0; row < gameboard.height; row++) {
//			TableRow tableRow = new TableRow(getContext());
//			tableRow.setLayoutParams(new LayoutParams(
//							CELL_SIZE * gameboard.width, CELL_SIZE));
//
//			for (int column = 0; column < gameboard.width; column++) {
//				gameboard.gameBoard[row][column].setLayoutParams(new LayoutParams(
//						CELL_SIZE, CELL_SIZE));
//				
//				tableRow.addView(gameboard.gameBoard[row][column]);
//			}
//			mineField.addView(tableRow, new TableLayout.LayoutParams(
//					CELL_SIZE * gameboard.width, CELL_SIZE));
//		}
	}	
	/*
	protected void onDraw(Canvas canvas) {
		Paint background = new Paint();
		background.setColor(R.color.background);
		
		Paint gold = new Paint();
		gold.setColor(no.ntnu.tdt4240.R.color.gold);
		
		Paint mine = new Paint();
		mine.setColor(no.ntnu.tdt4240.R.color.mine);
		
		Paint blank = new Paint();
		blank.setColor(no.ntnu.tdt4240.R.color.blank);
		
		canvas.drawRect(0, 0, getWidth(), getHeight(), background);
		
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) {
				if (gameboard[i][j].getType()=="gold"){
					//Draw gold
					canvas.drawRect(
							i * CELL_SIZE, 
							j * CELL_SIZE, 
							(i * CELL_SIZE) + CELL_SIZE, 
							(j * CELL_SIZE) + CELL_SIZE, 
							gold);
				}else if (gameboard[i][j].getType()=="mine"){
					//Draw mine
					canvas.drawRect(
							i * CELL_SIZE, 
							j * CELL_SIZE, 
							(i * CELL_SIZE) + CELL_SIZE, 
							(j * CELL_SIZE) + CELL_SIZE, 
							mine);
				}else{
					//Draw blank
					canvas.drawRect(
							i * CELL_SIZE, 
							j * CELL_SIZE, 
							(i * CELL_SIZE) + CELL_SIZE, 
							(j * CELL_SIZE) + CELL_SIZE, 
							blank);
				}
			}
		}
	}
	*/

}
