package com.example.demo.controller;

import com.example.demo.domain.Book;
import com.example.demo.entity.Result;
import com.example.demo.service.BookService;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/book")
public class BookController {
    //注入BookService对象
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * 查询最新上架的图书
     */
    @RequestMapping("/selectNewbooks")
    public ModelAndView selectNewbooks() {
        ModelAndView modelAndView = new ModelAndView();
//        List<Book> books = bookService.selectNewBooks();
        //查询最新上架的5个的图书信息
        int pageNum = 1;
        int pageSize = 5;
        Page<Book> bookPage = bookService.selectNewBooks(pageNum, pageSize);
        modelAndView.setViewName("books_new");
//        modelAndView.addObject("books",books);
        modelAndView.addObject("bookPage", bookPage);
        return modelAndView;
    }

    @RequestMapping("/main")
    public String toMain() {
        return "main";
    }

    /**
     * 根据图书id查询图书信息
     *
     * @param id 查询的图书id
     */
    @ResponseBody
    @RequestMapping("/findById")
    public Result<Book> findById(String id) {
        try {
            Book book = bookService.findById(id);
            if (book == null) {
                return new Result<>(false, "查询图书失败！");
            }
            return new Result<>(true, "查询图书成功", book);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(false, "查询图书失败！");
        }
    }
}

