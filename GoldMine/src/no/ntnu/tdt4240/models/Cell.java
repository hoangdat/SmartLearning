package no.ntnu.tdt4240.models;
import no.ntnu.tdt4240.R;
import android.content.Context;
import android.view.*;

public abstract class Cell extends View {

	public Cell(Context context){
		super(context);
		this.setBackgroundResource(R.drawable.unclickedbutton);
	}
	public abstract void changeImage();
}


