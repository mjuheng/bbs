package com.bbs.service;

import com.bbs.entity.Post;
import com.bbs.entity.custom.WritingPostCustom;
import com.bbs.util.Page;
import com.bbs.util.ReturnInfo;

import java.util.List;

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
    List<Post> findAll(Page page);

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

    /**
     * 置顶帖子
     * @param post_id
     * @return
     */
    ReturnInfo makePeak(int post_id);

    /**
     * 取消置顶帖子
     * @param post_id
     * @return
     */
    ReturnInfo removePeak(int post_id);

    /**
     * 删除帖子
     * @param post_id
     * @return
     */
    ReturnInfo deletePost(int post_id);

    /**
     * 查找贴子总数
     * @return
     */
    int countPost();
}
