package com.android.newsapp;

import android.app.Application;

import com.android.newsapp.di.DaggerNewsComponent;
import com.android.newsapp.di.NewsComponent;
import com.android.newsapp.di.NewsModule;

import dagger.internal.DaggerCollections;
import dagger.internal.DaggerGenerated;

public class NewsApplication extends Application {

    private NewsComponent newsComponent;

    @Override
    public void onCreate() {

        super.onCreate();

        newsComponent= DaggerNewsComponent.builder()
                .newsModule(new NewsModule()).build();
    }

    public NewsComponent getNewsComponent(){
        return newsComponent;
    }

}
