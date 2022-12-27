package com;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.all.R;

public class RadioButton_Fragment extends Fragment {
    TextView aaa;
    RadioButton blue;
    RadioButton female;
    RelativeLayout fragment;
    RadioGroup gender;
    RadioButton male;
    RadioButton other;
    RadioGroup radio_color;
    RadioButton red;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_radiobutton, container, false);
        aaa = (TextView) view.findViewById(R.id.aaa);
        male = (RadioButton) view.findViewById(R.id.male);
        female = (RadioButton) view.findViewById(R.id.female);
        other = (RadioButton) view.findViewById(R.id.other);
        red = (RadioButton) view.findViewById(R.id.red);
        blue = (RadioButton) view.findViewById(R.id.blue);
        gender = (RadioGroup) view.findViewById(R.id.gender);
        radio_color = (RadioGroup) view.findViewById(R.id.radio_color);
        fragment = (RelativeLayout) view.findViewById(R.id.radio_button_fragment);

        gender.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.female) {
                        aaa.setText(female.getText().toString());
                } else if (checkedId == R.id.male) {
                    aaa.setText(male.getText().toString());
                } else if (checkedId == R.id.other) {
                    aaa.setText(other.getText().toString());
                }
            }
        });
        this.radio_color.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.blue) {
                    fragment.setBackgroundColor(Color.BLUE);
                } else if (checkedId == R.id.red) {
                    fragment.setBackgroundColor(Color.RED);
                }
            }
        });
        return view;
    }
}
