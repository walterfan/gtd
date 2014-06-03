package com.github.walterfan.gtd;


import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.github.walterfan.gtd.service.DataSyncService;
import com.github.walterfan.gtd.test.TestActivity;
import com.github.walterfan.gtd.ui.DisplayMessageActivity;
import com.github.walterfan.gtd.ui.TaskListViewAdapter;

public class MainActivity extends Activity implements OnClickListener {
	public final static String EXTRA_MESSAGE = "com.github.walterfan.gtd.MESSAGE";
	
	private static final String TAG = "GTD.MainActivity";
	
	private List<Map<String, ?>> _taskList;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate...");
   
        
        /*View testButton = findViewById(R.id.btn_test);
        testButton.setOnClickListener(this);
        
        View testSignIn = findViewById(R.id.btn_signin);
        testSignIn.setOnClickListener(this);
        
        View testAbout = findViewById(R.id.btn_about);
        testAbout.setOnClickListener(this);
        
        View testExit = findViewById(R.id.btn_exit);
        testExit.setOnClickListener(this);*/
    }
    
    private void initTask(View view) {
    	ListView listView = (ListView)this.findViewById(R.id.task_list_view);
		TaskListViewAdapter adapter = new TaskListViewAdapter(this, _taskList, 
				R.layout.task_detail, 
				new String[]{"isFinished","title","priority", "resource"}, 
				new int[]{R.id.cb_task_finish, R.id.txt_task, R.id.list_task, R.id.btn_task_edit});
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				Toast.makeText(MainActivity.this, "select position=" + position, Toast.LENGTH_SHORT).show();
				
			}
			
		});
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
	            break; 
	        case R.id.action_settings:
	            openSettings();
	            break; 
	        case R.id.action_start_sync:
	            startService();
	            break; 
	        case R.id.action_stop_sync:
	        	stopService();
	            break; 
	        case R.id.action_test:
				Intent i = new Intent(this, TestActivity.class);
				startActivity(i);
				break;
			case R.id.action_signin:
				Intent j = new Intent(this, LoginActivity.class);
				startActivity(j);
				break;
			case R.id.action_about:
				Toast.makeText(this, "Wrote by Walter Fan on 4/10/14", Toast.LENGTH_LONG).show();
				break;
			case R.id.action_exit:
				finish();
				break;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	    return true;    
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
		case R.id.task_add:
			this.addTask(view);
			break;

		default:
			Toast.makeText(this, "TBD...Walter Fan", Toast.LENGTH_LONG).show();
		
		}
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	protected void onResume() {
	
		super.onResume();
		View view = this.findViewById(R.id.task_list_panel);
	}
	
	
}
