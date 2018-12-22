package com.bbs.service;

import com.bbs.entity.Category;
import com.bbs.util.ReturnInfo;

import java.util.List;

public interface ICategoryService {
    /**
     * 查找全部分类
     * @return
     */
    List<Category> findCategoryAll();

    /**
     * 添加分类
     * @param category
     * @return
     */
    ReturnInfo insertCategory(Category category);

    /**
     * 删除分类
     * @param category_id
     * @return
     */
    ReturnInfo deleteCategory(int category_id);

    /**
     * 更新分类名
     * @param category
     * @return
     */
    ReturnInfo updateCategory(Category category);
}
