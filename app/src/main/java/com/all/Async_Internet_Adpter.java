package com.all;

import android.content.Context;
import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Async_Internet_Adpter extends AsyncTask<String, Void, String> {
    Context context;

    public Async_Internet_Adpter(Context context2) {
        this.context = context2;
    }

    public String doInBackground(String... strings) {
        try {

            HttpURLConnection connection = (HttpURLConnection) new URL(strings[0]).openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                String line = readLine;
                if (readLine != null) {
                    stringBuilder.append(line);
                } else {
                    bufferedReader.close();
                    inputStream.close();
                    return stringBuilder.toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(String s) {
        Async_Internet.html_Data_Text.setText(s);
    }
}
