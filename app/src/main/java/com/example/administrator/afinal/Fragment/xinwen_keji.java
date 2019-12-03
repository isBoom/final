package com.example.administrator.afinal.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrator.afinal.Adapter.MyAdapter;
import com.example.administrator.afinal.HttpJsonClass.Menu;
import com.example.administrator.afinal.HttpJsonClass.New;
import com.example.administrator.afinal.HttpJsonClass.News;
import com.example.administrator.afinal.MainActivity;
import com.example.administrator.afinal.Net.MyRetrofit;
import com.example.administrator.afinal.Net.Serverexception;
import com.example.administrator.afinal.R;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

public class xinwen_keji extends Fragment {
    private RecyclerView recyclerView;

    public xinwen_keji() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_xinwen_keji, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.xinWenKeJi);

        MyRetrofit.getInstence().getColumn("科技", new Subscriber<List<New>>() {
            @Override
            public void onSubscribe(Subscription s) {
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(List<New> news) {
                Log.i("Tag",news.toString());
                MyAdapter myAdapter = new MyAdapter(R.layout.list_item, news);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerView.setAdapter(myAdapter);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        });
        return view;
    }
}