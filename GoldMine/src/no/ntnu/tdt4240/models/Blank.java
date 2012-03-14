package no.ntnu.tdt4240.models;

import no.ntnu.tdt4240.R.color;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.view.View.OnClickListener;

public class Blank extends Cell {

	
	private boolean clicked;
	private Canvas image;
	private int nrOfAdjacentGold;
	private int nrOfAdjacentMines;
	private Paint goldNr;
	private Paint mineNr;
	private Canvas canvas;
	
	Blank(Context context, int mines, int gold) {
		super(context);
//		this.setBackgroundResource(R.drawable......)
		clicked=false;
		this.nrOfAdjacentGold=gold;
		this.nrOfAdjacentMines=mines;
		this.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				

			}
		});
	
		initPaint();
	}
	protected void onDraw() {
		
		this.canvas=canvas;
		
		
	}
	@Override
	public void changeImage() {
//		this.setBackgroundResource(R.drawable......)
		canvas.drawText(Integer.toString(nrOfAdjacentGold),4f, 7f, goldNr);
		
		
	}
	public void initPaint(){
		goldNr = new Paint();
		goldNr.setTextSize(15);
		goldNr.setColor(color.gold);
		goldNr.setStyle(Paint.Style.FILL_AND_STROKE);
		
		mineNr = new Paint();
		mineNr.setTextSize(15);
		mineNr.setColor(color.mine);
		mineNr.setStyle(Paint.Style.FILL_AND_STROKE);
	}
	
}