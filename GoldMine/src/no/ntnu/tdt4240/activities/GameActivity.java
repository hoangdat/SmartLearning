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
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;

public class GameActivity extends Activity {

	private Player activePlayer;
	Player player1; 
	Player player2;
	GameBoard gameBoard;
	GridView mineField;
	GameMode gameMode;
	PlayerView view1;
	PlayerView view2;
	
	TextView announceView;
	
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
		
		player1 = new Player(SettingsActivity.getPlayer1Name(this));
		player2 = new Player(SettingsActivity.getPlayer2Name(this));
		
		gameBoard = new GameBoard(this, gameMode.amountOfGold(), gameMode.numberOfMines());
		activePlayer = player1;
		createPlayerViews();

		initMineField();
		
		initAnnounceView();

		announceActivePlayer();
	}

	private void initMineField() {
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

	private void initAnnounceView() {
		announceView = (TextView) findViewById(R.id.middleTextView);	
		Typeface tf = Typeface.createFromAsset(getAssets(), "font/baveuse.otf");
		announceView.setTypeface(tf);
		announceView.setVisibility(View.GONE);
	}

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

	private void createPlayerViews() {
		view1 = (PlayerView) findViewById(R.id.playerView1);
		player1.setPlayerView(view1);

		view2 = (PlayerView) findViewById(R.id.playerView2);
		player2.setPlayerView(view2);
		view2.getBackground().setAlpha(255);
		view1.makeActive();
	}

	public void switchPlayer() {
		if (activePlayer == player1) {
			view2.makeActive();
			activePlayer = player2;
			view1.makeDeactive();
		} else { 
			view1.makeActive();
			activePlayer = player1;
			view2.makeDeactive();
		}	
		view1.invalidate();
		view2.invalidate();
		announceActivePlayer();
	}
	
	public void addToScore(int scoreChange) {
		activePlayer.addToScore(scoreChange);
	}

	public void announceActivePlayer() {
		announceView.setText(activePlayer.toString());
		Animation fadeout = AnimationUtils.loadAnimation(this, R.anim.fadeout);
		announceView.setVisibility(View.VISIBLE);
		announceView.startAnimation(fadeout);
		announceView.setVisibility(View.INVISIBLE);
	}
	
	public void announceWinner() {
		Player winner = gameMode.desideWinner(player1, player2);
		
		Bundle bIn = getIntent().getExtras();
		
		Intent intent = new Intent(this, WinnerActivity.class);
		Bundle b = new Bundle();
		b.putString("winner", winner.toString());
		b.putInt("score", winner.getScore());
		b.putString("gamemode", bIn.getString("gamemode"));
		intent.putExtras(b); //Put your id to your next Intent
		startActivity(intent);
		finish();
	}
	
}
