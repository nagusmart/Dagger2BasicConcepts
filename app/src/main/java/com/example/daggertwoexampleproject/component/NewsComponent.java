package com.example.daggertwoexampleproject.component;

import com.example.daggertwoexampleproject.apiService.NewsApiServices;
import com.example.daggertwoexampleproject.module.NewsModule;
import com.example.daggertwoexampleproject.scopes.NewsApplicationScope;

import dagger.Component;

@NewsApplicationScope
@Component(modules = NewsModule.class)
public interface NewsComponent {

    NewsApiServices getNewsApiservice();

}
