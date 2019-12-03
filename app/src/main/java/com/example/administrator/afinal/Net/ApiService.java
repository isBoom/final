package com.example.administrator.afinal.Net;

import com.example.administrator.afinal.HttpJsonClass.HttpResult;
import com.example.administrator.afinal.HttpJsonClass.Menu;
import com.example.administrator.afinal.HttpJsonClass.News;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2019/11/14.
 */

public interface ApiService {
    @GET("getnews.php")
    Flowable<HttpResult<News>> getColumn(@Query("column") String temp);
}
