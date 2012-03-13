package no.ntnu.tdt4240.models;

import no.ntnu.tdt4240.R;
import no.ntnu.tdt4240.activities.GameActivity;
import android.content.Context;
import android.graphics.Canvas;

public class Gold extends Cell {

	private boolean clicked;
	
	Gold(Context context) {
		super(context);
		clicked=false;
		this.setBackgroundResource(R.color.gold);
	}

}