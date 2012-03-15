package no.ntnu.tdt4240.activities;

import java.util.Observable;
import java.util.Observer;

import no.ntnu.tdt4240.R;
import no.ntnu.tdt4240.models.GameBoard;
import no.ntnu.tdt4240.models.Player;
import no.ntnu.tdt4240.views.PlayerView;
import android.app.Activity;
import android.graphics.Path.FillType;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Event;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;

public class GameActivity extends Activity implements Observer {

	private static final int CELL_SIZE = 50;
	private Player activePlayer;
	Player player1 = new Player("Vegar");
	Player player2 = new Player("Jonas");
	GameBoard gameBoard;
	GridView mineField;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// hide title
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		// Hide notification bar
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.game);
		gameBoard = new GameBoard(this);
		createPlayerViews();
		// gameBoard = new GameBoard();
		mineField = (GridView) findViewById(R.id.MineField);

		// mineFieldView.showMineField(mineField);
		showMineField();
		
	}

	private void createPlayerViews() {

		PlayerView view1 = (PlayerView) findViewById(R.id.playerView1);
		player1.setPlayerView(view1);

		PlayerView view2 = (PlayerView) findViewById(R.id.playerView2);
		player2.setPlayerView(view2);
	}

	private void switchPlayer() {
		if (activePlayer == player1) {
			activePlayer = player2;
		} else {
			activePlayer = player1;
		}
	}

	public void onTouchDown(Event event) {

	}

	public void udateScore(int scoreChange) {

	}

	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	private void showMineField() {
		
	}
	
/*
	private void showMineField() {
		int numberOfRowsInMineField = gameBoard.getGameBoard().length;
		int numberOfColumnsInMineField = gameBoard.getGameBoard()[0].length;
		for (int row = 0; row < numberOfRowsInMineField; row++) {
			TableRow tableRow = new TableRow(this);
			tableRow.setLayoutParams(new LayoutParams(CELL_SIZE * numberOfColumnsInMineField, LayoutParams.WRAP_CONTENT));
//
			for (int column = 1; column < numberOfColumnsInMineField + 1; column++) {
////				gameBoard.getGameBoard()[row][column].setLayoutParams(new LayoutParams(CELL_SIZE, CELL_SIZE));
////				gameBoard.getGameBoard()[row][column].setPadding(0, 0, 0, 0);
//				
				Button b = new Button(this);
				b.setLayoutParams(new LayoutParams(CELL_SIZE, CELL_SIZE));
				b.setText(row + "");
				tableRow.addView(b);
//				//tableRow.addView(gameBoard.getGameBoard()[row][column]);
			}
			mineField.addView(tableRow, new TableLayout.LayoutParams(
					LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
		}
	}
*/

}
