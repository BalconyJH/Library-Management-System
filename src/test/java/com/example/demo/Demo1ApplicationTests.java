package com.example.demo;

import com.example.demo.dao.BookMapper;
import com.example.demo.dao.UserMapper;
import com.example.demo.domain.Book;
import com.example.demo.domain.User;
import com.example.demo.service.BookService;
import com.github.pagehelper.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Demo1ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testlogin(){
        User user = new User();
        user.setEmail("163163lq@163.com");
        user.setPassword("123456");
        User u = userMapper.login(user);
        System.out.println(u);
    }

    @Autowired
    private BookMapper bookMapper;

    @Test
    void testselectNewBooks(){
        List<Book> books = bookMapper.selectNewBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Autowired
    private BookService bookService;

    @Test
    void testselectNewBooksPage(){
        Page<Book> bookPage = bookService.selectNewBooks(1,5);
        System.out.println(bookPage);
    }

    @Test
    void testfindById(){
        Book book = bookMapper.findById("2");
        System.out.println(book);
    }

}
