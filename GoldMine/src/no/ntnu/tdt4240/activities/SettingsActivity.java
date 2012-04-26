package no.ntnu.tdt4240.activities;

import no.ntnu.tdt4240.R;
import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.view.WindowManager;

public class SettingsActivity extends PreferenceActivity {
	
    private static final String NAME_PLAYER_1 = "player1name";
    private static final String NAME_PLAYER_1_DEFAULT = "Player 1";
    private static final String NAME_PLAYER_2 = "player2name";
    private static final String NAME_PLAYER_2_DEFAULT = "Player 2";
    private static final boolean isMuted = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    
		// hide title

//        requestWindowFeature(Window.FEATURE_NO_TITLE); \\**//BUGGER SETTINGS\\**//

        // Hide notification bar
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
	
	//TODO - DETTE ER EN DUMMYMETODE
	public static boolean isMuted(Context context){
		return isMuted;
	}
	
}
