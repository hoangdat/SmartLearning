package no.ntnu.tdt4240;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.Window;
import android.view.WindowManager;

public class PreferencesActivity extends PreferenceActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.settings);
		
//		// Hide title
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        // Hide notification bar
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

	}
	
}
