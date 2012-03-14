package no.ntnu.tdt4240.models;

import no.ntnu.tdt4240.activities.GameActivity;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.View.OnClickListener;

public class Mine extends Cell {

	private boolean clicked;
	
	
	Mine(Context context) {
		super(context);
//		this.setBackgroundResource(R.drawable......)
		clicked =false;
		this.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				if(!clicked){
					clicked=true;
					changeImage();	
				}
			}
		});
	}
	@Override
	public void changeImage(){
//		this.setBackgroundResource(R.drawable......)
	}

}
