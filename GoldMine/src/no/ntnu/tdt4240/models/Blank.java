package no.ntnu.tdt4240.models;

import android.graphics.Canvas;

public class Blank extends Cell {

	
	private boolean clicked;
	private Canvas image;
	private int nearGold;
	private int nearMines;
	
	Blank(int mines, int gold) {
		
		this.image=image;
		clicked=false;
		this.nearGold=gold;
		this.nearMines=mines;
		
	}

	@Override
	public void onClick() {
		// TODO Auto-generated method stub
		
	}
	
	

}