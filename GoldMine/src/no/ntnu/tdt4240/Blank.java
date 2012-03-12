package no.ntnu.tdt4240;

import android.graphics.Canvas;

public class Blank extends Cell{


	private boolean isClicked;
	private Canvas image;
	private int mines;
	private int gold; 

	Blank(Canvas image, int mines, int gold) {
		super(image);
		this.gold=gold;
		this.mines=mines;
	}

	@Override
	public void onClick() {
		if(isClicked=false){
			isClicked=true;
			//this.Image="";
			//gi turen til motstander
		}
	}
	
	

}