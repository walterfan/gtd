package com.github.walterfan.gtd.task;


import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.walterfan.gtd.R;

public class TaskBroadcastActivity extends Activity {
	
	private View.OnClickListener mRegListener = null;
	
	private View.OnClickListener mSendListener = null;
	
	private View.OnClickListener mStopListener = null;
	
	private TaskBroadcastReceiver mTaskReceiver = null;

	public TaskBroadcastActivity() {
		mRegListener = new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				IntentFilter intentFilter = new IntentFilter();
				intentFilter.addAction("com.github.walterfan.gtd.TaskSyncAction");
				
				mTaskReceiver = new TaskBroadcastReceiver();
				registerReceiver(mTaskReceiver, intentFilter);
				
			}
		};
		
		mSendListener = new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent("com.github.walterfan.gtd.TaskSyncAction");				
				intent.putExtra("DATA", "task come");
				sendBroadcast(intent);
				
			}
		};
		
		mStopListener = new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				unregisterReceiver(mTaskReceiver);
				
			}
		};
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.task_broadcast);
		
		Button sendBtn = (Button)findViewById(R.id.send_button);
		Button stopBtn = (Button)findViewById(R.id.stop_button);
		Button registerBtn = (Button)findViewById(R.id.register_button);
		
		registerBtn.setOnClickListener(mRegListener);
		sendBtn.setOnClickListener(mSendListener);
		stopBtn.setOnClickListener(mStopListener);
		
	}

}
