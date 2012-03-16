package no.ntnu.tdt4240.models;
import no.ntnu.tdt4240.R;
import android.content.Context;

public class Gold extends Cell {


	Gold(Context context){
		super(context);
	}

	public void onClick(){
		if(!isClicked()){
			click();
			changeImage();
		}
	}

	@Override
	public void changeImage(){
		this.setBackgroundResource(R.drawable.gold);
	}

}