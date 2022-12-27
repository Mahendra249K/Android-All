package com;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.all.R;

public class Ratingbar_Fragment extends Fragment {
    RatingBar ratingBar;
    TextView textView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ratingbar, container, false);
        ratingBar = (RatingBar) view.findViewById(R.id.ratingBarrrrrrr);
        textView = (TextView) view.findViewById(R.id.rating_bar_text);

        ratingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                TextView textView = Ratingbar_Fragment.this.textView;
                StringBuilder sb = new StringBuilder();
                sb.append("Your Rate : ");
                sb.append(rating);
                textView.setText(sb.toString());
            }
        });
        return view;
    }
}
