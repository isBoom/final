package com.example.administrator.afinal.Net;

import android.util.Log;

import com.example.administrator.afinal.HttpJsonClass.HttpResult;
import com.example.administrator.afinal.HttpJsonClass.New;
import com.example.administrator.afinal.HttpJsonClass.News;

import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by skyti on 2019/11/26.
 */

public class Myfunc<T> implements Function<HttpResult<News>, List<New>> {

//    @Override
//    public T apply(@NonNull HttpResult<T> tHttpResult) throws Exception {
//        Log.i("Tag","---------------------");
//        Log.i("Tag",tHttpResult.toString());
//        if(tHttpResult.getCode()!=0){
//            throw new Serverexception(tHttpResult.getCode(),tHttpResult.getMessage());
//        }
//        return tHttpResult.getData();
//    }

    @Override
    public List<New> apply(@NonNull HttpResult<News> newsHttpResult) throws Exception {
        if(newsHttpResult.getCode()!=0){
            throw new Serverexception(newsHttpResult.getCode(),newsHttpResult.getMessage());
        }
        return newsHttpResult.getData().getNewsList();
}
}
