package com.example.bubblehead;

import com.example.bubblehead.BoundService.MyLocalBinder;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
  
  private static String TAG = "MainActivity";
  
  //required for the bound service - date time
  BoundService myService;
  boolean isBound = false;
  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//required for the bound service - date time
		Intent intent = new Intent(this, BoundService.class);
		bindService(intent, myConnection, Context.BIND_AUTO_CREATE);
	}
	
	//onClick to go to first activity
	public void gotoFirstActivity(View view){
	  Intent intent = new Intent(getApplication().getBaseContext(),FirstActivity.class);
	  startActivityForResult(intent,1000);	  
	}
	
	//onClick to get time
	public void getTime(View v){
	  Log.d(TAG,"getTime");
	  
	  if (myService != null) {
		  try {
			  String currentTime = myService.getCurrentTime();
			  Log.d(TAG,"showTime(): " + currentTime);	    
			  TextView myTextViewTime = (TextView)findViewById(R.id.textViewTime);
			  myTextViewTime.setText(currentTime);
		  } catch (NullPointerException exception) {
			  Log.d(TAG, "NPE thrown when calling getCurrentTime()");
		  }
	  } else {
		  Log.d(TAG, "myService is NULL!");
	  }
	}
	
	//process results from returning activities
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
	  switch(requestCode){
	  
	  case 1000://case for FirstActivity
	    if( resultCode == RESULT_OK){
	      Toast.makeText(getApplicationContext(), "RESULT_OK returned", Toast.LENGTH_LONG).show();	      
	    }else{
	      Toast.makeText(getApplicationContext(), "Error returned", Toast.LENGTH_LONG).show();
	    }
	    break;
	  }	  
	  
	}
	
	//required for bound service
  private ServiceConnection myConnection = new ServiceConnection(){
    
    public void onServiceConnected(ComponentName className, IBinder service){
      MyLocalBinder binder = (MyLocalBinder) service;
      myService = binder.getService();
      isBound = true;
      Log.d(TAG,"onServiceConnected");
    }
    
    public void onServiceDisconnected(ComponentName arg0){
      isBound = false;
    }
  };	
}
