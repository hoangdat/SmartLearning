package no.ntnu.tdt4240.views;
import no.ntnu.tdt4240.R;
import no.ntnu.tdt4240.sound.Sounds;
import android.content.Context;

public class Mine extends Cell {

	public Mine(Context context) {
		super(context);
	}
	
	@Override
	public void changeImage(){
		this.setBackgroundResource(R.drawable.wormsmine);
	}

	@Override
	public void playSound() {
		Sounds.playSelect("mine");
	}

}
