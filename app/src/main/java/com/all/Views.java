package com.all;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.GridView_Fragment;
import com.ListView_Fragment;
import com.RecycleView_Fragment;
import com.WebView_Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener;

public class Views extends AppCompatActivity {
    Fragment fragment;
    BottomNavigationView navigation;
    Toolbar toolbar;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_views);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        setSupportActionBar(this.toolbar);
        getSupportActionBar().setTitle( "List View");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigation.setOnNavigationItemSelectedListener(new OnNavigationItemSelectedListener() {
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.grid_view /*2131296480*/:
                        getSupportActionBar().setTitle( "Grid View");
                        fragment = new GridView_Fragment();
                        loadfragment(fragment);
                        return true;
                    case R.id.list_view /*2131296570*/:
                        getSupportActionBar().setTitle( "List View");
                        fragment = new ListView_Fragment();
                        loadfragment(fragment);
                        return true;
                    case R.id.recycle_view /*2131296684*/:
                        getSupportActionBar().setTitle( "Recycle View");
                        fragment = new RecycleView_Fragment();
                        loadfragment(fragment);
                        return true;
                    case R.id.web_view /*2131296871*/:
                        getSupportActionBar().setTitle( "Web View");
                        fragment = new WebView_Fragment();
                        loadfragment(fragment);
                        return true;
                    default:
                        return false;
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

    public void loadfragment(Fragment fragment2) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.view_fragment, fragment2);
        fragmentTransaction.commit();
    }
}
