package com;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import androidx.fragment.app.Fragment;
import com.all.R;

public class Swich_Fragment extends Fragment {
    Switch aSwitch;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_swich, container, false);
        Switch switchR = (Switch) view.findViewById(R.id.swich);
        this.aSwitch = switchR;
        switchR.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Swich_Fragment.this.aSwitch.isChecked()) {
                    Swich_Fragment.this.aSwitch.setText("Swich Onnnnnnnn");
                } else {
                    Swich_Fragment.this.aSwitch.setText("Swich Offffffff");
                }
            }
        });
        return view;
    }
}
