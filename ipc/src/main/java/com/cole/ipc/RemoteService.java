package com.cole.ipc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class RemoteService extends Service {
    public static final String TAG = "IPC RemoteService";
    private List<Book> mBookList;
    public RemoteService() {
        Log.d(TAG,"construct");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG,"onBind");
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"onCreate");
        mBookList = new ArrayList<>();
    }

    IBookManager.Stub mBinder = new IBookManager.Stub() {
        @Override
        public List<Book> getBookList() throws RemoteException {
            Log.d(TAG,"get");
            return mBookList;
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            Log.d(TAG,"add");
            if (mBookList != null){
                mBookList.add(book);
            }

        }
    };
}
