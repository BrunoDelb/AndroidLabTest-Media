package com.mma.androidlabtest;

import android.app.Activity;
import android.media.JetPlayer;
import android.media.JetPlayer.OnJetEventListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class Main extends Activity /*implements OnJetEventListener*/ {

	JetPlayer jetPlayer;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);        
        setContentView(R.layout.main);
        findViewById(R.id.button).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				jetPlayer.clearQueue();
				jetPlayer.queueJetSegment (0, -1, 0, 0, 0, (byte)0);
				jetPlayer.queueJetSegment (1, -1, -1, 0, 0, (byte)0);
				jetPlayer.play();		
			}
		});        
        jetPlayer = JetPlayer.getJetPlayer();        
        jetPlayer.setEventListener(new OnJetEventListener() {
			
			public void onJetUserIdUpdate(JetPlayer player, int userId, int repeatCount) {
			}
			
			public void onJetPauseUpdate(JetPlayer player, int paused) {
			}
			
			public void onJetNumQueuedSegmentUpdate(JetPlayer player, int nbSegments) {
			}
			
			public void onJetEvent(JetPlayer player, short segment, byte track, byte channel, byte controller, byte value) {
				Toast.makeText(getApplicationContext(), "Jet value: " + value, Toast.LENGTH_SHORT).show();
			}
		});
        jetPlayer.loadJetFile(getResources().openRawResourceFd(R.raw.sound));
    }

    protected void onDestroy() {
    	jetPlayer.clearQueue();
    	super.onDestroy();
    }
}
