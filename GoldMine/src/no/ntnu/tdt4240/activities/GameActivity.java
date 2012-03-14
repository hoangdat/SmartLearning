package no.ntnu.tdt4240.activities;

import no.ntnu.tdt4240.R;
import no.ntnu.tdt4240.models.GameBoard;
import no.ntnu.tdt4240.models.Player;
import no.ntnu.tdt4240.views.PlayerView;
import android.app.Activity;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Event;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;

public class GameActivity extends Activity {
	
	private static final int CELL_SIZE = 50;
	private Player activePlayer;
	Player player1 = new Player("Vegar");
	Player player2 = new Player("Jonas");	
	GameBoard gameBoard;
	TableLayout mineField;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    
		// hide title
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Hide notification bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.game);
        
        createPlayerViews();
//        gameBoard = new GameBoard();
        mineField = (TableLayout)findViewById(R.id.MineField);
     
        
        //   mineFieldView.showMineField(mineField);
      	showMineField();
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
	
	public void showMineField() {
		// remember we will not show 0th and last Row and Columns
		// they are used for calculation purposes only
		for (int row = 0; row < 16; row++) {
			TableRow tableRow = new TableRow(this);
			tableRow.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT));

			 Button b = new Button(this);
             b.setText("Dynamic Button");
             b.setLayoutParams(new LayoutParams(
                       LayoutParams.FILL_PARENT,
                       LayoutParams.WRAP_CONTENT));
			tableRow.addView(b);
             
//			for (int column = 0; column < gameBoard.width; column++) {
//				gameBoard.gameBoard[row][column].setLayoutParams(new LayoutParams(
//						CELL_SIZE, CELL_SIZE));
//				
//				tableRow.addView(gameBoard.gameBoard[row][column]);
//			}
			
			mineField.addView(tableRow, new TableLayout.LayoutParams(
                    LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT));
		}
	}	
	
}
