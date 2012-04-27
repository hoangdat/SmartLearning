package no.ntnu.tdt4240.activities;

import no.ntnu.tdt4240.R;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class InstructionsActivity extends TabActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.instructions);
		 
        TabHost tabHost = getTabHost();
 
        TabSpec puregoldspec = tabHost.newTabSpec("Pure Gold");
        // setting Title and Icon for the Tab
        puregoldspec.setIndicator("Pure Gold", getResources().getDrawable(R.drawable.gold));
        Intent photosIntent = new Intent(this, PureGoldInstructionActivity.class);
        puregoldspec.setContent(photosIntent);
 
        TabSpec goldminespec = tabHost.newTabSpec("GoldMine");
        goldminespec.setIndicator("GoldMine", getResources().getDrawable(R.drawable.wormsmine));
        Intent songsIntent = new Intent(this, GoldMineInstructionActivity.class);
        goldminespec.setContent(songsIntent);
 
 
        // Adding all TabSpec to TabHost
        tabHost.addTab(puregoldspec); 
        tabHost.addTab(goldminespec); 
        
    }
}
