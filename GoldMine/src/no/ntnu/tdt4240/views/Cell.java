package no.ntnu.tdt4240.views;
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
	
	public Cell onClick(){
		if(!isClicked()){
			changeImage();	
			clicked = true;
			return this;
		}
		return null;
	}
	
	public boolean needsRipple() {
		return false;
	}
}


