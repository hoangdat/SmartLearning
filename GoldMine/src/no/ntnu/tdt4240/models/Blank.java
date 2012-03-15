package no.ntnu.tdt4240.models;
import no.ntnu.tdt4240.R;
import no.ntnu.tdt4240.R.color;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Blank extends Cell{

	private boolean clicked;
	private int nrOfAdjacentGold;
	private int nrOfAdjacentMines;
	private Paint goldPaint;
	private Paint minePaint;
	private Canvas mCanvas;

	Blank(Context context, int mines, int gold) {
		super(context);
		clicked=false;
		this.nrOfAdjacentGold = gold;
		this.nrOfAdjacentMines = mines;	
		initPaint();
	}

	public void onClick(){
		if(!clicked){
			clicked = true;
 			changeImage();
 			if(nrOfAdjacentGold==0&& nrOfAdjacentMines==0){
 				rippleBlank();
 			}
		}
	}
	
	public void rippleBlank(){
		
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
		if(nrOfAdjacentGold==0&& nrOfAdjacentMines==0){
			this.setBackgroundResource(R.drawable.buttonclickedblank);
		}
		else{
			this.setBackgroundResource(R.drawable.buttonclickednonblank);
			mCanvas.drawText(nrOfAdjacentGold + "",4, 7, goldPaint);
			mCanvas.drawText(nrOfAdjacentMines + "",24, 7, minePaint);
		}
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		mCanvas = canvas;
		super.onDraw(canvas);
	}

}