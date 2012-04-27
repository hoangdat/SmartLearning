package no.ntnu.tdt4240.models;

import no.ntnu.tdt4240.R;
import no.ntnu.tdt4240.views.PlayerView;

public class Player {

	private String name;
	private int score;
	private PlayerView view;
	private int image;
	
	public Player(String name) {
		this.name = name;
		score = 0;
		image = R.drawable.cow;
	}
	
	public void addToScore(int scoreChange){
		score += scoreChange;
		view.invalidate();
	}
	
	public int getScore() {
		return score;
	}
	
	public void setPlayerView(PlayerView view) {
		this.view = view;
		if (view.getPlayer() == null)
			view.setPlayer(this);
		
	}

	public PlayerView getPlayerView() {
		return view;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}

	public void setImage(int image){
		this.image = image;
	}
	
	public int getImage() {
		return image;
	}
	
}
