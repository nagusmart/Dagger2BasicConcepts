package com.example.daggertwoexampleproject.module;

import android.content.Context;

import com.example.daggertwoexampleproject.scopes.ApplicationContext;
import com.example.daggertwoexampleproject.scopes.NewsApplicationScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    Context context;

    public ContextModule(Context context){
        this.context=context;
    }

    //@Named("application_context")
    @ApplicationContext
    @NewsApplicationScope
    @Provides
    public Context context(){
        return context.getApplicationContext();
    }
}
