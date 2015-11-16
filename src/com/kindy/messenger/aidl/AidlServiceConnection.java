package com.kindy.messenger.aidl;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

public class AidlServiceConnection implements ServiceConnection {
	private IAIDL mIAIDLBinder;

	@Override
	public void onServiceConnected(ComponentName name, IBinder service) {
		mIAIDLBinder =  IAIDL.Stub.asInterface(service);
	}

	@Override
	public void onServiceDisconnected(ComponentName name) {
		mIAIDLBinder = null;
	}

	public IAIDL getIAIDL() {
		return mIAIDLBinder;
	}
}
