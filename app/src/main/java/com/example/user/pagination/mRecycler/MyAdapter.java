package com.example.user.pagination.mRecycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.pagination.R;

import java.util.ArrayList;

/**
 * Created by USER on 28-12-2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context c;
    ArrayList<String> spaceCrafts;

    public MyAdapter(Context c, ArrayList<String> spaceCrafts) {
        this.c = c;
        this.spaceCrafts = spaceCrafts;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View  view= LayoutInflater.from(parent.getContext()).inflate(R.layout.model,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.textView.setText(spaceCrafts.get(position));
    }

    @Override
    public int getItemCount() {
        return spaceCrafts.size();
    }
}
