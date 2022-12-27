package com.all;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import java.util.HashMap;
import java.util.List;

public class ExpandabaleListview_Adpter1 extends BaseExpandableListAdapter {
    Context context;
    HashMap<String, List<String>> listChild;
    List<String> listHeader;

    public ExpandabaleListview_Adpter1(Context context2, List<String> listHeader2, HashMap<String, List<String>> listChild2) {
        this.context = context2;
        this.listHeader = listHeader2;
        this.listChild = listChild2;
    }

    public int getGroupCount() {
        return this.listHeader.size();
    }

    public int getChildrenCount(int groupPosition) {
        return ((List) this.listChild.get(this.listHeader.get(groupPosition))).size();
    }

    public Object getGroup(int groupPosition) {
        return this.listHeader.get(groupPosition);
    }

    public Object getChild(int groupPosition, int childPosition) {
        return ((List) this.listChild.get(this.listHeader.get(groupPosition))).get(childPosition);
    }

    public long getGroupId(int groupPosition) {
        return (long) groupPosition;
    }

    public long getChildId(int groupPosition, int childPosition) {
        return (long) childPosition;
    }

    public boolean hasStableIds() {
        return false;
    }

    public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup parent) {
        view = ((LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.expandablelist_header1, null);
        TextView textView=view.findViewById(R.id.expandabale_list_header);
        textView.setText((String) getGroup(groupPosition));
        return view;
    }

    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup parent) {
        view = ((LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.expandabalelist_child1, null);
        TextView textView=view.findViewById(R.id.expandabale_list_child);
        textView.setText((String) getGroup(groupPosition));
        view.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(ExpandabaleListview_Adpter1.this.context, "aaa", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
