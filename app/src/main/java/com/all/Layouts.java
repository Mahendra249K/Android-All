package com.all;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.FrameLayout_Fragment;
import com.GridLayout_Fragment;
import com.LinearLayout_Fragment;
import com.TableLayout_Fragment;

public class Layouts extends AppCompatActivity {
    Fragment fragment;
    /* access modifiers changed from: private */
    public LinearLayout frameLayout;
    /* access modifiers changed from: private */
    public LinearLayout gridLayout;
    /* access modifiers changed from: private */
    public LinearLayout linearLayout;
    /* access modifiers changed from: private */
    public LinearLayout tableLayout;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layouts);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle("Linear Layout");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        linearLayout = (LinearLayout) findViewById(R.id.linear_layout);
        gridLayout = (LinearLayout) findViewById(R.id.grid_layout);
        tableLayout = (LinearLayout) findViewById(R.id.table_layout);
        frameLayout = (LinearLayout) findViewById(R.id.frame_layout);
        linearLayout.setEnabled(false);
        linearLayout.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                linearLayout.setEnabled(false);
                gridLayout.setEnabled(true);
                tableLayout.setEnabled(true);
                frameLayout.setEnabled(true);

                fragment = new LinearLayout_Fragment();
                loadfragment(fragment);
                getSupportActionBar().setTitle((CharSequence) "Linear Layout");
            }
        });
        gridLayout.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                linearLayout.setEnabled(true);
                gridLayout.setEnabled(false);
                tableLayout.setEnabled(true);
                frameLayout.setEnabled(true);

                fragment = new GridLayout_Fragment();
                loadfragment(fragment);
                getSupportActionBar().setTitle((CharSequence) "Grid Layout");
            }
        });
        tableLayout.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                linearLayout.setEnabled(true);
                gridLayout.setEnabled(true);
                tableLayout.setEnabled(false);
                frameLayout.setEnabled(true);

                getSupportActionBar().setTitle((CharSequence) "Table Layout");
                fragment = new TableLayout_Fragment();
                loadfragment(fragment);
            }
        });
        frameLayout.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                linearLayout.setEnabled(true);
                gridLayout.setEnabled(true);
                tableLayout.setEnabled(true);
                frameLayout.setEnabled(false);

                getSupportActionBar().setTitle((CharSequence) "Frame Layout");
                fragment = new FrameLayout_Fragment();
                loadfragment(fragment);
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void loadfragment(Fragment fragment2) {
        if (fragment2 != null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.layout_fragment, fragment2);
            fragmentTransaction.commit();
        }
    }
}
