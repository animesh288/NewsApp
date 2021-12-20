package com.android.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailedNews extends AppCompatActivity {

    ImageView imageView;
    TextView heading,description,author,date,url,content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        imageView=findViewById(R.id.imageView);
        heading=findViewById(R.id.mainHeading);
        description=findViewById(R.id.description);
        author=findViewById(R.id.author);
        date=findViewById(R.id.date);
        url=findViewById(R.id.url);
        content=findViewById(R.id.content);


        Intent intent=getIntent();
        String data[]=intent.getStringArrayExtra("data");

        author.setText(data[0]);
        heading.setText(data[1]);
        description.setText(data[2]);
        Picasso.get().load(data[3]).into(imageView);
        date.setText("Published at:"+data[4]);
        url.setText(data[5]);
        content.setText(data[6]);
        url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl(data[5]);
            }
        });
    }
    private void gotoUrl(String s){

        Uri uri= Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));



    }
}