package no.ntnu.tdt4240;

import android.graphics.Canvas;

public class Mine extends Cell{


	private boolean isClicked;
	private Canvas icon;

	Mine(Canvas image) {
		super(image);
	}

	@Override
	public void onClick() {
		if(isClicked=false){
		isClicked=true;
			//this.Image="";
			//gi turen til motstander
			//update score 
		}
	}
	

}
