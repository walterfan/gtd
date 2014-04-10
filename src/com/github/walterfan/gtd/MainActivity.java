package com.github.walterfan.gtd;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

import com.github.walterfan.gtd.service.DataSyncService;
import com.github.walterfan.gtd.test.TestActivity;
import com.github.walterfan.gtd.ui.DisplayMessageActivity;

public class MainActivity extends Activity implements OnClickListener {
	public final static String EXTRA_MESSAGE = "com.github.walterfan.gtd.MESSAGE";
	
	private static final String TAG = "GTD.MainActivity";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate...");
   
        
        View testButton = findViewById(R.id.btn_test);
        testButton.setOnClickListener(this);
        
        View testSignIn = findViewById(R.id.btn_signin);
        testSignIn.setOnClickListener(this);
        
        View testAbout = findViewById(R.id.btn_about);
        testAbout.setOnClickListener(this);
        
        View testExit = findViewById(R.id.btn_exit);
        testExit.setOnClickListener(this);
    }
    
	public void addTask(View view) {
		Intent intent = new Intent(this, DisplayMessageActivity.class);
	    EditText editText = (EditText) findViewById(R.id.task_name);
	    String message = editText.getText().toString();
	    intent.putExtra(EXTRA_MESSAGE, message);
	    startActivity(intent);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main_activity_actions, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_search:
	            openSearch();
	            return true;
	        case R.id.action_settings:
	            openSettings();
	            return true;
	        case R.id.action_start_sync:
	            startService();
	            return true;
	        case R.id.action_stop_sync:
	        	stopService();
	            return true;    
	            
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	private void openSearch() {
		Log.d(TAG, "--openSearch...");
	}
	
	private void openSettings() {
		Log.d(TAG, "--openSettings...");
		
	}

	private void startService() {
		Log.d(TAG, "--startService--");
		Intent intent = new Intent(this, DataSyncService.class);
		startService(intent);
		Toast.makeText(this, "started service", Toast.LENGTH_SHORT).show();
	}
	
	private void stopService() {
		Log.d(TAG, "--stopService--");
		Intent intent = new Intent(this, DataSyncService.class);
		stopService(intent);
		Toast.makeText(this, "stopped service", Toast.LENGTH_SHORT).show();
	}
	
	@Override
	public void onClick(View view) {
		switch(view.getId())
		{
		case R.id.btn_test:
			Intent i = new Intent(this, TestActivity.class);
			startActivity(i);
			break;
		case R.id.btn_about:
			Toast.makeText(this, "Wrote by Walter Fan on 4/10/14", Toast.LENGTH_LONG).show();
			break;
		case R.id.btn_exit:
			finish();
			break;
		default:
			Toast.makeText(this, "TBD...Walter Fan", Toast.LENGTH_LONG).show();
		
		}
		
	}
}
