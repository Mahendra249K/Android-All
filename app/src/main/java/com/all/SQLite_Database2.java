package com.all;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog.Builder;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SQLite_Database2 extends AppCompatActivity {
    EditText collage_name;
    Button delete;

    /* renamed from: id */
    EditText id;
    Button insert;
    EditText mark;
    EditText name;
    Button update;
    Button view;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_database2);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle((CharSequence) "SQLite Database 2");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        name = (EditText) findViewById(R.id.name);
        collage_name = (EditText) findViewById(R.id.collage_name);
        mark = (EditText) findViewById(R.id.mark);
        id = (EditText) findViewById(R.id.id);
        insert = (Button) findViewById(R.id.insert);
        view = (Button) findViewById(R.id.view);
        update = (Button) findViewById(R.id.update);
        delete = (Button) findViewById(R.id.delete);

        insert.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                SQLite_Adpter2 sqLiteAdpter2 = new SQLite_Adpter2(SQLite_Database2.this);
                String str = "Required";
                if (name.getText().toString().isEmpty()) {
                    name.setError(str);
                } else if (collage_name.getText().toString().isEmpty()) {
                    collage_name.setError(str);
                } else if (mark.getText().toString().isEmpty()) {
                    mark.setError(str);
                } else if (mark.getText().toString() != null && collage_name.getText().toString() != null && name.getText().toString() != null) {
                    if (!id.getText().toString().isEmpty()) {
                        Toast.makeText(SQLite_Database2.this, "For Insertaion id not Required...", Toast.LENGTH_LONG).show();
                        return;
                    }
                    if (sqLiteAdpter2.insertData(name.getText().toString(), collage_name.getText().toString(), mark.getText().toString())) {
                        Toast.makeText(SQLite_Database2.this, "Data Inserted....", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(SQLite_Database2.this, "Data Not Inserted....", Toast.LENGTH_LONG).show();
                    }
                    name.setText(null);
                    collage_name.setText(null);
                    mark.setText(null);
                }
            }
        });
        view.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Cursor cursor = new SQLite_Adpter2(SQLite_Database2.this).readData();
                if (cursor.getCount() == 0) {
                    showData("Error", "No data found...");
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer();
                while (cursor.moveToNext()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ID: ");
                    sb.append(cursor.getString(0));
                    String str = "\n";
                    sb.append(str);
                    stringBuffer.append(sb.toString());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Collage Name: ");
                    sb2.append(cursor.getString(1));
                    sb2.append(str);
                    stringBuffer.append(sb2.toString());
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Student Name: ");
                    sb3.append(cursor.getString(2));
                    sb3.append(str);
                    stringBuffer.append(sb3.toString());
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Class Name: ");
                    sb4.append(cursor.getString(3));
                    sb4.append("\n\n");
                    stringBuffer.append(sb4.toString());
                }
                showData("Data", stringBuffer.toString());
            }
        });
        update.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String str = "Required";
                if (id.getText().toString().isEmpty()) {
                    id.setError(str);
                } else if (name.getText().toString().isEmpty()) {
                    name.setError(str);
                } else if (collage_name.getText().toString().isEmpty()) {
                    collage_name.setError(str);
                } else if (mark.getText().toString().isEmpty()) {
                    mark.setError(str);
                } else if (id.getText().toString() != null && name.getText().toString() != null && collage_name.getText().toString() != null && mark.getText().toString() != null) {
                    if (new SQLite_Adpter2(SQLite_Database2.this).updateData(id.getText().toString(), name.getText().toString(), collage_name.getText().toString(), mark.getText().toString())) {
                        Toast.makeText(SQLite_Database2.this, "Updated Succsessfully", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(SQLite_Database2.this, "Data Not Updated", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        delete.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (id.getText().toString().isEmpty()) {
                    id.setError("Required");
                } else if (new SQLite_Adpter2(SQLite_Database2.this).deleteData(id.getText().toString()).intValue() > 0) {
                    Toast.makeText(SQLite_Database2.this, "Deleted Suucesfully...", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(SQLite_Database2.this, "No Data Found...", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void showData(String tittle, String message) {
        Builder builder = new Builder(this);
        builder.setMessage(message);
        builder.setIcon(R.drawable.database);
        builder.setTitle(tittle);
        builder.setCancelable(false);
        builder.setNegativeButton("Cancel", null);
        builder.show();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
