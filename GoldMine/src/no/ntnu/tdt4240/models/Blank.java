package no.ntnu.tdt4240.models;

import android.content.Context;
import android.graphics.Canvas;

public class Blank extends Cell {

	
	private boolean clicked;
	private Canvas image;
	private int nearGold;
	private int nearMines;
	
	Blank(Context context, int mines, int gold) {
		super(context);
		this.image=image;
		clicked=false;
		this.nearGold=gold;
		this.nearMines=mines;
		
	}
}