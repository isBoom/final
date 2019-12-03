package com.example.administrator.afinal.Net;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2019/11/28.
 */

public class LoggingInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request()
                .newBuilder()
                .addHeader("header","xxx")
                .build();
        long t1 = System.nanoTime();

        Log.i("Tag",String.format("[request] [%s] %n%s",
                request.url(), request.headers()));

        Response response = chain.proceed(request);

        long t2 = System.nanoTime();

        Log.i("Tag",String.format("[response] [%s] [%.1fms]%n%s",
                response.request().url(), (t2 - t1) / 1e6d, response.headers()));
        return response;
    }
}
