package com.all;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.AsyncTask;
import android.widget.Toast;

public class Async_Task_Adpter extends AsyncTask<Void, Integer, String> {
    Context context;
    ProgressDialog progressDialog;

    public Async_Task_Adpter(Context context2) {
        this.context = context2;
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        super.onPreExecute();
        ProgressDialog progressDialog2 = new ProgressDialog(this.context);
        progressDialog = progressDialog2;
        progressDialog2.setTitle("Downloading");
        progressDialog.setMessage("please wait....");
        progressDialog.setMax(100);
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(1);
        progressDialog.setIcon(R.drawable.downloading);

        progressDialog.setButton( "Cancel", new OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Async_Task_Adpter.this.progressDialog.cancel();
                Toast.makeText(Async_Task_Adpter.this.context, "Downloading Canceled", Toast.LENGTH_SHORT).show();
                Async_Task_Adpter.this.cancel(true);
            }
        });
        this.progressDialog.show();
    }

    /* access modifiers changed from: protected */
    public String doInBackground(Void... voids) {
        int i = 1;
        while (i <= 100) {
            try {
                Thread.sleep(50);
                publishProgress(new Integer[]{Integer.valueOf(i)});
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        this.progressDialog.setProgress(values[0].intValue());
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(String s) {
        super.onPostExecute(s);
        Toast.makeText(this.context, "Downloading Complate", Toast.LENGTH_SHORT).show();
        this.progressDialog.dismiss();
    }

    /* access modifiers changed from: protected */
    public void onCancelled(String s) {
        super.onCancelled(s);
    }

    /* access modifiers changed from: protected */
    public void onCancelled() {
        super.onCancelled();
    }
}
