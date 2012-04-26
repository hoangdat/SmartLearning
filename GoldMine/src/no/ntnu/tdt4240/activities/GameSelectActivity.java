package no.ntnu.tdt4240.activities;

import no.ntnu.tdt4240.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class GameSelectActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

//		// hide title
		requestWindowFeature(Window.FEATURE_NO_TITLE);
//
//        // Hide notification bar
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//
        setContentView(R.layout.choosegamemode);

		
		/*
		Intent intent = new Intent(this, GameActivity.class);
		Bundle b = new Bundle();
		b.putString("gamemode", "goldminemode");
		intent.putExtras(b); //Put your id to your next Intent
		startActivity(intent);
		finish();
*/
		
        
	}
	
}
