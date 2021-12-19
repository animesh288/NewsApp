package com.android.newsapp.di;

import com.android.newsapp.MainActivityViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NewsModule.class})
public interface NewsComponent {

    public void inject(MainActivityViewModel mainActivityViewModel);

}
