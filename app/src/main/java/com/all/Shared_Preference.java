package com.all;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Shared_Preference extends AppCompatActivity {
    EditText age,name;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_shared_preference);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle((CharSequence) "Shared Preference");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        name = findViewById(R.id.name);
        age = (EditText) findViewById(R.id.age);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("Pre", Context.MODE_PRIVATE);
        String nm = sharedPreferences.getString("name", "");
        int ag = sharedPreferences.getInt("age", 0);
        name.setText(nm);
        age.setText(String.valueOf(ag));
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        Editor editor = getSharedPreferences("Pre", MODE_PRIVATE).edit();
        editor.putString("name", this.name.getText().toString());
        editor.putInt("age", Integer.parseInt(this.age.getText().toString()));
        editor.commit();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
