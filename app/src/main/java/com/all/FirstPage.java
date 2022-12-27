package com.all;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.Main_Fragment_1;
import com.Main_Fragment_2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener;
import com.google.android.material.tabs.TabLayout.Tab;

public class FirstPage extends AppCompatActivity {

    private TabLayout tabLayout;
    private Toolbar toolbar;
    public ViewPager viewPager;

    class mainPageData extends FragmentPagerAdapter {
        String[] pageName = {"Main 1", "Main 2"};

        public mainPageData(FragmentManager fm) {
            super(fm);
        }

        public Fragment getItem(int position) {
            if (position == 0) {
                return new Main_Fragment_1();
            }
            if (position == 1) {
                return new Main_Fragment_2();
            }
            return null;
        }

        public int getCount() {
            return this.pageName.length;
        }

        public CharSequence getPageTitle(int position) {
            return this.pageName[position];
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        setSupportActionBar(this.toolbar);
        getSupportActionBar().setTitle((CharSequence) "ALL IN ONE");

        viewPager.setAdapter(new mainPageData(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(this.viewPager);

        tabLayout.addOnTabSelectedListener((OnTabSelectedListener) new OnTabSelectedListener() {
            public void onTabSelected(Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            public void onTabUnselected(Tab tab) {
            }

            public void onTabReselected(Tab tab) {
            }
        });
    }

    public void onPointerCaptureChanged(boolean hasCapture) {
        try {
            Main_Fragment_1 main_Fragment_1 = (Main_Fragment_1) getSupportFragmentManager().findFragmentById(R.id.main_fragment_1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
    }
}
