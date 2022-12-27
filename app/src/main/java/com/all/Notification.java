package com.all;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat.BigPictureStyle;
import androidx.core.app.NotificationCompat.BigTextStyle;
import androidx.core.app.NotificationCompat.Builder;
import androidx.core.app.NotificationCompat.InboxStyle;
import androidx.core.app.NotificationManagerCompat;

public class Notification extends AppCompatActivity {
    Button big_picture_notification;
    Button big_text_notificatioan;
    Button inbox_notificatioan;
    Button notificatioan_action;
    Button simple_notification;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle((CharSequence) "Notifications");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        simple_notification = (Button) findViewById(R.id.simple_notification);
        big_picture_notification = (Button) findViewById(R.id.big_picture_notification);
        big_text_notificatioan = (Button) findViewById(R.id.big_text_notificatioan);
        inbox_notificatioan = (Button) findViewById(R.id.inbox_notificatioan);
        notificatioan_action = (Button) findViewById(R.id.notificatioan_action);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("Notification", "Notification nameeee", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("descriptionnnnnnnn");
            ((NotificationManager) getSystemService(NotificationManager.class)).createNotificationChannel(channel);
        }
        this.simple_notification.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Builder builder = new Builder(Notification.this, "Notification");
                builder.setContentTitle("Simple Notification");
                builder.setContentText("Hello Simple Notification");
                builder.setSmallIcon(R.drawable.logo);
                builder.setLargeIcon(BitmapFactory.decodeResource(Notification.this.getResources(), R.drawable.iiiiii));
                builder.setPriority(2);
                builder.setDefaults(-1);
                builder.setAutoCancel(true);
                NotificationManagerCompat.from(Notification.this).notify(1, builder.build());
            }
        });
        this.big_picture_notification.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Bitmap picture = BitmapFactory.decodeResource(Notification.this.getResources(), R.drawable.iiiiii);
                Builder builder = new Builder(Notification.this, "Notification");
                builder.setContentTitle("Big Picture Notification");
                builder.setContentText("Hello big Picture Notification");
                builder.setSmallIcon(R.drawable.logo);
                builder.setPriority(2);
                builder.setDefaults(-1);
                builder.setAutoCancel(true);
                builder.setStyle(new BigPictureStyle().bigPicture(picture));
                NotificationManagerCompat.from(Notification.this).notify(2, builder.build());
            }
        });
        this.big_text_notificatioan.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Builder builder = new Builder(Notification.this, "Notification");
                builder.setContentTitle("Big Text Notification");
                builder.setSmallIcon(R.drawable.logo);
                builder.setPriority(2);
                builder.setAutoCancel(true);
                builder.setStyle(new BigTextStyle().bigText("public static class Notification.BigTextStyle Notificationjava.lang.Object.\n↳ android.app.Notification.Style"));
                NotificationManagerCompat.from(Notification.this).notify(2, builder.build());
            }
        });
        this.inbox_notificatioan.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Builder builder = new Builder(Notification.this, "Notification");
                builder.setContentTitle("Big Text Notification");
                builder.setContentText("Hellooo big Text Notification");
                builder.setSmallIcon(R.drawable.logo);
                builder.setPriority(2);
                builder.setAutoCancel(true);
                builder.setLargeIcon(BitmapFactory.decodeResource(Notification.this.getResources(), R.drawable.iiiiii));
                builder.setStyle(new InboxStyle().addLine("Hello").addLine("how are uukem cho").setBigContentTitle("2 new Messages"));
                NotificationManagerCompat.from(Notification.this).notify(2, builder.build());
            }
        });
        this.notificatioan_action.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Builder builder = new Builder(Notification.this, "Notification");
                builder.setContentTitle("Big Text Notification");
                builder.setContentText("Hellooo big Text Notification");
                builder.setSmallIcon(R.drawable.logo);
                builder.setPriority(2);
                builder.setAutoCancel(true);
                builder.setLargeIcon(BitmapFactory.decodeResource(Notification.this.getResources(), R.drawable.iiiiii));
                builder.setStyle(new BigTextStyle().bigText("public static class Notification.BigTextStyle Notificationjava.lang.Object.\n↳ android.app.Notification.Style"));
                PendingIntent pendingIntent = PendingIntent.getActivity(Notification.this, 0, new Intent("android.intent.action.VIEW", Uri.parse("http://www.google.com")), 0);
                builder.addAction(android.R.drawable.ic_menu_view, "Reply", pendingIntent);
                builder.addAction(android.R.drawable.ic_menu_view, "Mark as read", pendingIntent);
                NotificationManagerCompat.from(Notification.this).notify(2, builder.build());
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
