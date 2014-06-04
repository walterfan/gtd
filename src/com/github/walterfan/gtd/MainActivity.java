package com.github.walterfan.gtd;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.github.walterfan.gtd.service.DataSyncService;
import com.github.walterfan.gtd.test.TestActivity;
import com.github.walterfan.gtd.ui.TaskListViewAdapter;

public class MainActivity extends Activity implements OnClickListener {
	public final static String EXTRA_MESSAGE = "com.github.walterfan.gtd.MESSAGE";
	
	private List<Map<String, ?>> _tasks = new ArrayList<Map<String, ?>>(10);
	private TaskListViewAdapter _adapter;
	private ListView _taskListView;
	
	private static final String TAG = "MainActivity";
	
	private List<Map<String, ?>> _taskList;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate...");
   
        Map<String, Object> map = new HashMap<String, Object>();
		map.put("isdone", false);
		map.put("title", "Practice English");
		map.put("priority", 0);
		map.put("button", R.drawable.ic_content_edit);
		_tasks.add(map);
		
        ViewGroup sv = (ViewGroup)findViewById(R.id.task_list_panel);
        
        _taskListView = new ListView(this);
        //_taskListView.setId(View.generateViewId());
        sv.addView(_taskListView);
        _adapter = new TaskListViewAdapter(this, _tasks, 
				R.layout.task_item, 
				new String[]{"isdone","title","priority", "button"}, 
				new int[]{R.id.task_isdone, R.id.task_title, R.id.task_priority, R.id.task_button});
		_taskListView.setAdapter(_adapter);
		_taskListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				Toast.makeText(MainActivity.this, "select position=" + position, Toast.LENGTH_SHORT).show();
				
			}
			
		});
		
		View addTaskBtn = findViewById(R.id.task_add);
		addTaskBtn.setOnClickListener(this);
        
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
    

	public void addTask(final View view) {
		//Intent intent = new Intent(this, DisplayMessageActivity.class);
		if(_taskListView == null){
			return;
		}

	    EditText editText = (EditText) findViewById(R.id.task_name);
	    final String message = editText.getText().toString();
		
	    Runnable action = new Runnable() {

			@Override
			public void run() {	
				//_tasks.clear();//why clear?
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("isdone", false);
				map.put("title", message);
				map.put("priority", 0);
				map.put("button", R.drawable.ic_content_edit);
				_tasks.add(map);

				//_adapter.setData(_tasks);
				_adapter.notifyDataSetChanged();
				Log.d(TAG, "add task " + message + ", count=" +_adapter.getCount());			
			}    	
	    };
	    
	    Handler handler = new Handler();
	    handler.postDelayed(action,1000);
	    
		/*view.animate().setDuration(500).alpha(0).withEndAction(new Runnable() {
			@Override
			public void run() {
				//_tasks.clear();//why clear?
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("isdone", false);
				map.put("title", message);
				map.put("priority", 0);
				_tasks.add(map);

				//_adapter.setData(_tasks);
				_adapter.notifyDataSetChanged();
				Log.d(TAG, "add task " + message + ", count=" +_adapter.getCount());

				view.setAlpha(1);
			}
		});
		*/
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
