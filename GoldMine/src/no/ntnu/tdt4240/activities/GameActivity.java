package no.ntnu.tdt4240.activities;

import no.ntnu.tdt4240.R;
import no.ntnu.tdt4240.models.GameBoard;
import no.ntnu.tdt4240.models.GameMode;
import no.ntnu.tdt4240.models.GoldMineMode;
import no.ntnu.tdt4240.models.GoldMode;
import no.ntnu.tdt4240.models.Player;
import no.ntnu.tdt4240.views.Cell;
import no.ntnu.tdt4240.views.PlayerView;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class GameActivity extends Activity {

	private Player activePlayer;
	Player player1; 
	Player player2;
	GameBoard gameBoard;
	GridView mineField;
	GameMode gameMode;
	PlayerView playerView1;
	PlayerView playerView2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// hide title
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		// Hide notification bar
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.game);
		
		setGameMode();
		initPlayers();

		gameBoard = new GameBoard(this, gameMode.amountOfGold(), gameMode.numberOfMines());
		activePlayer = player1;
		createPlayerViews();
		initMineField();
	}


	private void initPlayers() {
		player1 = new Player(SettingsActivity.getPlayer1Name(this));
		player1.setImage(R.drawable.cow);
		player2 = new Player(SettingsActivity.getPlayer2Name(this));
		player2.setImage(R.drawable.owl);
	}

	
	/*
	 * Initiate the mine field and set right adapter
	 */
	private void initMineField(){
		mineField = (GridView) findViewById(R.id.MineField);
		mineField.setPadding(0, 0, 0, 0);

		
		MineFieldAdapter mineFieldAdapter = new MineFieldAdapter(this, gameBoard);
		mineField.setAdapter(mineFieldAdapter);
		mineField.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
				int row =position/gameBoard.getNumberOfCols();
				int col=position%gameBoard.getNumberOfCols();

				boolean didRipple = false;
				if(((Cell)view).needsRipple()) {
					gameBoard.rippleFrom(row, col);
					didRipple = true;
				}

				Cell clickedCell = didRipple ? (Cell)view : ((Cell)view).onClick();
				gameMode.onClickedCell(clickedCell);
			}
		});
	}
	
	/*
	 * Get game mode from bundle and create the game
	 */
	private void setGameMode() {

		Bundle b = getIntent().getExtras();
		String gm = b.getString("gamemode");

		if (gm.equals("goldmine")){
			gameMode = new GoldMineMode(this);
		}
		else if (gm.equals("puregold")){
			gameMode = new GoldMode(this);
		}
	}

	/*
	 * Initiate the two player panels at left side
	 */
	private void createPlayerViews() {
		playerView1 = (PlayerView) findViewById(R.id.playerView1);
		player1.setPlayerView(playerView1);

		playerView2 = (PlayerView) findViewById(R.id.playerView2);
		player2.setPlayerView(playerView2);
		playerView2.getBackground().setAlpha(255);
		playerView1.makeActive();
	}

	public void switchPlayer() {
		if (activePlayer == player1) {
			playerView2.makeActive();
			activePlayer = player2;
			playerView1.makeDeactive();
		} else { 
			playerView1.makeActive();
			activePlayer = player1;
			playerView2.makeDeactive();
		}	
	}

	public void addToScore(int scoreChange) {
		activePlayer.addToScore(scoreChange);
	}

	public void announceWinner() {
		Player winner = gameMode.decideWinner(player1, player2);
		
		Bundle bIn = getIntent().getExtras();
		
		Intent intent = new Intent(this, WinnerActivity.class);
		Bundle b = new Bundle();
		b.putString("winner", winner.toString());
		b.putInt("score", winner.getScore());
		b.putString("gamemode", bIn.getString("gamemode"));
		intent.putExtras(b);
		startActivity(intent);
		finish();
	}

}
