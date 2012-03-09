package no.ntnu.tdt4240;

import android.graphics.Canvas;

public class Gold extends Cell{


	private boolean isClicked;
	private Canvas icon;

	Gold(Canvas image) {
		super(image);
	}

	@Override
	public void onClick() {
		if(isClicked=false){
		//update score
		//this.Image="";
		isClicked=true;
		}
	}
	

}
