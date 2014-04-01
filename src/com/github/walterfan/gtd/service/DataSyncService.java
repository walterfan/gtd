package com.github.walterfan.gtd.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class DataSyncService extends Service {

	//private int NOTIFICATION = R.string.data_sync_service_started;
	private static final String TAG = DataSyncService.class.getSimpleName();
	
	private int serviceCount;
	
	private boolean serviceFlag;
	
	private final IBinder binder = new ServiceCountBinder();
	
	public class ServiceCountBinder extends Binder {
		
		public int getServiceCount() {
			return serviceCount;
		}
	}
	
	@Override
	public IBinder onBind(Intent arg0) {
		Log.d(TAG, "--onBind--");
		return binder;
	}
	
	@Override
	public boolean onUnbind(Intent intent) {
		Log.d(TAG, "--onunbind--");
		return super.onUnbind(intent);
	}
	
	@Override
	public void onCreate() {
	
		Log.d(TAG, "-- ServiceCountBinder onCreate --");
		serviceFlag = true;
		
		new Thread(new Runnable() {
			@Override
			public void run () {
				while(serviceFlag) {
					try {
						Thread.sleep(1000);
					} catch(Exception e) {
						Log.e(TAG, e.getMessage());
					}
					serviceCount ++;
					Log.d(TAG, "--serviceCount=" + serviceCount);
				}
			}
		}).start();
		
		Log.d(TAG, "--onCreate--");
		super.onCreate();
	}
	
	@Override
	public void onStart(Intent intent, int startId) {
		Log.d(TAG, "--onStart--");
		
		super.onStart(intent, startId);
	}
	
	@Override
	public void onDestroy() {
		Log.d(TAG, "--onStart");
		serviceFlag = false;
		super.onDestroy();
	}

}
