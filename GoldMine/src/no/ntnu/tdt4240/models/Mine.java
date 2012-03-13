package no.ntnu.tdt4240.models;

import no.ntnu.tdt4240.activities.GameActivity;
import android.content.Context;
import android.graphics.Canvas;

public class Mine extends Cell {

	private boolean clicked;
	private Canvas image;
	
	Mine(Context context) {
		super(context);
	}

}
