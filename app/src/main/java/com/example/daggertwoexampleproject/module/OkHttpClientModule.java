package com.example.daggertwoexampleproject.module;

import android.content.Context;

import com.example.daggertwoexampleproject.scopes.ApplicationContext;

import java.io.IOException;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Module(includes=ContextModule.class)
public class OkHttpClientModule {

    @Provides
    public OkHttpClient okHttpClient(@ApplicationContext Context context){

        OkHttpClient okHttpClient = null;
 
          if(context!=null){
             okHttpClient=  new OkHttpClient.Builder().addInterceptor(new Interceptor() {
                  @Override
                  public Response intercept(Chain chain) throws IOException {
                      Request original = chain.request();

                      Request request = original.newBuilder()
                              .header("x-rapidapi-key","d907e1b81emsha76b037e3a900d3p1d3acdjsne0ae42884ddf")
                              .method(original.method(), original.body())
                              .build();

                      return chain.proceed(request);
                  }
              }).build();
          }
        
        return okHttpClient;

    }

}
