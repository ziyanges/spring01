package com.luoziyang.demo.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luoziyang.demo.Dao.BookDao;
import com.luoziyang.demo.Service.BookService;
import com.luoziyang.demo.domain.book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;

/**
 * @author luoziyang
 * @create 2023-06-21
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookDao,book> implements BookService  {
    @Autowired
    private BookDao bookDao;
    public Boolean modify(book books) {
        return bookDao.updateById(books)>0;
    }
    public Boolean addsome(book books){
        return bookDao.insert(books)>0;
    }
    public Boolean Delete(int id){
        return bookDao.deleteById(id)>0;
    }
}
