package com.github.walterfan.gtd;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class LoginActivity extends Activity {
	
	private static final String TAG = "LoginActivity";
	private static final boolean D = true;
	
	private EditText userNameEditText;
	private EditText passwordEditText;
	private Button loginButton;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        

        setContentView(R.layout.activity_login);
        
        userNameEditText = (EditText)this.findViewById(R.id.userNameEditText);
        passwordEditText = (EditText)this.findViewById(R.id.passwordEditText);
        
        loginButton = (Button)this.findViewById(R.id.loginButton);
        
        loginButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
		        String userName  = userNameEditText.getText().toString().trim();
		        String password  = passwordEditText.getText().toString().trim();
		        
		        if(D) Log.d(TAG, "Username£º"+userName);
		        if(D) Log.d(TAG, "Password£º"+password);
		        
		        
		        if("walter".equals(userName) && "pass".equals(password)){
		        	
		        	Toast.makeText(LoginActivity.this, "Login successfully!", Toast.LENGTH_SHORT).show();
		        }else{
		        	Toast.makeText(LoginActivity.this, "username or password error!", Toast.LENGTH_SHORT).show();
		        }
			}
		});
        
    }
}