package com.bbs.controller;

import com.bbs.entity.Consumer;
import com.bbs.entity.Post;
import com.bbs.entity.custom.WritingPostCustom;
import com.bbs.service.IPostService;
import com.bbs.util.ReturnInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private IPostService postService;

    /**
     * 发表帖子
     * @param writingPostCustom
     * @param request
     * @return
     */
    @RequestMapping(value = "/writingPost.do",method = RequestMethod.POST)
    public String writingPost(WritingPostCustom writingPostCustom, HttpServletRequest request){
        Consumer consumer = (Consumer) request.getSession().getAttribute("consumer");
        Integer consumer_id = 0;
        try {
            consumer_id = consumer.getId();
        } catch (NullPointerException e){
            request.setAttribute("sendResult","发帖失败");
            return "/postContent";
        }
        writingPostCustom.setConsumer_id(consumer_id);
        ReturnInfo returnInfo = postService.writingPost(writingPostCustom);
        if (returnInfo.getCode() == 0){
            request.setAttribute("sendResult","发帖成功");
        }else {
            request.setAttribute("sendResult","发帖失败");
        }
        return "forward:/post/findPostAll.do";
    }


    /**
     * 跳转到显示帖子首页
     * 查找全部的帖子与置顶帖子
     * @param request
     * @return
     */
    @RequestMapping("/findPostAll.do")
    public String findPostAll(HttpServletRequest request){
        List<Post> peakPosts = postService.findPostPeak();
        List<Post> posts = postService.findAll();
        request.setAttribute("posts",posts);
        request.setAttribute("peakPosts",peakPosts);
        return "/postContent";
    }


    /**
     * 根据分类查找帖子
     * @param category
     * @param request
     * @return
     */
    @RequestMapping("/findPostByCategory/{category}.do")
    public String findPostByCategory(@PathVariable String category, HttpServletRequest request){
        List<Post> peakPosts = postService.findPostPeak();
        List<Post> posts = postService.findByCategory(category);
        request.setAttribute("posts",posts);
        request.setAttribute("peakPosts",peakPosts);
        return "/postContent";
    }

    @RequestMapping("/findPostByTitle.do")
    public String findPostByTitle(String title,HttpServletRequest request){
        List<Post> posts = postService.findPostByTitle(title);
        request.setAttribute("posts",posts);
        request.setAttribute("title",title);
        return "/searchResult";
    }

    @RequestMapping("/findPostByConsumerId.do")
    public String findByConsumerId(int consumer_id,HttpServletRequest request){
        //用户所发帖子
        List<Post> posts = postService.findByConsumerId(consumer_id);
        //用户发帖数
        int sendCount = postService.findCountByConsumerId(consumer_id);
        request.setAttribute("sendCount",sendCount);
        request.setAttribute("posts",posts);
        return "/activate";
    }

}
