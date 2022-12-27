package com.all;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener;

public class Navigation_Drawer extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    NavigationView navigationView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle((CharSequence) "Navigation Drawer");
        navigationView = (NavigationView) findViewById(R.id.navigationView);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, this.drawerLayout,R.string.open,R.string.close);
        drawerToggle = actionBarDrawerToggle;
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(new OnNavigationItemSelectedListener() {
            public boolean onNavigationItemSelected(MenuItem item) {
                if (item.getItemId() == R.id.home) {
                    Toast.makeText(Navigation_Drawer.this, "Home Clicked", Toast.LENGTH_SHORT).show();
                    Navigation_Drawer.this.drawerLayout.closeDrawers();
                }
                if (item.getItemId() == R.id.group) {
                    Toast.makeText(Navigation_Drawer.this, "Group Clicked", Toast.LENGTH_SHORT).show();
                    Navigation_Drawer.this.drawerLayout.closeDrawers();
                }
                if (item.getItemId() == R.id.share) {
                    Toast.makeText(Navigation_Drawer.this, "Share Clicked", Toast.LENGTH_SHORT).show();
                    Navigation_Drawer.this.drawerLayout.closeDrawers();
                }
                if (item.getItemId() == R.id.gallary) {
                    Toast.makeText(Navigation_Drawer.this, "Gallary Clicked", Toast.LENGTH_SHORT).show();
                    Navigation_Drawer.this.drawerLayout.closeDrawers();
                }
                if (item.getItemId() == R.id.yoga) {
                    Toast.makeText(Navigation_Drawer.this, "Yoga Clicked", Toast.LENGTH_SHORT).show();
                    Navigation_Drawer.this.drawerLayout.closeDrawers();
                }
                if (item.getItemId() == R.id.gym) {
                    Toast.makeText(Navigation_Drawer.this, "Gym Clicked", Toast.LENGTH_SHORT).show();
                    Navigation_Drawer.this.drawerLayout.closeDrawers();
                }
                if (item.getItemId() == R.id.setting) {
                    Toast.makeText(Navigation_Drawer.this, "Setting Clicked", Toast.LENGTH_SHORT).show();
                    Navigation_Drawer.this.drawerLayout.closeDrawers();
                }
                if (item.getItemId() == R.id.logout) {
                    Toast.makeText(Navigation_Drawer.this, "Logout Clicked", Toast.LENGTH_SHORT).show();
                    Navigation_Drawer.this.drawerLayout.closeDrawers();
                }
                return true;
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (this.drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
