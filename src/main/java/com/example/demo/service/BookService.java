package com.example.demo.service;

import com.example.demo.domain.Book;
import com.github.pagehelper.Page;


/**
 * 图书接口
 */
public interface BookService {
    //查询最新上架的图书
//    List<Book> selectNewBooks();
    Page<Book> selectNewBooks(Integer pageNum, Integer pageSize);
    Book findById(String id);
}

