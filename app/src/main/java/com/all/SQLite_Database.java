package com.all;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SQLite_Database extends AppCompatActivity {
    EditText class_name;
    EditText collage_name;
    Button insert_data;
    Button other;
    Button show_data;
    EditText student_name;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_database);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle((CharSequence) "SQLite Database");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        collage_name = (EditText) findViewById(R.id.collage_name);
        student_name = (EditText) findViewById(R.id.student_name);
        class_name = (EditText) findViewById(R.id.class_name);
        insert_data = (Button) findViewById(R.id.insert_data);
        show_data = (Button) findViewById(R.id.show_data);
        other = (Button) findViewById(R.id.other);

        final SQLite_Adpter sqLiteAdpter = new SQLite_Adpter(this);
        insert_data.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                sqLiteAdpter.insertData(collage_name.getText().toString(), student_name.getText().toString(), class_name.getText().toString());
                collage_name.setText(null);
                student_name.setText(null);
                class_name.setText(null);
            }
        });
        show_data.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                sqLiteAdpter.showData();
            }
        });
        other.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(SQLite_Database.this, SQLite_Database2.class));
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
