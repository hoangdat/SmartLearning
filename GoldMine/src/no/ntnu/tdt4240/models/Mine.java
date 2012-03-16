package no.ntnu.tdt4240.models;
import no.ntnu.tdt4240.R;
import android.content.Context;

public class Mine extends Cell {

	Mine(Context context) {
		super(context);
	}
	
	public void onClick(){
		if(!isClicked()){
			changeImage();	
			click();
		}
	}
	
	@Override
	public void changeImage(){
		this.setBackgroundResource(R.drawable.wormsmine);
	}

}
