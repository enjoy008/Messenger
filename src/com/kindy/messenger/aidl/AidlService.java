package com.kindy.messenger.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class AidlService extends Service {
	
	@Override
	public IBinder onBind(Intent intent) {
		return new MyBinder();
	} 

	private class MyBinder extends IAIDL.Stub {

		@Override
		public User getUser(String name) throws RemoteException {
			System.out.println(" ==== MyBinder getUser() : " + name);
			
			User user = new User();
			user.id = 1;
			user.name = name;
			user.age = 8;
			
			return user;
		}

		@Override
		public void trainUser(User user) throws RemoteException {
			System.out.println(" ==== MyBinder trainUser() : " + user.toString());
			user.name = "superMan";
		}

	}
}
