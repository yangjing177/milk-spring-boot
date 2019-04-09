package com.neu.yang.service;

import com.neu.yang.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> queryBook();
    Book queryBookById(int id);
    int insertBook(Book book);
    int updateBook(Book book);
    int deleteBook(int id);
}
