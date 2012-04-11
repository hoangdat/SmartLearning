package no.ntnu.tdt4240.views;

import no.ntnu.tdt4240.R;
import no.ntnu.tdt4240.models.Player;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

public class PlayerView extends View {

	private Paint paint;
	private Player player;
	private Context myContext;
	
	public PlayerView(Context context, AttributeSet attrs) {
		super(context, attrs);
		myContext = context;
		init();
	}

	private void init() {
		paint = new Paint();
		paint.setTextSize(24);
		paint.setColor(R.color.mine);
		//Typeface tf = Typeface.createFromAsset(myContext.getAssets(),"font/SinkiS93.otf");
		//paint.setTypeface(tf);
		paint.setStyle(Paint.Style.FILL_AND_STROKE);
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
		float nameWidth = paint.measureText(getName());
		float startName = getWidth()/2 - nameWidth/2;
		
		canvas.drawText(getName(), startName, 35, paint);
		canvas.drawRect(25, 75, 125, 175, paint);
		
		float scoreWidth = paint.measureText(getScore());
		float startScore = 75 - scoreWidth/2;
		
		canvas.drawText(getScore(), startScore, 250, paint);
	}

	private String getScore() {
		if (player == null)
			return "0";
		return player.getScore() + "";
	}

}
