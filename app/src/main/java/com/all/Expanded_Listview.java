package com.all;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Expanded_Listview extends AppCompatActivity {
    ExpandabaleListview_Adpter1 expandabaleListviewAdpter1;
    ExpandableListView expandableListView;
    HashMap<String, List<String>> listChild;
    List<String> listHeader;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_expanded_listview);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle("Expandable Listview");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        this.expandableListView =findViewById(R.id.expandedlistview);
        expandableListViewData();
        ExpandabaleListview_Adpter1 expandabaleListview_Adpter1 = new ExpandabaleListview_Adpter1(Expanded_Listview.this, listHeader, listChild);
        expandableListView.setAdapter(expandabaleListview_Adpter1);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.manu_new_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        if (item.getItemId() == R.id.new_activity) {
            startActivity(new Intent(this, Expandable_Listview2.class));
        }
        return super.onOptionsItemSelected(item);
    }

    private void expandableListViewData() {
        this.listHeader = new ArrayList();
        this.listChild = new HashMap<>();
        this.listHeader.add("C");
        this.listHeader.add("C++");
        this.listHeader.add("Java");
        this.listHeader.add("Android");
        this.listHeader.add("kotlin");
        List<String> c = new ArrayList<>();
        c.add("c lanuage");
        c.add("c 222");
        c.add("c 333");
        c.add("c 444");
        c.add("c 555");
        c.add("c 6666");
        List<String> ccc = new ArrayList<>();
        ccc.add("ccc 111");
        ccc.add("ccc 222");
        ccc.add("ccc 333");
        ccc.add("ccc 444");
        ccc.add("ccc 555");
        ccc.add("ccc 6666");
        List<String> java = new ArrayList<>();
        java.add("java 111");
        java.add("java 222");
        java.add("java 333");
        java.add("java 444");
        java.add("java 555");
        java.add("java 6666");
        List<String> android2 = new ArrayList<>();
        android2.add("android 111");
        android2.add("android 222");
        android2.add("android 333");
        android2.add("android 444");
        List<String> kotlin = new ArrayList<>();
        listChild.put(this.listHeader.get(0), c);
        listChild.put(this.listHeader.get(1), ccc);
        listChild.put(this.listHeader.get(2), java);
        listChild.put(this.listHeader.get(3), android2);
        listChild.put(this.listHeader.get(4), kotlin);
    }
}
