package com.cole.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cole.view.R;

public class RecyclerDemoAdapter extends RecyclerView.Adapter<RecyclerDemoAdapter.DemoViewHolder> {
    public static final String TAG = "RecyclerView";
    private Context mContext;

    public RecyclerDemoAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public DemoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View item = LayoutInflater.from(mContext).inflate(R.layout.item_recycler, null, false);
        Log.d(TAG,"onCreateViewHolder "+ i);
        return new DemoViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull DemoViewHolder demoViewHolder, int i) {
        demoViewHolder.content.setText("item " + i);
        Log.d(TAG,"onBindViewHolder "+ i);

    }

    @Override
    public int getItemCount() {
        return 100;
    }

    class DemoViewHolder extends RecyclerView.ViewHolder {
        TextView content;
        View root;

        public DemoViewHolder(@NonNull View itemView) {
            super(itemView);
            root = itemView;
            content = itemView.findViewById(R.id.tv_item);
        }
    }
}
