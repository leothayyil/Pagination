package com.example.user.pagination.mRecycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.user.pagination.R;

/**
 * Created by USER on 28-12-2017.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView textView;
    public MyViewHolder(View itemView) {
        super(itemView);
        textView=itemView.findViewById(R.id.textTXT);
    }
}
