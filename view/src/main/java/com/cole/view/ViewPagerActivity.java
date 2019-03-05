package com.cole.view;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.cole.view.adapter.ExPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        setViewPagerAdapter();
    }

    private void setViewPagerAdapter(){
        mViewPager = findViewById(R.id.viewPager);
        List<View> pagers = new ArrayList<>();
        View pager0 = LayoutInflater.from(this).inflate(R.layout.item_pagers,null,false);
        View pager1 = LayoutInflater.from(this).inflate(R.layout.item_pagers,null,false);
        View pager2 = LayoutInflater.from(this).inflate(R.layout.item_pagers,null,false);
        View pager3 = LayoutInflater.from(this).inflate(R.layout.item_pagers,null,false);
        View pager4 = LayoutInflater.from(this).inflate(R.layout.item_pagers,null,false);
        View pager5 = LayoutInflater.from(this).inflate(R.layout.item_pagers,null,false);
        pagers.add(pager0);
        pagers.add(pager1);
        pagers.add(pager2);
        pagers.add(pager3);
        pagers.add(pager4);
        pagers.add(pager5);
        ExPagerAdapter exPagerAdapter = new ExPagerAdapter(pagers);
        mViewPager.setAdapter(exPagerAdapter);
    }
}
