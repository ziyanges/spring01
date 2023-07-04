package com.luoziyang.demo.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.luoziyang.demo.domain.book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author luoziyang
 * @create 2023-06-21
 */
@Mapper
public interface BookDao extends BaseMapper<book> {

}
