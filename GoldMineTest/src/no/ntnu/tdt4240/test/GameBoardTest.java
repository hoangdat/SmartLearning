package no.ntnu.tdt4240.test;

import junit.framework.TestCase;
import no.ntnu.tdt4240.activities.GameActivity;
import no.ntnu.tdt4240.models.GameBoard;
import android.test.ActivityUnitTestCase;

public class GameBoardTest extends TestCase {

	private GameBoard gameBoard;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		gameBoard = new GameBoard(null);
	}
	
	public void testPreCondition() {
		assertNotNull(gameBoard);
	}
	
}
