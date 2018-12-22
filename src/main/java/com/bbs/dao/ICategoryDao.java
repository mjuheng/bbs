package com.bbs.dao;

import com.bbs.entity.Category;

import java.util.List;

public interface ICategoryDao {
    /**
     * 查找全部分类
     * @return
     */
    List<Category> findAll();

    /**
     * 根据名字，查找ID
     * @param name
     * @return
     */
    Integer findIdByName(String name);

    /**
     * 添加分类
     * @param category
     * @return
     */
    int insertCategory(Category category);

    /**
     * 根据id删除分类
     * @param category_id
     * @return
     */
    int deleteById(int category_id);

    /**
     * 修改分类名字
     * @param category
     * @return
     */
    int updateNameById(Category category);
}
