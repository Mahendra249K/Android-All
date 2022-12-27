package com.all;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Async_Task_Image_Adpter extends AsyncTask<String, String, Bitmap> {
    URL ImageUrl = null;
    Bitmap bitmap;
    Bitmap bmImg = null;
    Context context;
    InputStream inputStream = null;
    ProgressDialog progressDialog;

    public Async_Task_Image_Adpter(Context context2) {
        this.context = context2;
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        super.onPreExecute();

        progressDialog= new ProgressDialog(this.context);

        progressDialog.setMessage("Downloading Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    /* access modifiers changed from: protected */
    public Bitmap doInBackground(String... strings) {
        try {
            URL url = new URL(strings[0]);
            this.ImageUrl = url;
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream inputStream2 = connection.getInputStream();
            this.inputStream = inputStream2;
            this.bitmap = BitmapFactory.decodeStream(inputStream2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.bitmap;
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Bitmap bitmap2) {
        super.onPostExecute(bitmap2);
        if (Async_Task.download_image != null) {
            progressDialog.hide();
            Async_Task.download_image.setImageBitmap(bitmap2);
            return;
        }
        this.progressDialog.show();
    }
}
