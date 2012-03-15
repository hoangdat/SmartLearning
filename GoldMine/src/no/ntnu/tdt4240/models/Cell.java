package no.ntnu.tdt4240.models;
import android.content.Context;
import android.view.*;

public abstract class Cell extends View {

	public Cell(Context context) {
		super(context);
		
	}
	public abstract void changeImage();
}


