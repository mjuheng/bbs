package com.bbs.service.impl;

import com.bbs.dao.ICategoryDao;
import com.bbs.entity.Category;
import com.bbs.service.ICategoryService;
import com.bbs.util.ReturnInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryDao categoryDao;

    @Override
    public ReturnInfo updateCategory(Category category) {
        ReturnInfo returnInfo = new ReturnInfo();
        returnInfo.setInfo("分类修改成功");
        categoryDao.updateNameById(category);
        return returnInfo;
    }

    @Override
    public ReturnInfo deleteCategory(int category_id) {
        ReturnInfo returnInfo = new ReturnInfo();
        returnInfo.setInfo("分类已删除");
        int row = categoryDao.deleteById(category_id);
        if (row == 0){
            returnInfo.setCode(-1);
            returnInfo.setInfo("分类删除失败");
        }
        return returnInfo;
    }

    @Override
    public ReturnInfo insertCategory(Category category) {
        ReturnInfo returnInfo = new ReturnInfo();
        returnInfo.setInfo("添加分类成功");
        int row = categoryDao.insertCategory(category);
        if (row == 0){
            returnInfo.setCode(-1);
            returnInfo.setInfo("添加分类失败");
        }
        return returnInfo;
    }

    @Override
    public List<Category> findCategoryAll() {
        return categoryDao.findAll();
    }
}
