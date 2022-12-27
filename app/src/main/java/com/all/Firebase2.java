package com.all;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

public class Firebase2 extends AppCompatActivity {
    EditText inputName;
    ListView listviewRealtimeDemo;
    Button uploadDataBtn;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase2);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle((CharSequence) "Firebase 2");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        uploadDataBtn = (Button) findViewById(R.id.uploadDataBtn);
        inputName = (EditText) findViewById(R.id.inputName);
        listviewRealtimeDemo = (ListView) findViewById(R.id.listviewRealtimeDemo);
        uploadDataBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (inputName.getText().toString().isEmpty()) {
                    inputName.setError("Required");
                    return;
                }
                FirebaseDatabase.getInstance().getReference().child("All").child("Name").push().setValue(inputName.getText().toString());
            }
        });

        final ArrayList<String> arrayList = new ArrayList<>();
        final ArrayAdapter adapter = new ArrayAdapter(this, R.layout.realtime_listview_demo, arrayList);
        listviewRealtimeDemo.setAdapter(adapter);

        FirebaseDatabase.getInstance().getReference().child("All").child("Name").addValueEventListener(new ValueEventListener() {
            public void onDataChange(DataSnapshot snapshot) {
                arrayList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    arrayList.add(dataSnapshot.getValue().toString());
                }
                adapter.notifyDataSetChanged();
            }

            public void onCancelled(DatabaseError error) {
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
