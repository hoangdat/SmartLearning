package no.ntnu.tdt4240.test;

import no.ntnu.tdt4240.activities.GameActivity;
import no.ntnu.tdt4240.activities.MainMenuActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

public class GameActivityTest extends ActivityInstrumentationTestCase2<GameActivity>{

	private GameActivity gameActivity;
	private TextView mView;

	public GameActivityTest() {
		super("no.ntnu.tdt4240.GameActivity", GameActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		gameActivity = getActivity();
		mView = (TextView) gameActivity.findViewById(no.ntnu.tdt4240.R.id.MineField);
	}
	
	public void testPrecondition() {
		assertNotNull(mView);
		
	}
	public void testText() {

	}
}
