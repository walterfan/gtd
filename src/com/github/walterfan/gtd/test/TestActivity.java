package com.github.walterfan.gtd.test;

import java.util.HashMap;
import java.util.Map;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TestActivity extends ListActivity {
	private static final String TAG = "GTD.TestActivity";
	private Map<String, String> testCaseMap = new HashMap<String, String>();
	private String[] testCases;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate...");
		
		testCaseMap.put("MediaPlayerTest", "com.github.walterfan.gtd.test.MediaPlayerTest");
		testCaseMap.put("SoundPoolTest",  "com.github.walterfan.gtd.test.SoundPoolTest");
		//testCaseMap.put("TaskActivity",  "com.github.walterfan.gtd.ui.TasksActivity");
		testCaseMap.put("SensorTest",  "com.github.walterfan.gtd.test.SensorTest");
		testCaseMap.put("ShapeTest",  "com.github.walterfan.gtd.test.ShapeTest");
		testCaseMap.put("DialogTest",  "com.github.walterfan.gtd.test.DialogTest");
		
		int testCount = testCaseMap.size();
		testCases = new String[testCount];
		
		final ListView listView = getListView();
		listView.setTextFilterEnabled(true);
		
		int i = 0;
		for(Map.Entry<String, String> entry: testCaseMap.entrySet()) {
			testCases[i++] = entry.getKey();			
		}
		
		this.setListAdapter(new ArrayAdapter<String>(this, 
				android.R.layout.simple_list_item_1, testCases));
		
	}
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		String testName = testCases[position];
		try {			
			Class cls = getTestClass(testName);
			Intent intent = new Intent(this, cls);
			startActivity(intent);
		} catch(Exception e) {
			Log.e(TAG, "Not found " + testName + ", " + e.getMessage());
			e.printStackTrace();
		}
	}
	private Class getTestClass(String testName) throws ClassNotFoundException {
		String testClsName = testCaseMap.get(testName);
		return Class.forName(testClsName);		
	}
	
	

}
