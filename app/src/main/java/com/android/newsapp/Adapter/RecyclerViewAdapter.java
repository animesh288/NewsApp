package com.android.newsapp.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.android.newsapp.R;
import com.android.newsapp.model.Headlines;
import com.android.newsapp.DetailedNews;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    Context context;
    ArrayList<Headlines> headlinesArrayList;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<Headlines> getHeadlinesArrayList() {
        return headlinesArrayList;
    }

    public void setHeadlinesArrayList(ArrayList<Headlines> headlinesArrayList) {
        this.headlinesArrayList = headlinesArrayList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.news_item,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, DetailedNews.class);
                intent.putExtra("data",new String[]{headlinesArrayList.get(position).getAuthor(),
                        headlinesArrayList.get(position).getTitle(),
                        headlinesArrayList.get(position).getDescription(),
                        headlinesArrayList.get(position).getUrlToImage(),
                        headlinesArrayList.get(position).getPublishedAt(),
                        headlinesArrayList.get(position).getUrl(),
                        headlinesArrayList.get(position).getContent()
                });
                context.startActivity(intent);
            }
        });
        holder.mDate.setText("Published At:"+headlinesArrayList.get(position).getPublishedAt());
        holder.mAuthor.setText(headlinesArrayList.get(position).getAuthor());
        holder.mDescription.setText(headlinesArrayList.get(position).getDescription());
        holder.mHeading.setText(headlinesArrayList.get(position).getTitle());
        Picasso.get().load(headlinesArrayList.get(position).getUrlToImage()).into(holder.imageView);
    }



    @Override
    public int getItemCount() {
        if(headlinesArrayList==null) return 0;
        return headlinesArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView mHeading,mDescription,mAuthor,mDate;
        CardView cardView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mHeading=itemView.findViewById(R.id.mainHeading);
            mDescription=itemView.findViewById(R.id.description);
            mAuthor=itemView.findViewById(R.id.author);
            mDate=itemView.findViewById(R.id.date);
            imageView=itemView.findViewById(R.id.image);
            cardView=itemView.findViewById(R.id.cardView);
        }
    }
}
