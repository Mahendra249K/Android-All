package com;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

import com.all.R;

public class FrameLayout_Fragment extends Fragment {
    Button b11111;
    Button b22222;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_framelayout, container, false);
        this.b11111 = (Button) view.findViewById(R.id.b11111);
        this.b22222 = (Button) view.findViewById(R.id.b22222);
        this.b11111.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(FrameLayout_Fragment.this.getContext(), "You Press 111111", Toast.LENGTH_SHORT).show();
            }
        });
        this.b22222.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(FrameLayout_Fragment.this.getContext(), "You Press 222222", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
