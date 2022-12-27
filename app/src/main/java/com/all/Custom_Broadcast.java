package com.all;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Custom_Broadcast extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "This is Custom Broadcast....", Toast.LENGTH_SHORT).show();
    }
}
