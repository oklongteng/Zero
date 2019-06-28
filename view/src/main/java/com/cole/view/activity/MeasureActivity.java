package com.cole.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.cole.view.R;

public class MeasureActivity extends AppCompatActivity {
    private static String TAG = "measure";
    private int[] layoutIds = {R.id.linear_a, R.id.linear_b, R.id.linear_c, R.id.linear_d};
    private int[] viewIds = {R.id.tv_a, R.id.tv_b, R.id.tv_c, R.id.tv_d};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measure);
    }

    public void onClick(View v) {
        printViewSize();
    }


    private void printViewSize() {
        for (int index = 0; index < layoutIds.length; index++) {
            View layout = findViewById(layoutIds[index]);
            View tv = findViewById(viewIds[index]);
            Log.d(TAG, "layout width: " + layout.getWidth() + "  tv width: " + tv.getWidth());
        }

    }
}
