package com.example.bubblehead;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	//onClick to go to first activity
	public void gotoFirstActivity(View view){
	  Intent intent = new Intent(getApplication().getBaseContext(),FirstActivity.class);
	  startActivityForResult(intent,1000);	  
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
}
