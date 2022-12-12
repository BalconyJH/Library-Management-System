package com.example.demo.service;

import com.example.demo.dao.BookMapper;
import com.example.demo.domain.Book;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    //注入bookMapper
    private final BookMapper bookMapper;

    public BookServiceImpl(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    //查询最新上架的图书
//    public List<Book> selectNewBooks() {
//        return bookMapper.selectNewBooks();
//    }

    public Page<Book> selectNewBooks(Integer pageNum, Integer pageSize) {
        // 设置分页查询的参数，开始分页
        PageHelper.startPage(pageNum, pageSize);
        //强制转换，因为Page也是list类型
        return (Page<Book>) bookMapper.selectNewBooks();
    }

    public Book findById(String id) {
        return bookMapper.findById(id);
    }

}
