package com.android.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.newsapp.Adapter.RecyclerViewAdapter;
import com.android.newsapp.model.MainNews;

public class MainActivity extends AppCompatActivity {

    RecyclerViewAdapter recyclerViewAdapter;
    private MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
        getData();

    }

    private void initRecyclerView() {

        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapter=new RecyclerViewAdapter();
        recyclerView.setAdapter(recyclerViewAdapter);
    }
    private void getData(){
        mainActivityViewModel=new ViewModelProvider(this).get(MainActivityViewModel.class);
        mainActivityViewModel.getLiveData().observe(this, new Observer<MainNews>() {
            @Override
            public void onChanged(MainNews mainNews) {
                if(mainNews!=null){
                    recyclerViewAdapter.setHeadlinesArrayList(mainNews.getArticles());
                    recyclerViewAdapter.notifyDataSetChanged();
                }else{
                    Toast.makeText(MainActivity.this, "unable to fetch data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}