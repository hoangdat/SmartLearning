package no.ntnu.tdt4240.models;
<<<<<<< HEAD
=======

import no.ntnu.tdt4240.R;
import no.ntnu.tdt4240.activities.GameActivity;
>>>>>>> 94eb45ba081dc30d6bafa093252981679a1886f0
import android.content.Context;

public class Gold extends Cell {

	private boolean clicked;

	Gold(Context context){
		super(context);
//		this.setBackgroundResource(R.drawable......)
		clicked = false;
	}

	public void onClick(){
		if(!clicked){
			clicked=true;
			changeImage();
		}
	}

	@Override
	public void changeImage(){
//		this.setBackgroundResource(R.drawable......)
	}

}