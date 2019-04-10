package com.neu.yang.service.impl;

import com.neu.yang.mapper.BookDao;
import com.neu.yang.entity.Book;
import com.neu.yang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookService")
public class BookServiceImpl implements BookService {
    @Autowired
    BookDao bookDao;

    @Override
    public List<Book> queryBook() {
        List<Book> list = bookDao.queryBook();
        return list;
    }

    @Override
    public Book queryBookById(int id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public int insertBook(Book book) { return bookDao.insertBook(book); }

    @Override
    public int updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public int deleteBook(int id) {
        return bookDao.deleteBook(id);
    }
}
