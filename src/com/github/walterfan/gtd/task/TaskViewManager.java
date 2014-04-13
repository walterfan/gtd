package com.github.walterfan.gtd.task;

import java.io.InputStream;

import org.apache.http.util.EncodingUtils;

import android.app.Activity;

public class TaskViewManager {
	
	public String getFromAsset(Activity activity, String fileName) {
		String result = "";
		try {

			InputStream in = activity.getResources().getAssets().open(fileName);
			int length = in.available(); 
			byte[] buffer = new byte[length]; 
			in.read(buffer); 
			result = EncodingUtils.getString(buffer, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return result;
	}
	
	public void listTasks() {
		
	}
}
