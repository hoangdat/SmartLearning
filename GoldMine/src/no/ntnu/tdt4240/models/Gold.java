package no.ntnu.tdt4240.models;

import android.graphics.Canvas;

public class Gold extends Cell {

	private String type = "gold";
	private boolean clicked;
	private Canvas image;
	
	Gold(Canvas image) {
		super(image);
		this.image=image;
		clicked=false;
	}

	@Override
	public void onClick() {
		// TODO Auto-generated method stub
		
	}
	
	
	

}