package com.github.walterfan.gtd.test;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.github.walterfan.gtd.R;
import com.github.walterfan.gtd.ui.ConfirmDialogFragment;

public class DialogTest extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simple_linear);

		View tv = findViewById(R.id.textView1);

		((TextView) tv).setText("Example of displaying an alert dialog with a DialogFragment");

		Button button = (Button) findViewById(R.id.button1);

		button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				showConfirmDialog();
			}
		});

	}

	public void showConfirmDialog() {
		// Create an instance of the dialog fragment and show it
		DialogFragment dialog = new ConfirmDialogFragment();
		dialog.show(getFragmentManager(), "ConfirmDialogFragment");
	}

}
