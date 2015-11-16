package com.kindy.messenger;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.view.View;

import com.kindy.messenger.utils.Debug;


public class MainActivity extends Activity {
	private static final String TAG = "MainActivity";
	
	
	private RemoteServiceConnection mRemoteServiceConnection;
	private Messenger mMessengerReciever;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    	Debug.o(TAG, " onCreate"); 
        
        mRemoteServiceConnection = new RemoteServiceConnection();
        
        mMessengerReciever = new Messenger(new Handler(new Handler.Callback() {
    		
    		@Override
    		public boolean handleMessage(Message msg) {
    			switch (msg.what) {  
                case RemoteService.SAY_HELLO_TO_CLIENT:
                	Debug.o(TAG, "RemoteService.SAY_HELLO_TO_CLIENT"); 
                    break;  
            } 
    			return false;
    		}
    		
    	}));
        
        
        myBindService();
    }

    public void onClick(View v) {
        Message msg = new Message();  
        msg.what = RemoteService.MSG_SAY_HELLO;
        msg.replyTo = mMessengerReciever;  
        try {  
        	mRemoteServiceConnection.getMessenger().send(msg);
        } catch (RemoteException e) {  
            e.printStackTrace();  
        } 
    }
    
    public void onClick2(View v) {
    	this.startActivity(new Intent(this, AidlActivity.class));
    }

    private void myBindService() {
    	if(mRemoteServiceConnection != null) {
    		myUnbindService();
    		Intent service = new Intent(this.getApplicationContext(), RemoteService.class);  
            this.bindService(service, mRemoteServiceConnection, Context.BIND_AUTO_CREATE);
    	}
    }
    private void myUnbindService() {
    	if(mRemoteServiceConnection != null) {
    		try {
    			this.unbindService(mRemoteServiceConnection);
    		} catch(Exception e) { }
    		
    	}
    }

	@Override
	protected void onDestroy() {
		Debug.o(TAG, " onDestroy"); 
		
        try {  
        	Message msg = new Message();  
            msg.what = RemoteService.SERVICE_EXIT;
        	mRemoteServiceConnection.getMessenger().send(msg);
        } catch (RemoteException e) {  
            e.printStackTrace();  
        }
        
		myUnbindService();
		
		super.onDestroy();
		
		System.exit(0);
	}
	
}
