package no.ntnu.tdt4240;

import android.graphics.Canvas;

public abstract class Cell {
	
	private Canvas image;
	private boolean isClicked; 
	
	Cell(Canvas image){
		this.image= image;
		isClicked=false; 
	}
		public abstract void onClick();
			
		
}
