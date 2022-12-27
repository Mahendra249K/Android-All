package com.all;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Async_Task extends AppCompatActivity {
    static ImageView download_image;
    Button async_btn;
    Button async_btn_image;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle("Linear Layout");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        async_btn = (Button) findViewById(R.id.async_btn);
        download_image = (ImageView) findViewById(R.id.download_image);
        async_btn_image = (Button) findViewById(R.id.async_btn_image);

        async_btn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                new Async_Task_Adpter(Async_Task.this).execute(new Void[0]);
            }
        });
        this.async_btn_image.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                new Async_Task_Image_Adpter(Async_Task.this).execute(new String[]{"https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQXd1YHRqux_0Ukr9pOveWWJW3dCGmsvGBqjw&usqp=CAU"});
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
