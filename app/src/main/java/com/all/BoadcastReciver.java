package com.all;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class BoadcastReciver extends AppCompatActivity {
    Button broadcast_btn;
    Button custom_broadcast;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boadcast_reciver);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle( "Broadcast Reciver");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        broadcast_btn = (Button) findViewById(R.id.broadcast_btn);
        custom_broadcast = (Button) findViewById(R.id.custom_broadcast);

        broadcast_btn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            }
        });

        custom_broadcast.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.own.all.Broadcast.call");
                intent.addCategory("android.intent.category.DEFAULT");
                BoadcastReciver.this.sendBroadcast(intent);
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
