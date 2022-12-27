package com.all;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class My_Service_Demo extends Service {
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast toast = Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT);
        toast.setGravity(17, 0, 0);
        toast.show();
        return START_STICKY;
    }

    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service Stoppted", Toast.LENGTH_SHORT).show();
    }

    public IBinder onBind(Intent intent) {
        return null;
    }
}
