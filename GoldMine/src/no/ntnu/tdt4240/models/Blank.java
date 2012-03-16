package no.ntnu.tdt4240.models;
import no.ntnu.tdt4240.R;
import no.ntnu.tdt4240.R.color;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Blank extends Cell{

	private int numberOfAdjacentGold;
	private int numberOfAdjacentMines;
	private Paint goldPaint;
	private Paint minePaint;

	Blank(Context context, int gold, int mines) {
		super(context);
		this.numberOfAdjacentGold = gold;
		this.numberOfAdjacentMines = mines;	
		initPaint();
	}

	public void onClick(){
		if(!isClicked()){
			click();
 			changeImage();
		}
	}
	
	@Override
	public boolean needsRipple() {
		return !isClicked() && isEmpty();
	}
	
	public void initPaint(){
		goldPaint = new Paint();
		goldPaint.setTextSize(26);
		goldPaint.setColor(R.color.gold);
		goldPaint.setStyle(Paint.Style.FILL_AND_STROKE);
		minePaint = new Paint();
		minePaint.setTextSize(26);
		minePaint.setColor(R.color.mine);
		minePaint.setStyle(Paint.Style.FILL_AND_STROKE);
	}

	@Override
	public void changeImage() {

		if(isEmpty()){
			this.setBackgroundResource(R.drawable.buttonclickedblank);
		}
		else{
			this.setBackgroundResource(R.drawable.buttonclickednonblank);
		}
		
	}

	private boolean isEmpty() {
		return numberOfAdjacentGold == 0 && numberOfAdjacentMines == 0;
	}
		
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if (isClicked() && !isEmpty()) {
			canvas.drawText(numberOfAdjacentGold + "",4, 29, goldPaint);
			canvas.drawText(numberOfAdjacentMines + "",24, 29, minePaint);
		}
	}

}