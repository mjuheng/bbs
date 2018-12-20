package com.bbs.dao;

import com.bbs.entity.Post;

import java.util.List;

public interface IPostDao {
    /**
     * 发帖
     * @param post
     */
    void insertPost(Post post);

    /**
     * 查找全部的帖子
     * @return
     */
    List<Post> findAll();

    /**
     * 访问时，访客加一
     * @param id
     */
    void updateWatchNum(Integer id);

    /**
     * 回复时，回复数加一
     * @param id
     */
    void updateReplyNum(Integer id);

    /**
     * 根据分类查找帖子
     * @param category_id
     * @return
     */
    List<Post> findByCategory(Integer category_id);

    /**
     * 查找置顶帖子
     * @return
     */
    List<Post> findPostPeak();

    /**
     * 根据标题查找帖子
     * @param title
     * @return
     */
    List<Post> findPostByTitle(String title);

    /**
     * 检查帖子是否已解决
     * @param post_id
     * @return
     */
    boolean checkResolve(int post_id);

    /**
     * 将帖子设置为已解决状态
     * @param post_id
     * @return
     */
    int setResolve(int post_id);
}
