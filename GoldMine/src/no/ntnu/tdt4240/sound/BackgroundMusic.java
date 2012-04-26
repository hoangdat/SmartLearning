package no.ntnu.tdt4240.sound;

import no.ntnu.tdt4240.R;
import no.ntnu.tdt4240.activities.SettingsActivity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

public class BackgroundMusic{
	private static SoundPool soundPool;
	private static int mine;
	private static int gold1;
	private static int gold2;
	private static int gold3;
	private static int gold4;
	private static int blank;
	private static MediaPlayer music;
	private static boolean mute = false;

	public static void loadSound(Context context) {
		soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
		mine = soundPool.load(context, R.raw.mine, 1);
		gold1 = soundPool.load(context, R.raw.gold1, 1);
		gold2 = soundPool.load(context, R.raw.gold2, 1);
		gold3 = soundPool.load(context, R.raw.gold3, 1);
		gold4 = soundPool.load(context, R.raw.gold4, 1);
		blank = soundPool.load(context, R.raw.blank, 1);
		music = MediaPlayer.create(context, R.raw.backgroundmusic);
	}

	public static void playSelect(String soundName){ //plays the selected sound from the soundpool
		if (mute) return; // if sound is turned off no need to continue
		if (soundName.equals("mine"))
			soundPool.play(mine, 1, 1, 1, 0, 1);
		if (soundName.equals("gold")){
			double random = Math.random(); //we want four different sounds when you hit gold, each in the right key
			int goldNumber = gold1;
			if(random <= .25) goldNumber = gold1;
			if(random > .25 && random <= .5) goldNumber = gold2;
			if(random > .50 && random <= .75) goldNumber = gold3;
			if(random > .75 && random <= 1) goldNumber = gold4;
			soundPool.play(goldNumber, 1, 1, 1, 0, 1);
		}
		if (soundName.equals("blank"))
			soundPool.play(blank, 1, 1, 1, 0, 1);
	}

	public static final void playMusic(){ //plays the background music
		if (mute) return;
		if (!music.isPlaying()){
			music.seekTo(0);	
			music.start();
			music.setLooping(true);
		}
	}

	public static final void pauseMusic(){ //pauses the music
		if (mute) return;
		if (music.isPlaying()) music.pause();
	}

	public static final void unPauseMusic(){ //pauses the music
		if (mute) return;
		if (!music.isPlaying()) music.start();
	}

	public static final void release(){ //kill everything
		if (mute) return;
		soundPool.release();
		music.stop();
		music.release();
	}
	
	public static boolean isMute(){
		return mute;
	}
	
	public static void setMute(boolean b){
		mute = b;
	}
}