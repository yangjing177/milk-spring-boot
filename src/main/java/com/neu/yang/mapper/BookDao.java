package com.neu.yang.mapper;

import com.neu.yang.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookDao {
    List<Book> queryBook();
    Book queryBookById(int id);
    int insertBook(Book book);
    int updateBook(Book book);
    int deleteBook(int id);

}
