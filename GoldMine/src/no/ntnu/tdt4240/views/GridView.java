package no.ntnu.tdt4240.views;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class GridView extends View {

	private static final int CELL_SIZE = 8;
    private static final int WIDTH = 480 / CELL_SIZE;
    private static final int HEIGHT = 480 / CELL_SIZE;
    
	public GridView(Context context) {
		super(context);
	}
	
	protected void onDraw(Canvas canvas) {
		Paint background = new Paint();
		background.setColor(R.color.black);
		
		Paint gold = new Paint();
		gold.setColor(R.color.primary_text_light);
		
		Paint mine = new Paint();
		mine.setColor(R.color.white);
		
		canvas.drawRect(0, 0, getWidth(), getHeight(), background);
		
		for (int i = 0; i < HEIGHT; i++) {
		}
	}

}
