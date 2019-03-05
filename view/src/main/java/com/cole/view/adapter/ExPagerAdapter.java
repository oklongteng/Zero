package com.cole.view.adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class ExPagerAdapter extends PagerAdapter {
    public static final String TAG = "ExPagerAdapter";
    List<View> mPagers;

    public ExPagerAdapter(List<View> pagers) {
        mPagers = pagers;
        Log.d(TAG, "ExPagerAdapter construct");
    }

    @Override
    public int getCount() {
        Log.d(TAG, "getCount");
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        Log.d(TAG, "isViewFromObject");
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        position = position % mPagers.size();
        Log.d(TAG, "instantiateItem " + position);
        View pager = mPagers.get(position);
        ViewGroup parent = (ViewGroup) pager.getParent();
        if (parent != null) {
            parent.removeView(pager);
        }
        container.addView(mPagers.get(position));

        return pager;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        // FIXME: 2019/2/27 这里不能调用container 的remove方法
        Log.d(TAG, "destroyItem " + position + " container == null:" + (container == null));
    }
}

