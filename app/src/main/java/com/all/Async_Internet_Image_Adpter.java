package com.all;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import java.net.HttpURLConnection;
import java.net.URL;

public class Async_Internet_Image_Adpter extends AsyncTask<String, Void, Bitmap> {
    Context context;

    public Async_Internet_Image_Adpter(Context context2) {
        this.context = context2;
    }

    /* access modifiers changed from: protected */
    public Bitmap doInBackground(String... strings) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(strings[0]).openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            return BitmapFactory.decodeStream(connection.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Bitmap bitmap) {
        Async_Internet.url_image.setImageBitmap(bitmap);
    }
}
