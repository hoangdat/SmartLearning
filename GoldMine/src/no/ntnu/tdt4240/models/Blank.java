package no.ntnu.tdt4240.models;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.View.OnClickListener;

public class Blank extends Cell {

	
	private boolean clicked;
	private Canvas image;
	private int nrOfAdjacentGold;
	private int nrOfAdjacentMines;
	
	Blank(Context context, int mines, int gold) {
		super(context);
		this.image=image;
		clicked=false;
		this.nrOfAdjacentGold=gold;
		this.nrOfAdjacentMines=mines;
		this.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
			
			}
		});

	}
	
}