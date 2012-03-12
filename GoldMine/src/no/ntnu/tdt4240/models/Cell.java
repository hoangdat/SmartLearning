package no.ntnu.tdt4240.models;

import android.graphics.Canvas;

public abstract class Cell {
	private String type="cell";
	private Canvas image;
	
	Cell(Canvas image){
		
		this.image=image;
	}
	
	public abstract void onClick();
	public String getType(){
		return type;
	}

}
