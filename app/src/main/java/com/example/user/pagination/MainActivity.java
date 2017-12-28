package com.example.user.pagination;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.user.pagination.mPager.Paginator;
import com.example.user.pagination.mRecycler.MyAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    MyAdapter adapter;
    Paginator p=new Paginator();
    private int totalPages=p.TOTAL_NUM_ITEMS/p.ITEMS_REMAINING;
    private int currentPage=0;
    Button prev,next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prev=findViewById(R.id.butt1);
        next=findViewById(R.id.butt2);
        rv=findViewById(R.id.recycler);
        prev.setEnabled(false);

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new MyAdapter(MainActivity.this,p.generatePage(currentPage)));

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPage += 1;
                rv.setAdapter(new MyAdapter(MainActivity.this,p.generatePage(currentPage)));
                toggleButtons();
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                currentPage -= 1;
                rv.setAdapter(new MyAdapter(MainActivity.this,p.generatePage(currentPage)));
                toggleButtons();
            }
        });
    }

    private void toggleButtons() {
        if (currentPage==totalPages){
            next.setEnabled(false);
            prev.setEnabled(true);
        }else if (currentPage==0){
            prev.setEnabled(false);
            next.setEnabled(false);
        }else if (currentPage>=1&&currentPage<=totalPages){
            next.setEnabled(true);
            prev.setEnabled(true);
        }
    }
}
