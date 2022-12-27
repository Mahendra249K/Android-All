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

public class Toast_Fragment extends Fragment {
    Button center_toast;
    Button custom_toast;
    View custom_toast_layout_view;
    Button simple_toast;
    Button upper_toast;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_toast, container, false);
        simple_toast = (Button) view.findViewById(R.id.simple_toast);
        center_toast = (Button) view.findViewById(R.id.center_toast);
        upper_toast = (Button) view.findViewById(R.id.upper_toast);
        custom_toast = (Button) view.findViewById(R.id.custom_toast);
        custom_toast_layout_view = inflater.inflate(R.layout.custom_toast_layout,
                (ViewGroup) view.findViewById(R.id.custom_toast_layout));

        simple_toast.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(Toast_Fragment.this.getContext(), "This is Simple Toast....", Toast.LENGTH_SHORT).show();
            }
        });
        center_toast.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Toast toast = Toast.makeText(Toast_Fragment.this.getContext(), "This is Center Toast....", Toast.LENGTH_SHORT);
                toast.setGravity(17, 0, 0);
                toast.show();
            }
        });
        upper_toast.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Toast toast = Toast.makeText(Toast_Fragment.this.getContext(), "This is Top Toast....", Toast.LENGTH_SHORT);
                toast.setGravity(48, 0, 0);
                toast.show();
            }
        });
        custom_toast.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Toast toast = Toast.makeText(Toast_Fragment.this.getContext(), "This is Simple Toast....", Toast.LENGTH_SHORT);
                toast.setView(Toast_Fragment.this.custom_toast_layout_view);
                toast.show();
            }
        });
        return view;
    }
}
