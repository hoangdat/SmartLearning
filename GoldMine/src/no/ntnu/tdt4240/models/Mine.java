package no.ntnu.tdt4240.models;



import no.ntnu.tdt4240.R;
import no.ntnu.tdt4240.activities.GameActivity;

import android.content.Context;

public class Mine extends Cell {

	private boolean clicked;
	
	Mine(Context context) {
		super(context);
//		this.setBackgroundResource(R.drawable......)
		clicked = false;
	}
	
	public void onClick(){
		if(!clicked){
			clicked=true;
			changeImage();	
		}
	}
	
	@Override
	public void changeImage(){
//		this.setBackgroundResource(R.drawable......)
	}

}
