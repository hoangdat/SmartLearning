package no.ntnu.tdt4240.models;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public abstract class Cell extends Button {

	public Cell(Context context) {
		super(context);
		setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
	
	}

}
	
	
	

