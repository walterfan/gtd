package com.github.walterfan.gtd.test;

import java.io.IOException;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class SoundPoolTest extends Activity implements OnTouchListener {
	private static final String TAG = "GTD.SoundPoolTest";
	private String fileName = "EnemyDeath.ogg";
	private SoundPool soundPool;
	private int soundId = -1;
	private TextView textView;
	@Override
	public boolean onTouch(View view, MotionEvent event) {
		textView.setText("Play by touch " + event.getAction());
		if(event.getAction() == MotionEvent.ACTION_DOWN) {
			Log.d(TAG, "onTouch...ACTION_DOWN");
			if(soundId != -1) {
				soundPool.play(soundId,  1, 1, 0, 0, 1);
			}
		}
		return false;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate...");
		 
		textView = new TextView(this);
		textView.setOnTouchListener(this);
		setContentView(textView);
		
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		soundPool  = new SoundPool(20, AudioManager.STREAM_MUSIC, 0);
		
		try {
			AssetManager assetManager = getAssets();
			AssetFileDescriptor desc = assetManager.openFd(fileName);
			soundId  = soundPool.load(desc, 1);
		}catch(IOException e) {
			textView.setText("Could not load file " + fileName);
			
		}
	}
}
