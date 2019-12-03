package com.example.administrator.afinal.Net;

import android.util.Log;

import com.example.administrator.afinal.HttpJsonClass.HttpResult;
import com.example.administrator.afinal.HttpJsonClass.Menu;
import com.example.administrator.afinal.HttpJsonClass.New;
import com.example.administrator.afinal.HttpJsonClass.News;

import org.reactivestreams.Subscriber;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by skyti on 2019/12/3.
 */

public class MyRetrofit{
    //private static final String URL = "http://10.0.2.2/news/api/";
    private static final String URL = "https://xxxholic.top/news/api/";
    private static MyRetrofit myRetrofit;
    private ApiService apiService;

    public MyRetrofit() {

        LoggingInterceptor loggingInterceptor = new LoggingInterceptor();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5,TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        apiService = retrofit.create(ApiService.class);
    }
    public static MyRetrofit getInstence(){
        if(myRetrofit==null){
            myRetrofit = new MyRetrofit();
        }
        return myRetrofit;
    }
    public void getColumn(String column, Subscriber<List<New>> subscriber){
        Flowable<HttpResult<News>> flowable =  apiService.getColumn(column);
        flowable.map(new Myfunc<List<New>>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
        }
    }
