package com.android.newsapp;

import android.app.Application;

import com.android.newsapp.di.NewsComponent;

public class NewsApplication extends Application {

    private NewsComponent newsComponent;

    @Override
    public void onCreate() {

        super.onCreate();
    }

}
