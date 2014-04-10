package com.github.walterfan.gtd.test;

import android.app.Activity;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class SoundPoolTest extends Activity implements OnTouchListener {
	private static final String TAG = "GTD.SoundPoolTest";
	private SoundPool soundPool;
	
	@Override
	public boolean onTouch(View arg0, MotionEvent arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate...");
		 
	}
}
