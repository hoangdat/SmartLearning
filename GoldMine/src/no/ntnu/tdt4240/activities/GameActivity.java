package no.ntnu.tdt4240.activities;

import no.ntnu.tdt4240.R;
import no.ntnu.tdt4240.models.GameBoard;
import no.ntnu.tdt4240.models.GameMode;
import no.ntnu.tdt4240.models.GoldMineMode;
import no.ntnu.tdt4240.models.Player;
import no.ntnu.tdt4240.views.Cell;
import no.ntnu.tdt4240.views.PlayerView;
import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;

public class GameActivity extends Activity  {

	private Player activePlayer;
	Player player1 = new Player("Player 1");
	Player player2 = new Player("Player 2");
	GameBoard gameBoard;
	GridView mineField;
	GameMode gameMode;
	PlayerView view1;
	PlayerView view2;
	
	TextView middleText;
	
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
		player1.makeActive(this);
		player2.makeDeactive(this);
		
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
		
		middleText = (TextView) findViewById(R.id.middleTextView);
		
		Typeface tf = Typeface.createFromAsset(getAssets(), "font/baveuse.otf");
		middleText.setTypeface(tf);
		middleText.setVisibility(View.GONE);
	}

	private void setGameMode() {
		gameMode = new GoldMineMode(this);
	}

	private void createPlayerViews() {
		view1 = (PlayerView) findViewById(R.id.playerView1);
		player1.setPlayerView(view1);

		view2 = (PlayerView) findViewById(R.id.playerView2);
		player2.setPlayerView(view2);
	}

	public void switchPlayer() {
		
		
		if (activePlayer == player1) {
			view2.makeActive(this);
			activePlayer = player2;
			view1.makeDeactive(this);
		} else {
			view1.makeActive(this);
			activePlayer = player1;
			view2.makeDeactive(this);
		}
		view1.invalidate();
		view2.invalidate();
		
		middleText.setText(activePlayer.toString());
		Animation fadeout = AnimationUtils.loadAnimation(this, R.anim.fadeout);
		middleText.setVisibility(View.VISIBLE);
		middleText.startAnimation(fadeout);
		middleText.setVisibility(View.INVISIBLE);
		
		
	}

	public void addToScore(int scoreChange) {
		activePlayer.addToScore(scoreChange);
	}

	public void endGame() {
		Player winner = gameMode.desideWinner(player1, player2);
		
		middleText.setText(winner + " WON!");
		middleText.setVisibility(View.VISIBLE);
	}

}
