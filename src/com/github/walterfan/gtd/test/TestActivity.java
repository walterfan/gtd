package com.github.walterfan.gtd.test;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TestActivity extends ListActivity {
	private static final String TAG = "GTD.TestActivity";
	
	private String[] tests = {"MediaPlayerTest", "SoundPoolTest"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate...");
		 
		final ListView listView = getListView();
		listView.setTextFilterEnabled(true);
		
		this.setListAdapter(new ArrayAdapter<String>(this, 
				android.R.layout.simple_list_item_1, tests));
		
	}
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		String testName = tests[position];
		try {
			testName = "com.github.walterfan.gtd.test." + testName;
			Class cls = Class.forName(testName);
			Intent intent = new Intent(this, cls);
			startActivity(intent);
		} catch(Exception e) {
			Log.e(TAG, "Not found " + testName + ", " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	

}
