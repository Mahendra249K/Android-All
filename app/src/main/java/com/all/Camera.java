package com.all;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Camera extends AppCompatActivity {
    private static final int REQUEST_CODE = 1;
    Button choosImageGallaryorCamera;
    ImageView selectedImage;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle((CharSequence) "Camera & Gallary");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        selectedImage = (ImageView) findViewById(R.id.selectedImage);
        choosImageGallaryorCamera = (Button) findViewById(R.id.choosImageGallaryorCamera);
        selectedImage.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (VERSION.SDK_INT >= 23) {
                    String str = "android.permission.READ_EXTERNAL_STORAGE";
                    if (checkSelfPermission(str) == 0) {
                        requestPermissions(new String[]{str}, 1);
                        return;
                    }
                    selectImages();
                    return;
                }
                selectImages();
            }
        });
        choosImageGallaryorCamera.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(Camera.this, "Baki che.....", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    /* access modifiers changed from: private */
    public void selectImages() {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("image/*");
        startActivityForResult(intent, 0);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults.length <= 0 || grantResults[0] != 0) {
                Toast.makeText(this, "Permission Denited......", Toast.LENGTH_SHORT).show();
            } else {
                selectImages();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1 && requestCode == 0) {
            selectedImage.setImageURI(data.getData());
        }
    }
}
