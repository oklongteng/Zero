// IBookManager.aidl
package com.cole.ipc;

import com.cole.ipc.Book;
// Declare any non-default types here with import statements

interface IBookManager {
    List<Book> getBookList();
    void addBook(in Book book);
}
