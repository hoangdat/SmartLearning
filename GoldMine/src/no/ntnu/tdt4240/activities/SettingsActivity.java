package no.ntnu.tdt4240.activities;

import no.ntnu.tdt4240.R;
import no.ntnu.tdt4240.sound.BackgroundMusic;
import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.WindowManager;

public class SettingsActivity extends PreferenceActivity {

	private static final String NAME_PLAYER_1 = "player1name";
	private static final String NAME_PLAYER_1_DEFAULT = "Player 1";
	private static final String NAME_PLAYER_2 = "player2name";
	private static final String NAME_PLAYER_2_DEFAULT = "Player 2";
	private static final String SOUND_ENABLED = "soundvar";
	private static final boolean SOUND_ENABLED_DEFAULT = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		addPreferencesFromResource(R.xml.settings);
	}

	public static String getPlayer1Name(Context context) {
		return PreferenceManager.getDefaultSharedPreferences(context).
				getString(NAME_PLAYER_1, NAME_PLAYER_1_DEFAULT);
	}

	public static String getPlayer2Name(Context context) {
		return PreferenceManager.getDefaultSharedPreferences(context).
				getString(NAME_PLAYER_2, NAME_PLAYER_2_DEFAULT);
	}
	
	public static boolean isSoundEnabled(Context context){
		return PreferenceManager.getDefaultSharedPreferences(context).
				getBoolean(SOUND_ENABLED, SOUND_ENABLED_DEFAULT);
	}

	@Override //når du velger mute
	public boolean onMenuItemSelected(int featureId, MenuItem item){
		if(item.getItemId() == R.id.sound){ //funker ikke! OMG!
			if (BackgroundMusic.isSoundEnabled()){
				BackgroundMusic.setSoundEnabled(false);
				BackgroundMusic.pauseMusic();
			}
			else{
				BackgroundMusic.setSoundEnabled(true);
				BackgroundMusic.unPauseMusic();
			}
		}
		return super.onMenuItemSelected(featureId, item);
	}

}
