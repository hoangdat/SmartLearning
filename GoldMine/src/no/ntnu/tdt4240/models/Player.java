package no.ntnu.tdt4240.models;

import android.content.Context;
import no.ntnu.tdt4240.views.PlayerView;

public class Player {

	private String name;
	private int score;
	private PlayerView view;
	
	public Player(String name) {
		this.name = name;
		score = 0;
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

	public void makeActive(Context context) {
		view.makeActive(context);
		view.invalidate();
	}

	public void makeDeactive(Context context) {
		view.makeDeactive(context);
		view.invalidate();
	}
	
}
