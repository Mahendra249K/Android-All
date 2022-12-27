package com;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

import com.all.R;

public class CheckBox_Fragment extends Fragment {
    CheckBox ck1;
    CheckBox ck2;
    CheckBox ck3;
    TextView ckkkkk;
    Button click_here;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_checkbox, container, false);
        this.ckkkkk = (TextView) view.findViewById(R.id.ckkkk);
        this.ck1 = (CheckBox) view.findViewById(R.id.ck1);
        this.ck2 = (CheckBox) view.findViewById(R.id.ck2);
        this.ck3 = (CheckBox) view.findViewById(R.id.ck3);
        Button button = (Button) view.findViewById(R.id.click_here);
        this.click_here = button;
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (CheckBox_Fragment.this.ck1.isChecked() && !CheckBox_Fragment.this.ck2.isChecked() && !CheckBox_Fragment.this.ck3.isChecked()) {
                    CheckBox_Fragment.this.ckkkkk.setText("Male");
                } else if (!CheckBox_Fragment.this.ck1.isChecked() && CheckBox_Fragment.this.ck2.isChecked() && !CheckBox_Fragment.this.ck3.isChecked()) {
                    CheckBox_Fragment.this.ckkkkk.setText("Female");
                } else if (!CheckBox_Fragment.this.ck1.isChecked() && !CheckBox_Fragment.this.ck2.isChecked() && CheckBox_Fragment.this.ck3.isChecked()) {
                    CheckBox_Fragment.this.ckkkkk.setText("Other");
                } else if (CheckBox_Fragment.this.ck1.isChecked() && CheckBox_Fragment.this.ck2.isChecked() && !CheckBox_Fragment.this.ck3.isChecked()) {
                    CheckBox_Fragment.this.ckkkkk.setText("Male, Female");
                } else if (!CheckBox_Fragment.this.ck1.isChecked() && CheckBox_Fragment.this.ck2.isChecked() && CheckBox_Fragment.this.ck3.isChecked()) {
                    CheckBox_Fragment.this.ckkkkk.setText("Female, Other");
                } else if (CheckBox_Fragment.this.ck1.isChecked() && !CheckBox_Fragment.this.ck2.isChecked() && CheckBox_Fragment.this.ck3.isChecked()) {
                    CheckBox_Fragment.this.ckkkkk.setText("Male, Other");
                } else if (CheckBox_Fragment.this.ck1.isChecked() && CheckBox_Fragment.this.ck2.isChecked() && CheckBox_Fragment.this.ck3.isChecked()) {
                    CheckBox_Fragment.this.ckkkkk.setText("Male, Female, Other");
                } else if (!ck1.isChecked() && !ck2.isChecked() && !ck3.isChecked()) {
                    CheckBox_Fragment.this.ckkkkk.setText("Please Select any CheckBox");
                }
            }
        });
        return view;
    }
}
