package com.github.walterfan.gtd.test;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;

public class TestActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		final ListView listView = getListView();
		listView.setTextFilterEnabled(true);
		
		//TODO: list all test activity, click and start it
		
	}

}
