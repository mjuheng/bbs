package com.bbs.controller;

import com.bbs.entity.Category;
import com.bbs.service.ICategoryService;
import com.bbs.util.ReturnInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    /**
     * 发帖时，查找全部犬类
     * @param request
     * @return
     */
    @RequestMapping("/findCategoryAll.do")
    public String findCategoryAll(HttpServletRequest request){
        List<Category> categories = categoryService.findCategoryAll();
        request.setAttribute("categories",categories);
        return "/writingPost";
    }

    @RequestMapping("/findCategoryToIndex.do")
    public String findCategoryToIndex(HttpServletRequest request){
        List<Category> categories = categoryService.findCategoryAll();
        request.setAttribute("categories",categories);
        return "/category";
    }

    /**
     * 添加分类
     * @param category
     * @param request
     * @return
     */
    @RequestMapping("/addCategory.do")
    public String addCategory(Category category, HttpServletRequest request){
        ReturnInfo returnInfo = categoryService.insertCategory(category);
        request.setAttribute("result",returnInfo.getInfo());
        return "forward:/category/findCategoryToIndex.do";
    }

    /**
     * 删除分类
     * @param category_id
     * @param request
     * @return
     */
    @RequestMapping("/deleteCategory.do")
    public String deleteCategory(int category_id, HttpServletRequest request){
        ReturnInfo returnInfo = categoryService.deleteCategory(category_id);
        request.setAttribute("result",returnInfo.getInfo());
        return "forward:/category/findCategoryToIndex.do";
    }

    /**
     * 更新分类
     * @param category
     * @param request
     * @return
     */
    @RequestMapping("/updateCategory.do")
    public String updateCategory(Category category, HttpServletRequest request){
        ReturnInfo returnInfo = categoryService.updateCategory(category);
        request.setAttribute("result",returnInfo.getInfo());
        return "forward:/category/findCategoryToIndex.do";
    }
}
