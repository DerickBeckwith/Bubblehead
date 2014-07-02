package com.example.bubblehead;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class FirstActivity extends Activity {

  private static String TAG = "FirstActivity";
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_first);
  }
  
  //onClick() for the get active wifi connection button  
  public void getActiveWifiConnection(View view){
    Toast.makeText(getApplicationContext(), "Under Construction", Toast.LENGTH_LONG).show();
  }
  
  //onClick() for the goto main
  public void gotoMain(View view){
    Intent intent = new Intent();
    setResult(1000,intent);
    finish();
  }
  
}
