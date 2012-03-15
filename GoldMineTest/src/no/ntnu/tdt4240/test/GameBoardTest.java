package no.ntnu.tdt4240.test;

import no.ntnu.tdt4240.activities.GameActivity;
import no.ntnu.tdt4240.models.GameBoard;
import android.test.ActivityUnitTestCase;

public class GameBoardTest extends ActivityUnitTestCase<GameActivity> {

	public GameBoardTest() {
		super(GameActivity.class);
	}
	
	private GameBoard gameBoard;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		gameBoard = new GameBoard(getActivity());
	}
	
	public void testPreCondition() {
		assertNotNull(gameBoard);
	}
	
}
