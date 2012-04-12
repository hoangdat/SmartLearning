package no.ntnu.tdt4240.views;
import no.ntnu.tdt4240.R;
import android.content.Context;

public class Gold extends Cell {

	public Gold(Context context){
		super(context);
	}

	@Override
	public void changeImage(){
		this.setBackgroundResource(R.drawable.gold);
	}

}