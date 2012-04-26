package no.ntnu.tdt4240.activities;

import no.ntnu.tdt4240.R;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class WinnerActivity extends Activity implements OnClickListener {

	private String gamemode;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// hide title
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		// Hide notification bar
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.winner);
		
		Bundle b = getIntent().getExtras();
		String winner = b.getString("winner");
		int score = b.getInt("score");
		gamemode = b.getString("gamemode");
		
		Typeface tf = Typeface.createFromAsset(getAssets(), "font/baveuse.otf");
		TextView winnerView = (TextView) findViewById(R.id.winner);
		TextView scoreView = (TextView) findViewById(R.id.score);
		TextView tryAgain = (TextView) findViewById(R.id.tryagain);
		TextView mainmenu = (TextView) findViewById(R.id.mainmenu);
		
		winnerView.setTypeface(tf);
		winnerView.setTextColor(getResources().getColor(R.color.supergold));
		winnerView.setTextSize(60);
		winnerView.setText(winner + " won");
		
		scoreView.setTypeface(tf);
		scoreView.setTextColor(getResources().getColor(R.color.score));
		scoreView.setText("Score: " + score);
		scoreView.setTextSize(50);
		
		tryAgain.setTypeface(tf);
		tryAgain.setTextSize(40);
		tryAgain.setTextColor(getResources().getColor(R.color.supergold));
		tryAgain.setOnClickListener(this);

		mainmenu.setTypeface(tf);
		mainmenu.setTextSize(40);
		mainmenu.setTextColor(getResources().getColor(R.color.supergold));
		mainmenu.setOnClickListener(this);
		
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tryagain:
			Intent intent = new Intent(this, GameActivity.class);
			Bundle b = new Bundle();
			b.putString("gamemode", gamemode);
			intent.putExtras(b); //Put your id to your next Intent
			startActivity(intent);
			finish();			
			break;
		case R.id.mainmenu:
			finish();
			break;
		}
	}


}
