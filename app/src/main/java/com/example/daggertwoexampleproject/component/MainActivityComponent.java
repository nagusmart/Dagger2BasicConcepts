package com.example.daggertwoexampleproject.component;


import com.example.daggertwoexampleproject.MainActivity;
import com.example.daggertwoexampleproject.NewsAdapter;
import com.example.daggertwoexampleproject.apiService.NewsApiServices;
import com.example.daggertwoexampleproject.module.ActivityModule;
import com.example.daggertwoexampleproject.module.MainActivityModule;
import com.example.daggertwoexampleproject.scopes.MainActivityScope;

import dagger.Component;

@Component(modules = MainActivityModule.class,dependencies = NewsComponent.class)
@MainActivityScope
public interface MainActivityComponent {
//    NewsAdapter getNewsAdapter();
//    NewsApiServices getNewsApiservice();

    void injectMainActivity(MainActivity mainActivity);
}
