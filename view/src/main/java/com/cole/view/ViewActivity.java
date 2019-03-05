package com.cole.view;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.cole.view.fragment.BlankFragment;
import com.cole.view.fragment.ExampleFragment;

public class ViewActivity extends AppCompatActivity {
    private FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        FragmentManager fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        setDefault();

    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_replace) {
            ExampleFragment fragment = new ExampleFragment();
            transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container_fragment,fragment);
            transaction.addToBackStack("one");//点击back，撤销该事务，返回到上一个fragment
            transaction.commit();
        } else {
        }
    }

    private void setDefault() {
        if (transaction != null){
            BlankFragment fragment = new BlankFragment();
            transaction.add(R.id.container_fragment, fragment);
            transaction.addToBackStack("zero");//点击back，撤销该事务，取消添加该fragment
            transaction.commit();
        }
    }


}
