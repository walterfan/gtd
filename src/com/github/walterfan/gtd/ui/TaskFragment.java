package com.github.walterfan.gtd.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.walterfan.gtd.R;

public class TaskFragment extends Fragment {
	
	@Override
    public void onCreate(Bundle savedInstanceState)
    {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        Log.d(this.getClass().getSimpleName(), "--onCreate");
    }

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
		Log.d(this.getClass().getSimpleName(), "--onCreateView");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.task_fragment, container, false);
    }


    @Override
    public void onPause()
    {
        // TODO Auto-generated method stub
        super.onPause();
        Log.d(this.getClass().getSimpleName(), "--onPause");
    }

    

    @Override
    public void onResume()
    {
        // TODO Auto-generated method stub
        super.onResume();
        Log.d(this.getClass().getSimpleName(), "--onResume");
    }

    @Override
    public void onStop()
    {
        // TODO Auto-generated method stub
        super.onStop();
        Log.d(this.getClass().getSimpleName(), "--onStop");
    }
}
