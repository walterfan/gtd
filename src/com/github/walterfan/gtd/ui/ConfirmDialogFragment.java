package com.github.walterfan.gtd.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import com.github.walterfan.gtd.R;

public class ConfirmDialogFragment extends DialogFragment {
	DialogInterface.OnClickListener okayListener;
	DialogInterface.OnClickListener cancelListener;
	
    public DialogInterface.OnClickListener getOkayListener() {
		return okayListener;
	}

	public void setOkayListener(DialogInterface.OnClickListener okayListener) {
		this.okayListener = okayListener;
	}

	public DialogInterface.OnClickListener getCancelListener() {
		return cancelListener;
	}

	public void setCancelListener(DialogInterface.OnClickListener cancelListener) {
		this.cancelListener = cancelListener;
	}

	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		if(null == okayListener) {
			okayListener = new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(getActivity(), "click okay", Toast.LENGTH_SHORT).show();
					
				}
			};
		}
		
		if(null == cancelListener) {
			cancelListener = new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(getActivity(), "click cancel", Toast.LENGTH_SHORT).show();
					
				}
			};
		}
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.dialog_prompt)
               .setPositiveButton(R.string.dialog_ok, this.getOkayListener())
               .setNegativeButton(R.string.dialog_cancel, this.getCancelListener());
        return builder.create();
    }
}
