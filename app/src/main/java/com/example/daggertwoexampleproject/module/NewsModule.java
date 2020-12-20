package com.example.daggertwoexampleproject.module;

import com.example.daggertwoexampleproject.apiService.NewsApiServices;
import com.example.daggertwoexampleproject.helper.Helper;
import com.example.daggertwoexampleproject.scopes.NewsApplicationScope;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = OkHttpClientModule.class)
public class NewsModule {

    @Provides
    public NewsApiServices newsApiServices(Retrofit retrofit){
        return retrofit.create(NewsApiServices.class);
    }

    @NewsApplicationScope
    @Provides
    public Retrofit retrofit(GsonConverterFactory gsonConverterFactory,OkHttpClient okHttpClient){


      /*  OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                Request request = original.newBuilder()
                        .header("x-rapidapi-key","d907e1b81emsha76b037e3a900d3p1d3acdjsne0ae42884ddf")
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
        }).build();*/

//        final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//
//        OkHttpClient client = httpClient.build();

        return new Retrofit.Builder().baseUrl("https://bing-news-search1.p.rapidapi.com/").addConverterFactory(gsonConverterFactory).client(okHttpClient).build();
    }


    @Provides
    public Gson gson(){
        GsonBuilder gsonBuilder=new GsonBuilder();
        return gsonBuilder.create();
    }

    @Provides
    public GsonConverterFactory gsonConverterFactory(Gson gson){
        return GsonConverterFactory.create(gson);
    }

}
