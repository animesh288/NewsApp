package com.android.newsapp.di;

import com.android.newsapp.model.Headlines;
import com.android.newsapp.model.MainNews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsServiceApi {


    @GET("top-headlines")
    Call<MainNews> getData(@Query("country")String country,
                           @Query("pageSize")int pageSize,
                           @Query("apiKey")String apiKey
    );
}
