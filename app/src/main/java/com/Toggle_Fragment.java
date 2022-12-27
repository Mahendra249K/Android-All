package com;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.fragment.app.Fragment;
import com.all.R;

public class Toggle_Fragment extends Fragment {
    ToggleButton toggleButton;
    TextView ttttttt;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_toggle, container, false);
        ttttttt = (TextView) view.findViewById(R.id.tttttttt);

        ToggleButton toggleButton2 = (ToggleButton) view.findViewById(R.id.toggleButton_demo);
        toggleButton = toggleButton2;

        toggleButton2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (Toggle_Fragment.this.toggleButton.isChecked()) {
                    Toggle_Fragment.this.ttttttt.setText("ON");
                } else {
                    Toggle_Fragment.this.ttttttt.setText("OFF");
                }
            }
        });
        return view;
    }
}
