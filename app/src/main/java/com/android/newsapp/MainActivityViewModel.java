package com.android.newsapp;

import android.app.Application;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.android.newsapp.di.NewsServiceApi;
import com.android.newsapp.model.MainNews;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends AndroidViewModel {

    @Inject
    NewsServiceApi newsServiceApi;

    private String apiKey="612dfad3379e4ed9b82bf6e1746ac0ca";

    private MutableLiveData<MainNews> liveData;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        liveData=new MutableLiveData<>();
    }

    public MutableLiveData<MainNews> getLiveData() {
        return liveData;
    }

    public void makeApiCall(){
        Call<MainNews> call=newsServiceApi.getData("us",99,apiKey);
        call.enqueue(new Callback<MainNews>() {
            @Override
            public void onResponse(Call<MainNews> call, Response<MainNews> response) {
                if(response.isSuccessful()){
                    liveData.postValue(response.body());
                }else{
                    liveData.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<MainNews> call, Throwable t) {
                liveData.postValue(null);
            }
        });
    }
}
