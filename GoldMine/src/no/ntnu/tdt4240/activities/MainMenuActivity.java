package no.ntnu.tdt4240.activities;

import no.ntnu.tdt4240.R;
import no.ntnu.tdt4240.sound.BackgroundMusic;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainMenuActivity extends Activity implements android.view.View.OnClickListener {
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // Hide notification bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.main);
       
        // Click-handlers for buttons
        View newgameButton = findViewById(R.id.new_button);
        newgameButton.setOnClickListener(this);
        View settingsButton = findViewById(R.id.settings_button);
        settingsButton.setOnClickListener(this); 
        View instructionsButton = findViewById(R.id.instructions_button);
        instructionsButton.setOnClickListener(this);
        View aboutButton = findViewById(R.id.about_button);
        aboutButton.setOnClickListener(this);
        View exitButton = findViewById(R.id.exit_button);
        exitButton.setOnClickListener(this);
        
        BackgroundMusic.loadSound(this);
    	BackgroundMusic.playMusic();
        
    }
    
    public boolean isDay(){
    	Time time = new Time();
    	return (time.hour > 6 && time.hour < 18);
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