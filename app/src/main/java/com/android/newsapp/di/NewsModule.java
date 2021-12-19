package com.android.newsapp.di;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NewsModule {

    private String baseUrl="https://newsapi.org/v2/";

    @Singleton
    @Provides
    public NewsServiceApi newsServiceApi(Retrofit retrofit){
        return retrofit.create(NewsServiceApi.class);
    }

    @Singleton
    @Provides
    public Retrofit getRetrofitInstance(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
