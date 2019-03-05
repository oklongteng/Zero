package com.cole.zero;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.cole.ipc.IPCActivity;
import com.cole.view.ViewActivity;
import com.cole.view.ViewPagerActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_fragment:
                Intent intent = new Intent(this, ViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_view_pager:
                intent = new Intent(this,ViewPagerActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_ipc:
                intent = new Intent(this,IPCActivity.class);
                startActivity(intent);
                break;
            default:

        }
    }
}
