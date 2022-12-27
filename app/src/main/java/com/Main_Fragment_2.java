package com;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.all.R;

public class Main_Fragment_2 extends Fragment {
    private ImageView call;
    private ImageView facebook;
    private ImageView instagram;
    private ImageView map;
    private ImageView twitter;
    private ImageView whatsapp;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_2, container, false);
        whatsapp = (ImageView) view.findViewById(R.id.whatsapp);
        facebook = (ImageView) view.findViewById(R.id.facebook);
        instagram = (ImageView) view.findViewById(R.id.instagram);
        twitter = (ImageView) view.findViewById(R.id.twitter);
        call = (ImageView) view.findViewById(R.id.call);
        map = (ImageView) view.findViewById(R.id.map1);

        whatsapp.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("https://api.whatsapp.com/send?phone=+91 9909087670"));
                Main_Fragment_2.this.startActivity(intent);
            }
        });
        facebook.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("fb://profile/+ https://www.facebook.com/profile.php?id=100015800556691"));
                Main_Fragment_2.this.startActivity(intent);
            }
        });
        instagram.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse("https://instagram.com/_.mahendra_boxer?igshid=1ll10ts6gkvkz"));
                    Main_Fragment_2.this.startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(Main_Fragment_2.this.getContext(), "Please Insatall Instagram App...", Toast.LENGTH_SHORT).show();
                }
            }
        });
        call.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("tel:+91 9909087670"));
                Main_Fragment_2.this.startActivity(intent);
            }
        });
        map.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("geo:21.212697,72.839776"));
                Main_Fragment_2.this.startActivity(intent);
            }
        });
        twitter.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(Main_Fragment_2.this.getContext(), "Bhai Santi rakh Set Krvanu baki Che ...", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
