package com.all;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.firebase.auth.FirebaseAuth;

public class Home_Activity extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle( "Home");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.logout_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.logout) {
            Builder builder = new Builder(this);
            builder.setIcon(R.drawable.logout);
            builder.setTitle((CharSequence) "Are want to Sure Logout ?");
            builder.setNegativeButton( "No",  null);
            builder.setPositiveButton( "yes", new OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    logout();
                }
            });
            builder.show();
        }
        return super.onOptionsItemSelected(item);
    }

    /* access modifiers changed from: private */
    public void logout() {
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(this, "Logout...", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, Firebase.class));
        finish();
    }
}
