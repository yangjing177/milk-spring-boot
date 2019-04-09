package com.neu.yang.controller;

import com.neu.yang.entity.Book;
import com.neu.yang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;

@Controller
@RequestMapping("book.do")
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping(params = "find")
    public String bookList(ModelMap map){
        List<Book> list=bookService.queryBook();
        map.put("list",list);
        return "show";
    }

    @RequestMapping(params = "add")
    public String addBook(String bname,String author,String sex,String gift,String time,String pic){
        Book book=new Book();
        book.setBname(bname);
        book.setAuthor(author);
        book.setSex(sex);
        book.setGift(gift);
        book.setPic(pic);
        bookService.insertBook(book);
        return "redirect:book.do?find";
    }

    @RequestMapping(params = "update")
    public String updateBook(){
        return "redirect:book.do?find";
    }

    @RequestMapping(params = "delete")
    public String deleteBook(int id){
        bookService.deleteBook(id);
        return "redirect:book.do?find";
    }
}
