package com.luoziyang.demo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.luoziyang.demo.Dao.BookDao;
import com.luoziyang.demo.Service.Impl.BookServiceImpl;
import com.luoziyang.demo.domain.book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.awt.print.Book;
import java.util.List;
import java.util.function.Function;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private  book books;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private BookServiceImpl bookService;

    @Test
    void contextLoads() {
        IPage page = new Page(1,2);
        LambdaQueryWrapper<book> lqw = new LambdaQueryWrapper<book>();
        QueryWrapper<book> oqw = new QueryWrapper<>();
        oqw.like("name","傻狗");
        lqw.like(book::getName,"Spring");
        bookDao.selectPage(page,oqw);
    }
    @Test
    void test(@Autowired RedisTemplate redisTemplate){
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("testKey456","testValue789");
    }
    @Test
    void test1(@Autowired RedisTemplate redisTemplate){
        ValueOperations ops = redisTemplate.opsForValue();
        Object o = ops.get("testKey456");
        System.out.println(o);
    }


}
