package com.bbs.service.impl;

import com.bbs.dao.ICategoryDao;
import com.bbs.dao.IPostDao;
import com.bbs.dao.IPostbodyDao;
import com.bbs.entity.Post;
import com.bbs.entity.Postbody;
import com.bbs.entity.custom.WritingPostCustom;
import com.bbs.service.IPostService;
import com.bbs.util.ReturnInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PostService implements IPostService {

    @Autowired
    private ICategoryDao categoryDao;
    @Autowired
    private IPostDao postDao;
    @Autowired
    private IPostbodyDao postbodyDao;

    @Override
    public List<Post> findByCategory(String category) {
        Integer category_id = categoryDao.findIdByName(category);
        return postDao.findByCategory(category_id);
    }

    @Override
    public List<Post> findPostPeak() {
        return postDao.findPostPeak();
    }

    @Override
    public List<Post> findAll() {
        return postDao.findAll();
    }

    @Override
    public List<Post> findPostByTitle(String title) {
        return postDao.findPostByTitle(title);
    }

    @Override
    public ReturnInfo writingPost(WritingPostCustom writingPostCustom) {
        ReturnInfo returnInfo = new ReturnInfo();
        Post post = new Post();
        Postbody postbody = new Postbody();
        //查询分类的id
        Integer category_id = categoryDao.findIdByName(writingPostCustom.getCategory());
        /*写入数据库*/
        Date date = new Date();
        //写入post
        post.setTitle(writingPostCustom.getTitle());
        post.setFirstTime(date);
        post.setLastTime(date);
        post.setCategory_id(category_id);
        post.setConsumer_id(writingPostCustom.getConsumer_id());
        postDao.insertPost(post);
        //写入postbody
        postbody.setContent(writingPostCustom.getContent());
        postbody.setConsumer_id(writingPostCustom.getConsumer_id());
        postbody.setRank(1);
        postbody.setReplyTime(date);
        postbody.setPost_id(post.getId());
        postbodyDao.insertPostbody(postbody);
        return returnInfo;
    }
}
