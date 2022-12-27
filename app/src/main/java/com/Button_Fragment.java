package com;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

import com.all.R;

public class Button_Fragment extends Fragment {
    Button color_drawable_btn;
    Button image_background_btn;
    ImageButton image_btn_demo;
    Button simple_btn;
    Button simple_drawable_btn;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_button, container, false);
        this.simple_btn = (Button) view.findViewById(R.id.simple_btn);
        this.simple_drawable_btn = (Button) view.findViewById(R.id.simple_drawable_btn);
        this.color_drawable_btn = (Button) view.findViewById(R.id.color_drawable_btn);
        this.image_background_btn = (Button) view.findViewById(R.id.image_background_btn);
        this.image_btn_demo = (ImageButton) view.findViewById(R.id.image_btn_demo);
        this.simple_btn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(Button_Fragment.this.getContext(), "This is Simple Button....", Toast.LENGTH_SHORT).show();
            }
        });
        this.simple_drawable_btn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(Button_Fragment.this.getContext(), "This is Simple Drawable Button....", Toast.LENGTH_SHORT).show();
            }
        });
        this.color_drawable_btn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(Button_Fragment.this.getContext(), "This is Color Button....", Toast.LENGTH_SHORT).show();
            }
        });
        this.image_background_btn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(Button_Fragment.this.getContext(), "This is Simple Button but Background Image...", Toast.LENGTH_SHORT).show();
            }
        });
        this.image_btn_demo.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(Button_Fragment.this.getContext(), "This is Image Button Backgraound Transparant....", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}