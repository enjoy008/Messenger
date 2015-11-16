package com.kindy.messenger;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.widget.Toast;

public class RemoteService extends Service {  
	  
    public static final int MSG_SAY_HELLO = 0;  
    public static final int SAY_HELLO_TO_CLIENT = 1; 
    public static final int SERVICE_EXIT = 2; 
  
    @Override  
    public IBinder onBind(Intent intent) {  
      return mMessenger.getBinder();
    }
  
    private Handler IncomingHandler = new Handler(new Handler.Callback() {
		
		@Override
		public boolean handleMessage(Message msg) {
            switch (msg.what) {  
                case MSG_SAY_HELLO:  
                    Toast.makeText(RemoteService.this.getApplicationContext(), "Remote Service: Hello World!", Toast.LENGTH_SHORT).show();  
                    
                    if(msg.replyTo != null){  
                        Message msg_client = IncomingHandler.obtainMessage();  
                        msg_client.what = SAY_HELLO_TO_CLIENT;
                        try {  
                            msg.replyTo.send(msg_client);  
                        } catch (RemoteException e) {  
                            e.printStackTrace();  
                        }  
                    }
                    break;  
                case SERVICE_EXIT:
                	System.exit(0);
                	break;
            } 
            
			return false;
		}
	});  
      
    private Messenger  mMessenger = new Messenger (IncomingHandler);  
}  

