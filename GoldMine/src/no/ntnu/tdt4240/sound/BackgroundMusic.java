package no.ntnu.tdt4240.sound;

import no.ntnu.tdt4240.activities.SettingsActivity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

public class BackgroundMusic{
	private static SoundPool soundPool;
	private static int mine;
	private static int gold;
	private static int blank;
	private static MediaPlayer music;
	private static boolean mute = false;
	
	public static void loadSound(Context context) {
	    mute = SettingsActivity.isMuted(context); // should there be sound?
	    soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
	    
	 /*   mine = soundPool.load(context, R.raw.FILENNAME, 1);
	    gold = soundPool.load(context, R.raw.FILENAME, 1);
	    blank = soundPool.load(context, R.raw.FILENAME, 1);
	    
	    music = MediaPlayer.create(context, R.raw.FILENAME);*/
	}
	
	public static void playSelect(){ //plays the selected sound from the soundpool
	    if (mute) return; // if sound is turned off no need to continue
	    soundPool.play(mine, 1, 1, 1, 0, 1);
	}
	
	public static final void playMusic(){ //plays the background music
	    if (mute) return;
	    if (!music.isPlaying()){
	    music.seekTo(0);
	    music.start();
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
}