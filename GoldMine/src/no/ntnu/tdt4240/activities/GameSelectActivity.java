package no.ntnu.tdt4240.activities;

import no.ntnu.tdt4240.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class GameSelectActivity extends Activity implements android.view.View.OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// hide title
		requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Hide notification bar
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.choosegamemode);

		ImageView goldMineModeButton = (ImageView) findViewById(R.id.goldminemode);
		ImageView pureGoldModeButton = (ImageView) findViewById(R.id.goldmode);

        goldMineModeButton.setOnClickListener(this);
        pureGoldModeButton.setOnClickListener(this);
        
	}

	public void onClick(View v) {

		switch (v.getId()) {	
		case R.id.goldminemode:
			selectGameMode("goldmine");
			break;
		case R.id.goldmode:
			selectGameMode("puregold");
			break;
		
		}
		
	}

	private void selectGameMode(String gamemode) {
		Intent intent = new Intent(this, GameActivity.class);
		Bundle b = new Bundle();
		b.putString("gamemode", gamemode);
		intent.putExtras(b); //Put your id to your next Intent
		startActivity(intent);
		finish();
	}
	
}
