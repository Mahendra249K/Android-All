package com.all;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Async_Internet extends AppCompatActivity {
    static TextView html_Data_Text;
    static ImageView url_image;
    ConnectivityManager connectivityManager;
    Button get_html_code_btn;
    Button image_url_btn;
    NetworkInfo networkInfo;
    EditText url_string;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_internet);

        html_Data_Text = (TextView) findViewById(R.id.html_Data_Text);
        get_html_code_btn = (Button) findViewById(R.id.get_html_code_btn);
        url_string = (EditText) findViewById(R.id.url_string);
        url_image = (ImageView) findViewById(R.id.url_image);
        image_url_btn = (Button) findViewById(R.id.image_url_btn);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle("Async Internet");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ConnectivityManager connectivityManager2 = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        connectivityManager = connectivityManager2;
        networkInfo = connectivityManager2.getActiveNetworkInfo();

        get_html_code_btn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (url_string.getText().toString().isEmpty()) {
                    String str = "Please enter URL";
                    url_string.setError(str);
                    Toast.makeText(Async_Internet.this, str, Toast.LENGTH_SHORT).show();
                    return;
                }

                String string = url_string.getText().toString();
                new Async_Internet_Adpter(Async_Internet.this).execute(new String[]{string});
            }
        });
        image_url_btn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String string = url_string.getText().toString();
                if (url_string.getText().toString().isEmpty()) {
                    url_string.setError("Please enter URL");
                }
                if (networkInfo == null || !networkInfo.isConnected()) {
                    Toast toast = Toast.makeText(Async_Internet.this, "Please Connect to Internet", Toast.LENGTH_SHORT);
                    toast.setGravity(17, 0, 0);
                    toast.show();
                    return;
                }
                new Async_Internet_Image_Adpter(Async_Internet.this).execute(new String[]{string});
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
