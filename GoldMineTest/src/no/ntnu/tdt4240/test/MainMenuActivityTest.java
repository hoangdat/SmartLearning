package no.ntnu.tdt4240.test;

import no.ntnu.tdt4240.MainMenuActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

public class MainMenuActivityTest extends ActivityInstrumentationTestCase2<MainMenuActivity>{

	private MainMenuActivity mActivity;
	private TextView mView;
	private Object resourceString;

	public MainMenuActivityTest() {
		super("no.ntnu.tdt4240.MainMenuActivity", MainMenuActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mActivity = getActivity();
		mView = (TextView) mActivity.findViewById(no.ntnu.tdt4240.R.id.main_title);
		resourceString = mActivity.getString(no.ntnu.tdt4240.R.string.main_title);
	}
	
	public void testPrecondition() {
		assertNotNull(mView);
	}
	public void testText() {
		assertEquals(resourceString, (String)mView.getText());
	}
}
