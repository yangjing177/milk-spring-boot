package com.neu.yang.mapper;

import com.neu.yang.YangApplication;
import com.neu.yang.entity.*;
import com.neu.yang.service.UserService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = YangApplication.class)
public class BookDaoTest {
    @Autowired
    private BookDao bookDao;
    @Test
    public void queryBook() {
        List<Book> bookList = bookDao.queryBook();
        assertEquals(3,bookList.size());
    }

    @Test
    public void queryBookById() {
        Book book = bookDao.queryBookById(2);
        assertEquals("西游记",book.getBname());
    }

    @Test
    @Ignore
    public void insertBook() {
        Book book = new Book();
        book.setBname("三国演义");
        book.setAuthor("罗贯中");
        int effectedNum=bookDao.insertBook(book);
        assertEquals(1,effectedNum);
    }

    @Test
    @Ignore
    public void updateBook() {
        Book book = new Book();
        book.setId(1);
        book.setBname("红楼梦");
        int effectNum = bookDao.updateBook(book);
        assertEquals(1,effectNum);
    }

    @Test
    @Ignore
    public void deleteBook() {
        int effectedNum = bookDao.deleteBook(5);
        assertEquals(1,effectedNum);

    }
    @Autowired
    private UserService userService;
//    @Test
//    public void queryUser() {
//        User users = userService.queryUser("yang","123");
//        assertEquals("yang",users.getUname());
//    }

    @Test
    public void findUname(){
        User users=userService.findUname("yang");
        assertEquals("yang",users.getUname());
    }

    @Test
    public void add(){
        User user = new User();
         user.setId(1);
         user.setUname("李四");
         user.setUpwd("123");
         user.setType("22");
        int effectedNum=userService.addUser(user);
        assertEquals(1,effectedNum);
    }
        @Test
        @Ignore
    public void login() {

    }
    @Autowired
    UserDao userDao;
    @Test
    public void findAll(){
        List<Person> list=userDao.findAll();
        assertEquals(2,list.size());
    }
    @Test
    public void findN(){
        assertEquals(2,userDao.findNumber());
    }
    @Test
    public void update(){
        Update data=new Update();
        data.setUid(1);
        data.setCname("唐家");
        data.setStatus(1);
        int effectNum=userDao.update(data);
        assertEquals(1,effectNum);
    }

    @Test
    public void findKu(){
        assertEquals(4,userDao.findKu().size());
    }
}
