package no.ntnu.tdt4240.models;

import java.util.Observer;

import android.content.Context;
import android.graphics.Canvas;
import android.view.*;
import android.widget.Button;

public abstract class Cell extends Button {

	public Cell(Context context) {
		super(context);
		
	}
	public abstract void changeImage();
}


