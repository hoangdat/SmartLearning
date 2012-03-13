package no.ntnu.tdt4240.models;

import no.ntnu.tdt4240.activities.GameActivity;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.View.OnClickListener;

public class Mine extends Cell {

	private boolean clicked;
	private Canvas image;
	
	Mine(Context context) {
		super(context);
		this.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
			
			}
		});
	}

}
