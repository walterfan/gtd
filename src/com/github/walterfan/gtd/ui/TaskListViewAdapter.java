package com.github.walterfan.gtd.ui;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.github.walterfan.gtd.R;

public class TaskListViewAdapter extends BaseAdapter {

	static class ViewHolder {
		ImageView icon;
		TextView title;
		Spinner priority;
		Button button;

	}

	private Context _context;
	private int _resource;
	private List<? extends Map<String, ?>> _data;
	private String[] _from;
	private int[] _to;

	public TaskListViewAdapter(Context context,
			List<? extends Map<String, ?>> data, int resource,
			String[] from, int[] to) 
	{
		_context = context;
		_data = data;
		_resource = resource;
		_from = from;
		_to = to;
	}
	
	public void setData(List<? extends Map<String, ?>> data){
		this._data = data;
	}
	
	@Override
	public int getCount() {
		return _data.size();
		
	}

	@Override
	public Object getItem(int arg0) {
		return _data.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		if(null == convertView) {
			convertView = LayoutInflater.from(_context).inflate(_resource, parent, false);
			holder = new ViewHolder();
			holder.icon = (ImageView)convertView.findViewById(_to[0]);
			holder.title = (TextView)convertView.findViewById(_to[1]);
			holder.priority = (Spinner)convertView.findViewById(_to[2]);
			holder.button = (Button)convertView.findViewById(R.id.task_button);
			
			convertView.setTag(holder);
				
		} else {
			holder = (ViewHolder)convertView.getTag();
		}
		
		final Map<String, ?> dataSet = _data.get(position);
		if(null == dataSet) return null;
		
		final Object data0 = dataSet.get(_from[0]);
		final Object data1 = dataSet.get(_from[1]);
		final Object data2 = dataSet.get(_from[2]);
		
		holder.icon.setImageResource((Integer)data0);
		holder.title.setText(data1.toString());
		holder.priority.setSelection((Integer)data2);
		
		holder.button.setFocusable(false);
		holder.button.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Toast.makeText(_context, "TBD...Walter Fan", Toast.LENGTH_LONG).show();		
			}
		});
		
		return convertView;
	}
}
