package com.bbs.dao;

import com.bbs.entity.Category;

import java.util.List;

public interface ICategoryDao {
    //查找全部分类
    List<Category> findAll();

    //根据名字，查找ID
    Integer findIdByName(String name);
}
