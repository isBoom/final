package com.example.administrator.afinal.Fragment;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.afinal.R;

import java.util.ArrayList;
import java.util.List;


public class xinwen extends Fragment {
    private List<Fragment> fragmentList;
    private TabLayout xinWenTop;
    private ViewPager xinWenBottom;
    public xinwen() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_xinwen,container,false);
        xinWenTop = (TabLayout) view.findViewById(R.id.xinWenTop);
        xinWenBottom = (ViewPager) view.findViewById(R.id.xinWenBottom);
        init();
        return view;
    }

    private void init() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new xinwen_keji());
        fragmentList.add(new xinwen_yule());
        fragmentList.add(new xinwen_shenghuo());
        fragmentList.add(new xinwen_tiyu());
        fragmentList.add(new xinwen_shehui());

        Adappter pagerAdapter = new Adappter(getChildFragmentManager());
        xinWenTop.setTabMode(TabLayout.MODE_SCROLLABLE);
        xinWenTop.setSelectedTabIndicatorColor(Color.GRAY);
        xinWenBottom.setAdapter(pagerAdapter);
        xinWenTop.setupWithViewPager(xinWenBottom);

        xinWenTop.getTabAt(0).setText("科技");
        xinWenTop.getTabAt(1).setText("热点");
        xinWenTop.getTabAt(2).setText("头条");
        xinWenTop.getTabAt(3).setText("体育");
        xinWenTop.getTabAt(4).setText("社会");
    }

    private class Adappter extends FragmentPagerAdapter{
        public Adappter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }
}
