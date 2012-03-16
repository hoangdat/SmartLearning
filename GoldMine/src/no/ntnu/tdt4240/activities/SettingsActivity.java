package no.ntnu.tdt4240.activities;

import no.ntnu.tdt4240.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.view.Window;
import android.view.WindowManager;

public class SettingsActivity extends PreferenceActivity {
	
	private static final String NUMBER_OF_MINES = "numberofminesvar";
	private static final String NUMBER_OF_MINES_DEFAULT = "45";
    private static final String AMOUNT_OF_GOLD = "amountofgoldvar";
    private static final String AMOUNT_OF_GOLD_DEFAULT = "25";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    
		// hide title

//        requestWindowFeature(Window.FEATURE_NO_TITLE); \\**//BUGGER SETTINGS\\**//

        // Hide notification bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        addPreferencesFromResource(R.xml.settings);

	}
	
	public static int getNumberOfMines(Context context) {
        return Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(context).
            getString(NUMBER_OF_MINES, NUMBER_OF_MINES_DEFAULT));
    }
	
	public static int getAmountOfGold(Context context) {
        return Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(context).
            getString(AMOUNT_OF_GOLD, AMOUNT_OF_GOLD_DEFAULT));
        
    }
	
}
