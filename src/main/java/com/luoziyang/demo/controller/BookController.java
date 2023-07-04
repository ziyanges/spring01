package com.luoziyang.demo.controller;

import com.luoziyang.demo.Dao.BookDao;
import com.luoziyang.demo.Service.Impl.BookServiceImpl;
import com.luoziyang.demo.controller.Utill.message;
import com.luoziyang.demo.domain.book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.ConstraintValidator;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author luoziyang
 * @create 2023-06-21
 */
@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookServiceImpl bookService;
    @Autowired
    private book books;
    @PostMapping
    public message addsomething(@Valid @RequestBody book books){
        return new message(bookService.addsome(books),null);
    }
    @PutMapping
    public message updatesomethings(@RequestBody book books){
        String temp;
        if(bookService.updateById(books)){
            temp="跟新成功";
        }
        else {
            temp="失败";
        }
        return new message(bookService.updateById(books),temp);
    }
    @DeleteMapping("{id}")
    public boolean deleteevery(@PathVariable int id){
        System.out.println("救命");
        return bookService.Delete(id);
    }
    @GetMapping("{id}")
    public message getevery(@PathVariable int id){
        ArrayList list = new ArrayList<>();
        list.add(id);
        List list1 = bookService.listByIds(list);
        boolean flag;
        if(list1!=null){
            flag=true;
        }
        else
            flag=false;
        return new message(flag,list1);
    }

}
