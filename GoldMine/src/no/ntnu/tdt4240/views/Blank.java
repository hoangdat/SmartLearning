package no.ntnu.tdt4240.views;
import no.ntnu.tdt4240.R;
import no.ntnu.tdt4240.sound.BackgroundMusic;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Blank extends Cell{

	private int numberOfAdjacentGold;
	private int numberOfAdjacentMines;
	private Paint goldPaint;
	private Paint minePaint;
	private boolean needsRipple;
	private boolean noMines = false; 
	private boolean noGold = false; 
	
	public Blank(Context context, int gold, int mines) {
		super(context);
		this.numberOfAdjacentGold = gold;
		this.numberOfAdjacentMines = mines;	
		initPaint();
		if (!isClicked() && isEmpty())
			needsRipple = true;
		if(gold == 0)
			noGold = true;
		if (mines == 0)
			noMines = true;
	}
	
	@Override
	public boolean needsRipple() {
		boolean tmp = !isClicked() && isEmpty() && needsRipple;
		needsRipple = false;
		return tmp;
	}
	
	public void initPaint(){
		goldPaint = new Paint();
		goldPaint.setTextSize(26);
		goldPaint.setColor(getResources().getColor(R.color.gold));
		goldPaint.setStyle(Paint.Style.FILL_AND_STROKE);
		minePaint = new Paint();
		minePaint.setTextSize(26);
		minePaint.setColor(getResources().getColor(R.color.mine));
		minePaint.setStyle(Paint.Style.FILL_AND_STROKE);
	}

	@Override
	public void changeImage() {
		if(isEmpty())
			this.setBackgroundResource(R.drawable.buttonclickedblank);
		if(noGold || noMines)
			this.setBackgroundResource(R.drawable.buttonclickedonenumber);
		else
			this.setBackgroundResource(R.drawable.buttonclickednonblank);
	}

	private boolean isEmpty() {
		return numberOfAdjacentGold == 0 && numberOfAdjacentMines == 0;
	}
		
	@Override
	protected void onDraw(Canvas canvas){
		super.onDraw(canvas);
		if (isClicked() && !isEmpty()){
			if(noMines){
				canvas.drawText(numberOfAdjacentGold + "",14, 29, goldPaint);
				return;
			}
			if(noGold){
				canvas.drawText(numberOfAdjacentMines + "",14, 29, minePaint);
				return;
			}
			canvas.drawText(numberOfAdjacentGold + "",4, 29, goldPaint);
			canvas.drawText(numberOfAdjacentMines + "",24, 29, minePaint);
		}
	}

	@Override
	public void playSound() {
		BackgroundMusic.playSelect("blank");
	}

}