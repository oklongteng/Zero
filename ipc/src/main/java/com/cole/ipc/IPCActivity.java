package com.cole.ipc;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

public class IPCActivity extends AppCompatActivity {
    public static final String TAG = "IPCActivity";
    IBookManager mBookManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipc);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.btn_bind) {
            bindService();
        } else if (view.getId() == R.id.btn_add) {
            if (mBookManager != null){
                Book book = new Book((int)(Math.random()* 100),"asf");
                try {
                    mBookManager.addBook(book);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        } else if (view.getId() == R.id.brn_get) {
            if (mBookManager != null){
                try {
                    List<Book> bookList = mBookManager.getBookList();
                    for (Book book:bookList){
                        Log.d(TAG,"getBook: boojId = "+book.mBookId);
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    private void bindService() {
        Intent intent = new Intent(this, RemoteService.class);
        Log.d(TAG,"bind service");
        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                mBookManager = IBookManager.Stub.asInterface(service);
                Log.d(TAG,"service connect ");
                Log.e(TAG,Log.getStackTraceString(new Throwable()));

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                mBookManager = null;
            }
        }, Service.BIND_AUTO_CREATE);
    }
}
