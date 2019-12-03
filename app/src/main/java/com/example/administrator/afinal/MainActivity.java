package com.example.administrator.afinal;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.administrator.afinal.Fragment.shipin;
import com.example.administrator.afinal.Fragment.wode;
import com.example.administrator.afinal.Fragment.xinwen;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {
    private BottomNavigationBar bottomNavigationBar;
    private List<Fragment> fragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.BottomNavigationBar_Bottom);
        init();
    }

    private void init() {
        fragments = new ArrayList<>();
        fragments.add(new xinwen());
        fragments.add(new shipin());
        fragments.add(new wode());
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.nav_xinwen,"新闻"))
                .addItem(new BottomNavigationItem(R.drawable.nav_shipin,"视频"))
                .addItem(new BottomNavigationItem(R.drawable.wode,"我的"))
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setActiveColor(R.color.blueviolet)
                .initialise();
        bottomNavigationBar.setTabSelectedListener(this);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainFrameLayout,fragments.get(0));
        fragmentTransaction.commit();

    }

    @Override
    public void onTabSelected(int position) {
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainFrameLayout,fragments.get(position));
        fragmentTransaction.commit();
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
