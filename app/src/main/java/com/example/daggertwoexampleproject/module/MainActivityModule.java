package com.example.daggertwoexampleproject.module;

import com.example.daggertwoexampleproject.MainActivity;
import com.example.daggertwoexampleproject.NewsAdapter;
import com.example.daggertwoexampleproject.scopes.MainActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    private final MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity){
        this.mainActivity=mainActivity;
    }

    @Provides
    @MainActivityScope
    public NewsAdapter getAdapter(){
        return new NewsAdapter(mainActivity);
    }

}
