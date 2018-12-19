package com.bbs.service.impl;

import com.bbs.dao.ICategoryDao;
import com.bbs.entity.Category;
import com.bbs.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryDao categoryDao;

    @Override
    public List<Category> findCategoryAll() {
        return categoryDao.findAll();
    }
}
