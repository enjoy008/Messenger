package com.kindy.messenger;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;

import com.kindy.messenger.aidl.AidlService;
import com.kindy.messenger.aidl.AidlServiceConnection;
import com.kindy.messenger.aidl.User;

public class AidlActivity extends Activity {
	
	private AidlServiceConnection mAidlServiceConnection;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl);
        
        mAidlServiceConnection = new AidlServiceConnection();
        
        Intent service = new Intent(this.getApplicationContext(), AidlService.class);  
        this.bindService(service, mAidlServiceConnection, Context.BIND_AUTO_CREATE);
	}

	public void onClick1(View view) {
		try {
			User user = mAidlServiceConnection.getIAIDL().getUser("Kindy");
			System.out.println(" ==== " + user.toString());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void onClick2(View view) {
		try {
			User user = new User();
			user.id = 1;
			user.name = "Kindy";
			user.age = 8;
			
			mAidlServiceConnection.getIAIDL().trainUser(user);
			System.out.println(" ==== " + user.toString());
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		
		this.unbindService(mAidlServiceConnection);
	}
}
