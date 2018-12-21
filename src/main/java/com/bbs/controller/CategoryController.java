package com.bbs.controller;

import com.bbs.entity.Category;
import com.bbs.service.ICategoryService;
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
        return "forward:/opt/writingPost.do";
    }

    @RequestMapping("/findCategoryToIndex.do")
    public String findCategoryToIndex(HttpServletRequest request){
        List<Category> categories = categoryService.findCategoryAll();
        request.setAttribute("categories",categories);
        return "/category";
    }
}
