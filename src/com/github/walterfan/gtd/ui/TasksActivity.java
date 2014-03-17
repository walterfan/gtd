package com.github.walterfan.gtd.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.github.walterfan.gtd.R;

public class TasksActivity extends Activity {

	private List<Map<String, ?>> _tasks = new ArrayList<Map<String, ?>>(10);
	//TODO: get task from sqlite
	private void initTasks() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("icon", R.drawable.ic_launcher);
		map.put("title", "Practice English");
		map.put("priority", 0);
		_tasks.add(map);
		
		map = new HashMap<String, Object>();
		map.put("icon", R.drawable.ic_launcher);
		map.put("title", "Write Kanban Web APP");
		map.put("priority", 2);
		_tasks.add(map);
		
		map = new HashMap<String, Object>();
		map.put("icon", R.drawable.ic_launcher);
		map.put("title", "Write Kanban Server");
		map.put("priority", 1);
		_tasks.add(map);
		
		map = new HashMap<String, Object>();
		map.put("icon", R.drawable.ic_launcher);
		map.put("title", "Write RTC book");
		map.put("priority", 1);
		_tasks.add(map);
		
		map = new HashMap<String, Object>();
		map.put("icon", R.drawable.ic_launcher);
		map.put("title", "Write GTD app");
		map.put("priority", 1);
		_tasks.add(map);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tasks);

		initTasks();
		
		ListView listView = (ListView)this.findViewById(R.id.task_list_view);
		TaskListViewAdapter adapter = new TaskListViewAdapter(this, _tasks, 
				R.layout.task_item, 
				new String[]{"icon","title","priority"}, 
				new int[]{R.id.task_icon, R.id.task_title, R.id.task_priority});
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				Toast.makeText(TasksActivity.this, "select position=" + position, Toast.LENGTH_SHORT).show();
				
			}
			
		});
	}

}