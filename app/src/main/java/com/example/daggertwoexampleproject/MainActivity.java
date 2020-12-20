package com.example.daggertwoexampleproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.daggertwoexampleproject.apiService.NewsApiServices;
import com.example.daggertwoexampleproject.application.NewsApplication;
import com.example.daggertwoexampleproject.component.DaggerMainActivityComponent;
import com.example.daggertwoexampleproject.component.MainActivityComponent;
import com.example.daggertwoexampleproject.model.DataResponse;
import com.example.daggertwoexampleproject.model.News;
import com.example.daggertwoexampleproject.module.MainActivityModule;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;

    List<News> newsArrayList = new ArrayList<>();

    @Inject
    NewsAdapter newsAdapter;

    @Inject
    NewsApiServices apiInterface;

    MainActivityComponent mainActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.show_news);


        mainActivityComponent = DaggerMainActivityComponent.builder()
                .mainActivityModule(new MainActivityModule(this))
                .newsComponent(NewsApplication.get(this).getNewsApplicationComponent())
                .build();

      //  apiInterface = mainActivityComponent.getNewsApiservice();

        mainActivityComponent.injectMainActivity(this);

        setAdapter();



        // ========

        //  NewsComponent daggerNewsComponent= DaggerNewsComponent.builder().contextModule(new ContextModule(this)).build();

        //   apiInterface=daggerNewsComponent.getNewsApiservice();

        callApi();
    }

    public void setAdapter() {
        //newsAdapter=new NewsAdapter(this);
      //  newsAdapter =mainActivityComponent.getNewsAdapter();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(newsAdapter);
    }

    private void callApi() {
        apiInterface.getNewsList().enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {


                if (response.body().getNewsList() != null) {
                    newsArrayList.addAll(response.body().getNewsList());
                    newsAdapter.setList(newsArrayList);
                    newsAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {

            }
        });
    }
}
