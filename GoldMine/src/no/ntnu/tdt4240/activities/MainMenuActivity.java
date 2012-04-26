package no.ntnu.tdt4240.activities;

import no.ntnu.tdt4240.R;
import no.ntnu.tdt4240.sound.BackgroundMusic;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainMenuActivity extends Activity implements
		android.view.View.OnClickListener {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Hide title
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// Hide notification bar
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.main);

		// Click-handlers for buttons
		TextView newgameButton = (TextView) findViewById(R.id.new_button);
		TextView settingsButton = (TextView) findViewById(R.id.settings_button);
		TextView instructionsButton = (TextView) findViewById(R.id.instructions_button);
		TextView aboutButton = (TextView) findViewById(R.id.about_button);
		TextView exitButton = (TextView) findViewById(R.id.exit_button);

		initiateMenuElement(newgameButton);
		initiateMenuElement(settingsButton);
		initiateMenuElement(instructionsButton);
		initiateMenuElement(aboutButton);
		initiateMenuElement(exitButton);
		
		
		
		BackgroundMusic.loadSound(this);
		BackgroundMusic.playMusic();
	}

	private void initiateMenuElement(TextView textButton) {
		Typeface tf = Typeface.createFromAsset(getAssets(), "font/baveuse.otf");
		textButton.setTextColor(getResources().getColor(R.color.mainmenu));
		textButton.setOnClickListener(this);
		textButton.setTypeface(tf);
		textButton.setTextSize(40);
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.new_button:
			startActivity(new Intent(this, GameSelectActivity.class));
			break;
		case R.id.settings_button:
			startActivity(new Intent(this, SettingsActivity.class));
			break;
		case R.id.instructions_button:
			startActivity(new Intent(this, InstructionsActivity.class));
			break;
		case R.id.about_button:
			startActivity(new Intent(this, AboutActivity.class));
			break;
		case R.id.exit_button:
			System.exit(0);
			break;
		}
	}
	
}