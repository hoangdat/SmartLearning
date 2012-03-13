package no.ntnu.tdt4240.models;

import no.ntnu.tdt4240.activities.GameActivity;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.View.OnClickListener;

public class Gold extends Cell {

	private boolean clicked;
	
	Gold(Context context) {
		super(context);
		clicked=false;
		this.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
			
			}
		});
	}

	@Override
	public void changeImage() {
//		this.setBackgroundResource(R.drawable......)
		
	}

}