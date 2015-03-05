package com.mma.androidlabtest;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;

public class Main extends Activity {

    private MediaPlayer mediaPlayer;

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.main);
        try {
	        mediaPlayer = new MediaPlayer();
	        mediaPlayer.setDataSource(Environment.getExternalStorageDirectory().getAbsolutePath() + "sound.mp3");
	        mediaPlayer.prepare();
	        mediaPlayer.start();
        } catch (Exception e) {
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
        	mediaPlayer.release();
        	mediaPlayer = null;
        }
    }
}
