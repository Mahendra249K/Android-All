package com.all;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddItem_Activity extends AppCompatActivity {
    public static final int CAPTURE_IMAGE_REQUESST = 1;
    ImageView add_image;
    Button add_item_btn;
    EditText add_name;
    String currentPhotoPath = null;
    File image;
    File photoFile = null;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item_);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle("Add Item");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        add_image = (ImageView) findViewById(R.id.add_image);
        add_name = (EditText) findViewById(R.id.add_name);
        add_item_btn = (Button) findViewById(R.id.add_item_btn);

        add_image.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                AddItem_Activity.this.captureImage();
            }
        });

        add_item_btn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String path =photoFile.getAbsolutePath();
                String picname =add_name.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("path", path);
                intent.putExtra("photoname", picname);
                setResult(CAPTURE_IMAGE_REQUESST, intent);
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

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == CAPTURE_IMAGE_REQUESST) {
            add_image.setImageBitmap(BitmapFactory.decodeFile(this.photoFile.getAbsolutePath()));
            return;
        }
        displayMessage(getBaseContext(), "Request cancelled or something went wrong.");
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 0) {
            if (grantResults.length > 0) {
                int i = grantResults[0];
                getPackageManager();
                if (i == 0) {
                    int i2 = grantResults[1];
                    getPackageManager();
                    if (i2 == 0) {
                        captureImage();
                        return;
                    }
                }
            }
            Toast.makeText(this, "Plaese Grant the Permition for Cemara.", Toast.LENGTH_SHORT).show();
        }
    }

    /* access modifiers changed from: private */
    public void captureImage() {
        String str = "android.permission.CAMERA";
        int checkSelfPermission = ContextCompat.checkSelfPermission(this, str);
        getPackageManager();
        if (checkSelfPermission != 0) {
            ActivityCompat.requestPermissions(this, new String[]{str, "android.permission.WRITE_EXTERNAL_STORAGE"}, 0);
            return;
        }
        Intent takePictureIntent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            try {
                this.photoFile = createImageFile();
                displayMessage(getBaseContext(), this.photoFile.getAbsolutePath());
                Log.i("Mayank", this.photoFile.getAbsolutePath());
                if (this.photoFile != null) {
                    takePictureIntent.putExtra("output", FileProvider.getUriForFile(this, "com.all.provider", this.photoFile));
                    startActivityForResult(takePictureIntent, 1);
                }
            } catch (Exception ex) {
                displayMessage(getBaseContext(), ex.getMessage().toString());
            }
        } else {
            displayMessage(getBaseContext(), "Null");
        }
    }

    private void displayMessage(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    private File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        StringBuilder sb = new StringBuilder();
        sb.append("JPEG_");
        sb.append(timeStamp);
        sb.append("_");
        File createTempFile = File.createTempFile(sb.toString(), ".jpg", getExternalFilesDir(Environment.DIRECTORY_PICTURES));
        this.image = createTempFile;
        this.currentPhotoPath = createTempFile.getAbsolutePath();
        return this.image;
    }
}
