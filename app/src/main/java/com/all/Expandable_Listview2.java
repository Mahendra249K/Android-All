package com.all;

import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Expandable_Listview2 extends AppCompatActivity {
    Button downbtn;
    ConstraintLayout expadabale;
    CardView main_card;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_listview);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle( "Expadabale Listview 2");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        expadabale = (ConstraintLayout) findViewById(R.id.expandabale);
        main_card = (CardView) findViewById(R.id.main_card);
        downbtn = (Button) findViewById(R.id.down);

        downbtn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (expadabale.getVisibility() == View.GONE) {
                    TransitionManager.beginDelayedTransition(main_card, new AutoTransition());
                    expadabale.setVisibility(View.VISIBLE);
                    downbtn.setBackgroundResource(R.drawable.up);
                    return;
                }else {
                    TransitionManager.beginDelayedTransition(main_card, new AutoTransition());
                    expadabale.setVisibility(View.GONE);
                    downbtn.setBackgroundResource(R.drawable.down);
                }
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
