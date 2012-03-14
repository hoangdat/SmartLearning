package no.ntnu.tdt4240.models;

import no.ntnu.tdt4240.R.color;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Blank extends Cell {


	private boolean clicked;
	private int nrOfAdjacentGold;
	private int nrOfAdjacentMines;
	private Paint goldPaint;
	private Paint minePaint;
	private Canvas canvas;

	Blank(Context context, int mines, int gold) {
		super(context);
		//		this.setBackgroundResource(R.drawable......)
		clicked=false;
		this.nrOfAdjacentGold=gold;
		this.nrOfAdjacentMines=mines;	
		initPaint();
	}

	public void onClick(){
		if(!clicked){
			clicked = true;
			//		
			changeImage();
			canvas.drawText(Integer.toString(nrOfAdjacentGold),4f, 7f, goldPaint);
			canvas.drawText(Integer.toString(nrOfAdjacentMines),4f, 7f, goldPaint);
		}
	}

	public void initPaint(){
		goldPaint = new Paint();
		goldPaint.setTextSize(26);
		goldPaint.setColor(color.gold);
		goldPaint.setStyle(Paint.Style.FILL_AND_STROKE);
		minePaint = new Paint();
		minePaint.setTextSize(26);
		minePaint.setColor(color.mine);
		minePaint.setStyle(Paint.Style.FILL_AND_STROKE);
	}

	@Override
	public void changeImage() {
//		this.setBackgroundResource(R.drawable......)

	}

}