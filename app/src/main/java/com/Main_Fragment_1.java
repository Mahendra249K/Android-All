package com;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.all.Async_Internet;
import com.all.Async_Task;
import com.all.Basic;
import com.all.BoadcastReciver;
import com.all.BottomSheet;
import com.all.Camera;
import com.all.EditText_Layout;
import com.all.Expanded_Listview;
import com.all.Firebase;
import com.all.Firebase2;
import com.all.ImageSlider_Viewpager;
import com.all.Layouts;
import com.all.Menu;
import com.all.Navigation_Drawer;
import com.all.Notification;
import com.all.R;
import com.all.SQLite_Database;
import com.all.Services;
import com.all.Shared_Preference;
import com.all.Views;

public class Main_Fragment_1 extends Fragment {

    LinearLayout async;
    LinearLayout async_internet;
    LinearLayout basic;
    LinearLayout bottom_sheet;
    LinearLayout broadcast;
    LinearLayout camera_gallary;
    LinearLayout edittext_layout;
    LinearLayout expanded_listview;
    LinearLayout firebase;
    LinearLayout firebase2;
    LinearLayout layouts;
    LinearLayout menu;
    LinearLayout navigation_drawer;
    LinearLayout notification;
    LinearLayout services;
    LinearLayout share_preference;
    LinearLayout sqlite_databse;
    LinearLayout ui_image_changer;
    LinearLayout views;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main_1, container, false);

        basic = (LinearLayout) view.findViewById(R.id.basic);
        layouts = (LinearLayout) view.findViewById(R.id.layouts);
        views = (LinearLayout) view.findViewById(R.id.views);
        ui_image_changer = (LinearLayout) view.findViewById(R.id.ui_image_changer);
        notification = (LinearLayout) view.findViewById(R.id.notification);
        async = (LinearLayout) view.findViewById(R.id.async);
        async_internet = (LinearLayout) view.findViewById(R.id.async_internet);
        broadcast = (LinearLayout) view.findViewById(R.id.broadcast);
        services = (LinearLayout) view.findViewById(R.id.services);
        share_preference = (LinearLayout) view.findViewById(R.id.share_preference);
        menu = (LinearLayout) view.findViewById(R.id.menu);
        sqlite_databse = (LinearLayout) view.findViewById(R.id.sqlite_databse);
        bottom_sheet = (LinearLayout) view.findViewById(R.id.bottom_sheet);
        expanded_listview = (LinearLayout) view.findViewById(R.id.expanded_listview);
        edittext_layout = (LinearLayout) view.findViewById(R.id.edittext_layout);
        navigation_drawer = (LinearLayout) view.findViewById(R.id.navigation_drawer);
        camera_gallary = (LinearLayout) view.findViewById(R.id.camera_gallary);
        firebase = (LinearLayout) view.findViewById(R.id.firebase);
        firebase2 = (LinearLayout) view.findViewById(R.id.firebaseRealtime);

        basic.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
               startActivity(new Intent(Main_Fragment_1.this.getContext(), Basic.class));
            }
        });
        this.layouts.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
               startActivity(new Intent(Main_Fragment_1.this.getContext(), Layouts.class));
            }
        });
        this.views.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
               startActivity(new Intent(Main_Fragment_1.this.getContext(), Views.class));
            }
        });
        this.ui_image_changer.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
               startActivity(new Intent(Main_Fragment_1.this.getContext(), ImageSlider_Viewpager.class));
            }
        });
        this.notification.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
               startActivity(new Intent(Main_Fragment_1.this.getContext(), Notification.class));
            }
        });
        this.async.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
               startActivity(new Intent(Main_Fragment_1.this.getContext(), Async_Task.class));
            }
        });
        this.async_internet.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
               startActivity(new Intent(Main_Fragment_1.this.getContext(), Async_Internet.class));
            }
        });
        this.broadcast.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
               startActivity(new Intent(Main_Fragment_1.this.getContext(), BoadcastReciver.class));
            }
        });
        this.services.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
               startActivity(new Intent(Main_Fragment_1.this.getContext(), Services.class));
            }
        });
        this.share_preference.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
               startActivity(new Intent(Main_Fragment_1.this.getContext(), Shared_Preference.class));
            }
        });
        this.sqlite_databse.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
               startActivity(new Intent(Main_Fragment_1.this.getContext(), SQLite_Database.class));
            }
        });
        this.menu.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
               startActivity(new Intent(Main_Fragment_1.this.getContext(), Menu.class));
            }
        });
        this.bottom_sheet.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
               startActivity(new Intent(Main_Fragment_1.this.getContext(), BottomSheet.class));
            }
        });
        this.expanded_listview.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
               startActivity(new Intent(Main_Fragment_1.this.getContext(), Expanded_Listview.class));
            }
        });
        this.edittext_layout.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
               startActivity(new Intent(Main_Fragment_1.this.getContext(), EditText_Layout.class));
            }
        });
        this.navigation_drawer.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
               startActivity(new Intent(Main_Fragment_1.this.getContext(), Navigation_Drawer.class));
            }
        });
        this.camera_gallary.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Main_Fragment_1.this.getContext(), Camera.class));
            }
        });
        this.firebase.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Main_Fragment_1.this.getContext(), Firebase.class));
            }
        });
        this.firebase2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Main_Fragment_1.this.getContext(), Firebase2.class));
            }
        });
        return view;
    }
}
