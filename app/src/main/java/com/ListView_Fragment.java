package com;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.all.AddItem_Activity;
import com.all.R;
import com.all.ListView_Model;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListView_Fragment extends Fragment {
    ArrayList arrayList;
    ListView listView;
    ListView_Adpter listViewAdpter;
    List<ListView_Model> listViewmodels;

    class ListView_Adpter extends ArrayAdapter<ListView_Model> {
        Context context;
        List<ListView_Model> listViewmodels;
        int resource;

        public ListView_Adpter(Context context2, int resource2, List<ListView_Model> listViewmodels2) {
            super(context2, resource2, listViewmodels2);
            this.resource = resource2;
            this.context = context2;
            this.listViewmodels = listViewmodels2;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.listview_layout_design, parent, false);
            ListView_Model listView_model = (ListView_Model) this.listViewmodels.get(position);
            CircleImageView circleImageView = (CircleImageView) view.findViewById(R.id.listview_layout_design_cicle_image);
            TextView textView = (TextView) view.findViewById(R.id.listview_layout_design_text);
            if (listView_model.getImage() == 0) {
                circleImageView.setImageBitmap(BitmapFactory.decodeFile(listView_model.getImage_path()));
                textView.setText(listView_model.getName());
            } else {
                circleImageView.setImageDrawable(this.context.getResources().getDrawable(listView_model.getImage()));
                textView.setText(listView_model.getName());
            }
            ListView_Fragment.this.listView.setOnItemClickListener(new OnItemClickListener() {
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    if (position == 0) {
                        ListView_Fragment.this.startActivity(new Intent(ListView_Adpter.this.getContext(), AddItem_Activity.class));
                    }
                }
            });
            ListView_Fragment.this.listView.setOnItemLongClickListener(new OnItemLongClickListener() {
                public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long id) {
                    Builder builder = new Builder(ListView_Adpter.this.getContext());
                    builder.setIcon(R.drawable.alert);
                    builder.setMessage("Are you want to Sure Delete ?");
                    builder.setTitle("Delete");
                    builder.setPositiveButton("Yes", new OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            if (position == 0) {
                                Builder builder1 = new Builder(ListView_Adpter.this.context);
                                builder1.setTitle("Sorry, We can't delete Add New..");
                                builder1.setNegativeButton("Cancel", null);
                                builder1.show();
                                return;
                            }
                            ListView_Adpter.this.delete(position);
                        }
                    });
                    builder.setNegativeButton("No", null);
                    builder.setCancelable(false);
                    builder.show();
                    return false;
                }
            });
            return view;
        }

        /* access modifiers changed from: 0000 */
        public void delete(int position) {
            this.listViewmodels.remove(position);
            notifyDataSetChanged();
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listview, container, false);
        this.listView = (ListView) view.findViewById(R.id.list_viewwwwwww);
        ArrayList arrayList2 = new ArrayList();
        this.arrayList = arrayList2;
        arrayList2.add(new ListView_Model(R.drawable.add_item, "Add New"));
        this.arrayList.add(new ListView_Model(R.drawable.one, "One"));
        this.arrayList.add(new ListView_Model(R.drawable.two, "Two"));
        this.arrayList.add(new ListView_Model(R.drawable.three, "Three"));
        this.arrayList.add(new ListView_Model(R.drawable.four, "Four"));
        this.arrayList.add(new ListView_Model(R.drawable.five, "Five"));
        this.arrayList.add(new ListView_Model(R.drawable.six, "Six"));
        this.arrayList.add(new ListView_Model(R.drawable.seven, "Seven"));
        this.arrayList.add(new ListView_Model(R.drawable.eight, "Eight"));
        this.arrayList.add(new ListView_Model(R.drawable.nine, "Nine"));
        this.arrayList.add(new ListView_Model(R.drawable.ten, "Ten"));
        this.arrayList.add(new ListView_Model(R.drawable.iiiiii, "Demo"));
        ListView_Adpter listView_Adpter = new ListView_Adpter(getContext(), R.layout.listview_layout_design, this.arrayList);
        this.listViewAdpter = listView_Adpter;
        this.listView.setAdapter(listView_Adpter);
        return view;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == -1) {
            String returnname = data.getStringExtra("photoname");
            this.listViewmodels.add(1, new ListView_Model(0, data.getStringExtra("path"), returnname));
            this.listViewAdpter.notifyDataSetChanged();
        }
    }
}
