package com.example.bubblehead;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

//Service provides functions to retrieve time
//NOTE: Requires the following in Manifest file
//<service android:name=".BoundService"/>
public class BoundService extends Service{
  
  private static String TAG = "BoundService";
  
  private final IBinder myBinder = new MyLocalBinder();
  
  @Override
  public IBinder onBind(Intent arg0){    
    return myBinder;
  }
  
  public class MyLocalBinder extends Binder{
    BoundService getService(){
      return BoundService.this;
    }
  }  
  
  //Add service functions below here
  public String getCurrentTime(){
    Log.d(TAG,"getCurrentTime()");
    SimpleDateFormat dateformat =
        new SimpleDateFormat("HH:mm:ss MM/dd/yyyy", Locale.US);
    return (dateformat.format(new Date()));
  }
  
  public String getCurrentDate(){
    SimpleDateFormat dateformat =
        new SimpleDateFormat("MM/dd/yyyy", Locale.US);
    return (dateformat.format(new Date()));    
  }
    

  
}
