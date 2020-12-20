package com.example.daggertwoexampleproject.module;

import android.content.Context;

import com.example.daggertwoexampleproject.scopes.NewsApplicationScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    Context context;

    public ActivityModule(Context context){
        this.context=context;
    }

    @Named("activity_context")
    @NewsApplicationScope
    @Provides
    public Context context(){
        return context;
    }
}
