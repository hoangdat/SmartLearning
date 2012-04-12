package no.ntnu.tdt4240.activities;

import java.util.Observable;
import java.util.Observer;

import no.ntnu.tdt4240.R;
import no.ntnu.tdt4240.models.GameBoard;
import no.ntnu.tdt4240.models.GameMode;
import no.ntnu.tdt4240.models.NormalMode;
import no.ntnu.tdt4240.models.Player;
import no.ntnu.tdt4240.views.Cell;
import no.ntnu.tdt4240.views.PlayerView;
import android.app.Activity;
import android.graphics.Path.FillType;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Event;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.Toast;

public class GameActivity extends Activity  {

	private Player activePlayer;
	Player player1 = new Player("Vegar");
	Player player2 = new Player("Jonas");
	GameBoard gameBoard;
	GridView mineField;
	GameMode gameMode;
	
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
		activePlayer = player1;
		createPlayerViews();
		mineField = (GridView) findViewById(R.id.MineField);
		mineField.setPadding(0, 0, 0, 0);
		
		setGameMode();
		
		MineFieldAdapter mineFieldAdapter = new MineFieldAdapter(this, gameBoard);
		mineField.setAdapter(mineFieldAdapter);
		mineField.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
				int row =position/gameBoard.getNumberOfCols();
	            int col=position%gameBoard.getNumberOfCols();
	            
	            if(((Cell)view).needsRipple()) {
	            	gameBoard.rippleFrom(row, col);
	            }
	            	
	            Cell clickedCell = ((Cell)view).onClick();
	            gameMode.onClickedCell(clickedCell);
			}
		});
	}

	private void setGameMode() {
		gameMode = new NormalMode(this);
	}

	private void createPlayerViews() {
		PlayerView view1 = (PlayerView) findViewById(R.id.playerView1);
		player1.setPlayerView(view1);

		PlayerView view2 = (PlayerView) findViewById(R.id.playerView2);
		player2.setPlayerView(view2);
	}

	public void switchPlayer() {
		if (activePlayer == player1) {
			activePlayer = player2;
		} else {
			activePlayer = player1;
		}
	}

	public void addToScore(int scoreChange) {
		activePlayer.addToScore(scoreChange);
	}

}
