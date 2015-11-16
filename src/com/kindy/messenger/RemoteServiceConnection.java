package com.kindy.messenger;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Messenger;

import com.kindy.messenger.utils.Debug;

public class RemoteServiceConnection implements ServiceConnection {
	private static final String TAG = "RemoteServiceConnection";
	
	private Messenger mMessenger;

	@Override
	public void onServiceConnected(ComponentName name, IBinder service) {
		Debug.o(TAG, " onServiceConnected : " + name);
		mMessenger = new Messenger(service);
	}

	@Override
	public void onServiceDisconnected(ComponentName name) {
		Debug.o(TAG, " onServiceDisconnected : " + name); 
		mMessenger = null;
	}

    public Messenger getMessenger() {
    	return mMessenger;
    }
}
