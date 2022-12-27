package com;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.all.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecycleView_Fragment extends Fragment {
    int[] image = {R.drawable.add_item, R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five,
            R.drawable.six,R.drawable.seven,R.drawable.eight,R.drawable.nine, R.drawable.ten, R.drawable.iiiiii};
    String[] name = {"Add Item", "One", "Two", "Three", "Four", "Five", "Six", "Seeven", "Eight", "Nine", "Ten", "Demo"};
    RecyclerView recyclerView;

    static class Recycleview_Adpter extends Adapter<Recycleview_Adpter.myHolder> {
        Context context;
        int[] image;
        String[] name;

        public class myHolder extends ViewHolder {
            CircleImageView circleImageView;
            TextView textView;

            public myHolder(View itemView) {
                super(itemView);
                circleImageView = (CircleImageView) itemView.findViewById(R.id.recycle_view_design_image);
                textView = (TextView) itemView.findViewById(R.id.recycle_view_design_text);
            }
        }

        public Recycleview_Adpter(Context context2, int[] image2, String[] name2) {
            context = context2;
            image = image2;
            name = name2;
        }

        public myHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new myHolder(LayoutInflater.from(this.context).inflate(R.layout.recycleview_design, parent, false));
        }

        public void onBindViewHolder(myHolder holder, int position) {
            holder.circleImageView.setImageResource(this.image[position]);
            holder.textView.setText(this.name[position]);
        }

        public int getItemCount() {
            return this.name.length;
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycleview, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycle_viewwwwwww);

        recyclerView.setAdapter(new Recycleview_Adpter(getContext(), this.image, this.name));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        return view;
    }
}
