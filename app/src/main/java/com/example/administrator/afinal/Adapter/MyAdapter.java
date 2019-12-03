package com.example.administrator.afinal.Adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.afinal.HttpJsonClass.Menu;
import com.example.administrator.afinal.HttpJsonClass.New;
import com.example.administrator.afinal.R;

import java.util.List;

/**
 * Created by Administrator on 2019/11/5.
 */

public class MyAdapter extends BaseQuickAdapter<New,BaseViewHolder> {
    public MyAdapter(@LayoutRes int layoutResId, @Nullable List<New> data) {
        super(layoutResId, data);
    }
    @Override
    protected void convert(BaseViewHolder helper, New item) {
        helper.setText(R.id.itemTitle,item.getTitle());
        helper.setText(R.id.itemPrice,item.getContent());
        Glide.with(mContext).load(item.getImageUrl()).into((ImageView) helper.getView(R.id.itemImage));
    }


//
//    public MyAdapter(@LayoutRes int layoutResId, @Nullable List<Menu> data) {
//        super(layoutResId, data);
//    }

//
//    @Override
//    protected void convert(BaseViewHolder helper, Menu item) {
//        helper.setText(R.id.itemTitle,item.get);
//        helper.setText(R.id.itemPrice,item.getPrice());
//        Glide.with(mContext).load(item.getImageUrl()).into((ImageView) helper.getView(R.id.itemImage));
//    }


}
