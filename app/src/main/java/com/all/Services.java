package com.all;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Services extends AppCompatActivity {
    Button start_service;
    Button stop_service;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_services);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle((CharSequence) "Services");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        stop_service = (Button) findViewById(R.id.stop_service);
        start_service= (Button) findViewById(R.id.start_service);

        start_service.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Services.this.startService(new Intent(Services.this, My_Service_Demo.class));
            }
        });
        stop_service.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Services.this.stopService(new Intent(Services.this, My_Service_Demo.class));
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
