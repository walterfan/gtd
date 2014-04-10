package com.github.walterfan.gtd.test;

import java.io.IOException;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MediaPlayerTest extends Activity {
	private static final String TAG = "GTD.MediaPlayerTest";
	private MediaPlayer mediaPlayer;
	private String fileName = "Rain.ogg";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate...");
		
		TextView textView = new TextView(this);
		setContentView(textView);
		
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		mediaPlayer = new MediaPlayer();
		
		mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		
		try {
			AssetManager assetManager = getAssets();
			AssetFileDescriptor desc = assetManager.openFd(fileName);
			mediaPlayer.setDataSource(desc.getFileDescriptor(), 
					desc.getStartOffset(), desc.getLength());
			mediaPlayer.prepare();
			mediaPlayer.setLooping(true);
		}catch(IOException e) {
			textView.setText("Could not load file " + fileName);
			mediaPlayer = null;
		}
		
	}

	@Override
	protected void onResume() {
		Log.d(TAG, "onResume...");
		super.onResume();
		if(null !=  mediaPlayer) {
			mediaPlayer.reset();
			mediaPlayer.start();
		}
	}

	@Override
	protected void onPause() {
		Log.d(TAG, "onPause...");
		super.onPause();
		if(null !=  mediaPlayer) {
			mediaPlayer.pause();
			if(isFinishing()) {
				mediaPlayer.stop();
				mediaPlayer.release();
			}
		}
	}
	
	
}
