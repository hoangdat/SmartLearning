package no.ntnu.tdt4240.views;
import no.ntnu.tdt4240.R;
import android.content.Context;

public class Mine extends Cell {

	public Mine(Context context) {
		super(context);
	}
	
	@Override
	public void changeImage(){
		this.setBackgroundResource(R.drawable.wormsmine);
	}

}
