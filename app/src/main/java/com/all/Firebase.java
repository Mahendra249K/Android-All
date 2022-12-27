package com.all;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Firebase extends AppCompatActivity {
    Button gotoLogin;
    Button gotoRegister;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle((CharSequence) "Firebase");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        gotoLogin = (Button) findViewById(R.id.gotoLogin);
        gotoRegister = (Button) findViewById(R.id.gotoRegister);

        gotoLogin.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Firebase.this, Login_Activity.class));
                finish();
            }
        });
        gotoRegister.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Firebase.this, Register_Activity.class));
                finish();
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
