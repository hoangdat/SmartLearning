package no.ntnu.tdt4240.models;
import no.ntnu.tdt4240.R;
import android.content.Context;
import android.view.*;

public abstract class Cell extends View {

	private boolean clicked;
	
	public Cell(Context context){
		super(context);
		this.setBackgroundResource(R.drawable.unclickedbutton);
		clicked = false;
	}
	
	public boolean isClicked(){
		return clicked;
	}
	
	public abstract void changeImage();
	
	public void onClick(){
		if(!isClicked()){
			changeImage();	
			clicked = true;
		}
	}
	
	public boolean needsRipple() {
		return false;
	}
}


