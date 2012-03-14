package no.ntnu.tdt4240.models;

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