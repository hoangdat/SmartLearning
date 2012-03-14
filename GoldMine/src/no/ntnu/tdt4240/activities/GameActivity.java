package no.ntnu.tdt4240.activities;

import no.ntnu.tdt4240.R;
import no.ntnu.tdt4240.models.GameBoard;
import no.ntnu.tdt4240.models.GameMode;
import no.ntnu.tdt4240.models.Player;
import no.ntnu.tdt4240.views.MineFieldView;
import no.ntnu.tdt4240.views.PlayerView;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Event;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TableLayout;

public class GameActivity extends Activity {
	
	private Player activePlayer;
	Player player1 = new Player("Vegar");
	Player player2 = new Player("Jonas");	
	GameBoard gameBoard;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    
		// hide title
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Hide notification bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.game);
        
        createPlayerViews();
        
        MineFieldView mineFieldView = (MineFieldView)findViewById(R.id.MineFieldView);
        TableLayout mineField = (TableLayout)findViewById(R.id.MineField);
        mineFieldView.showMineField(mineField);
	}

	private void createPlayerViews() {		

		PlayerView view1 = (PlayerView)findViewById(R.id.playerView1);
		player1.setPlayerView(view1);
		
		PlayerView view2 = (PlayerView)findViewById(R.id.playerView2);
		player2.setPlayerView(view2);
	}
	private void switchPlayer(){
		if(activePlayer==player1){
			activePlayer=player2;	
		}
		else{
			activePlayer=player1;
		}
	}
	public void onTouchDown(Event event){
		
		
	}
}
