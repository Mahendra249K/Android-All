package com;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;
import androidx.fragment.app.Fragment;
import com.all.R;

public class TimePicker_Fragment extends Fragment {
    TimePicker timePicker;
    TextView time_picker_text;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_time_picker, container, false);

        timePicker = (TimePicker) view.findViewById(R.id.time_pickerrrr);
        time_picker_text = (TextView) view.findViewById(R.id.time_picker_text);
        timePicker.setOnTimeChangedListener(new OnTimeChangedListener() {
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                TextView textView = TimePicker_Fragment.this.time_picker_text;
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(hourOfDay);
                sb.append(" : ");
                sb.append(minute);
                textView.setText(sb.toString());
            }
        });
        return view;
    }
}
