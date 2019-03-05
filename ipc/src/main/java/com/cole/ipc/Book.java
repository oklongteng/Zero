package com.cole.ipc;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable{
    public int mBookId;
    public String mBookName;

    public Book(int bookId,String bookName){
        mBookId = bookId;
        mBookName = bookName;
    }


    protected Book(Parcel in) {
        mBookId = in.readInt();
        mBookName = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mBookId);
        dest.writeString(mBookName);
    }
}
