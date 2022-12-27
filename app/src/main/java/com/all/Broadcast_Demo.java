package com.all;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Broadcast_Demo extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {
            Toast.makeText(context, "Boots Compleated", Toast.LENGTH_SHORT).show();
        }
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            Toast.makeText(context, "Connectivity Changed", Toast.LENGTH_SHORT).show();
        }
    }
}
