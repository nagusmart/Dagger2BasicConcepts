package com.example.daggertwoexampleproject.application;

import android.app.Activity;
import android.app.Application;

import com.example.daggertwoexampleproject.component.DaggerNewsComponent;
import com.example.daggertwoexampleproject.component.NewsComponent;
import com.example.daggertwoexampleproject.module.ContextModule;

public class NewsApplication extends Application {

    //add application name in Manifest file
    private NewsComponent newsApplicationComponent;

    public static NewsApplication get(Activity activity){
        return (NewsApplication) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //Timber.plant(new Timber.DebugTree());

        newsApplicationComponent = DaggerNewsComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
    }

    public  NewsComponent getNewsApplicationComponent () {
        return newsApplicationComponent;
    }
}
