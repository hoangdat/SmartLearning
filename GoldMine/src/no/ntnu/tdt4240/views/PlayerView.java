package no.ntnu.tdt4240.views;

import no.ntnu.tdt4240.R;
import no.ntnu.tdt4240.models.Player;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class PlayerView extends View {

	private Paint namePaint;
	private Paint scorePaint;
	private Player player;
	private String active;
	
	public PlayerView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
		active = "active";
		ImageView iv = new ImageView(context, attrs);
		iv.setBackgroundResource(R.drawable.cow);
		
		LayoutParams layout = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		
		iv.setLayoutParams(layout);
	}

	private void init() {
		namePaint = new Paint();
		namePaint.setTextSize(24);
//		paint.setColor(R.color.blank);
		namePaint.setColor(Color.RED);
		setBackgroundResource(R.drawable.playerbox_simple);
		Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "font/baveuse.otf");
		namePaint.setTypeface(tf);
		namePaint.setStyle(Paint.Style.FILL_AND_STROKE);

		scorePaint = new Paint();
		scorePaint.set(namePaint);
		scorePaint.setColor(Color.WHITE);
		
		
	}
	
	private void drawScore(int number) { //HERPDERP!
		namePaint = new Paint();
		namePaint.setTextSize(15);
		namePaint.setColor(Color.WHITE);
		
	}
	
	public String getName() {
		if (player == null)
			return "Player1";
		return player.getName();
	}

	public void setPlayer(Player player) {
		this.player = player;
		if (player.getPlayerView() == null)
			player.setPlayerView(this);
	}
	
	public Player getPlayer() {
		return player;
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		float nameWidth = namePaint.measureText(getName());
		float startName = getWidth()/2 - nameWidth/2;
		
		canvas.drawText(getName(), startName, 35, namePaint);
		
		
		Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.cow);
		
		
		canvas.drawBitmap(bm, 0, 0, namePaint);
		
//		canvas.drawRect(25, 75, 100, 150, namePaint);
		
		
		
		float scoreWidth = namePaint.measureText(getScore());
		float startScore = getWidth()/2 - scoreWidth/2;
		
		canvas.drawText(getScore(), startScore, 200, scorePaint);
	}

	private String getScore() {
		if (player == null)
			return "0";
		return player.getScore() + "";
	}
	
	public void makeActive(Context context) {
//		Animation fadein = AnimationUtils.loadAnimation(context, R.anim.fadein);
//		startAnimation(fadein);
		getBackground().setAlpha(100);
	}
	
	public void makeDeactive(Context context) {
//		Animation fadeout = AnimationUtils.loadAnimation(context, R.anim.fadeout);
//		startAnimation(fadeout);
		getBackground().setAlpha(50);
	}
}
