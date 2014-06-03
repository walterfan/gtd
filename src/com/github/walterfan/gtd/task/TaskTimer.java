package com.github.walterfan.gtd.task;

import java.util.Timer;
import java.util.TimerTask;

import android.util.Log;

public class TaskTimer {
	private static final String TAG = TaskTimer.class.getSimpleName();
	
	private static final int MAX_WAITING_TIME = 8000;
	
	private Timer mTheTimer;
	
	public void startCountDown() {
		mTheTimer = new Timer();
		mTheTimer.schedule(new TimerTask() {

			@Override
			public void run() {
				stopCountDown();				
			}
			
		}, MAX_WAITING_TIME);
	}
	
	public void stopCountDown() {
		if(mTheTimer == null) {
			return;
		}
		Log.d(TAG, "stopCountDown");
		mTheTimer.cancel();
		mTheTimer = null;
		
		
	}
}
