package com.all;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final int time = 1000;
    private ImageView logo;
    private Animation main;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo = (ImageView) findViewById(R.id.logo);
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.main);
        logo.startAnimation(loadAnimation);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                MainActivity.this.startActivity(new Intent(MainActivity.this, FirstPage.class));
                MainActivity.this.finish();
            }
        }, 1000);
    }
}
