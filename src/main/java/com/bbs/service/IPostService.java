package com.bbs.service;

import com.bbs.entity.Post;
import com.bbs.entity.custom.WritingPostCustom;
import com.bbs.util.ReturnInfo;
import javafx.geometry.Pos;

import java.util.List;
import java.util.Map;

public interface IPostService {

    /**
     * 发帖
     * @param writingPostCustom
     * @return
     */
    ReturnInfo writingPost(WritingPostCustom writingPostCustom);

    /**
     * 查找全部帖子
     * @return
     */
    List<Post> findAll();

    /**
     * 根据分类查找帖子
     * @param category
     * @return
     */
    List<Post> findByCategory(String category);

    /**
     * 查找置顶帖子
     * @return
     */
    List<Post> findPostPeak();

    /**
     * 根据标题模糊查找帖子
     * @param title
     * @return
     */
    List<Post> findPostByTitle(String title);

    /**
     * 根据id，查找用户所发帖子
     * @param consumer_id
     * @return
     */
    List<Post> findByConsumerId(int consumer_id);

    /**
     * 查找用户发帖数
     * @param consumer_id
     * @return
     */
    int findCountByConsumerId(int consumer_id);
}
