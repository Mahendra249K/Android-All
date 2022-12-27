package com;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.all.R;

public class DatePicker_Fragment extends Fragment {
    DatePicker datePicker;
    TextView textView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_date_picker, container, false);
        this.datePicker = (DatePicker) view.findViewById(R.id.date_pickerrrrrrrr);
        this.textView = (TextView) view.findViewById(R.id.date_picker_text);
        this.datePicker.setOnDateChangedListener(new OnDateChangedListener() {
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                TextView textView = DatePicker_Fragment.this.textView;
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(dayOfMonth);
                String str = " - ";
                sb.append(str);
                sb.append(monthOfYear);
                sb.append(str);
                sb.append(year);
                textView.setText(sb.toString());
            }
        });
        return view;
    }
}
