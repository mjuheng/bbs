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
     * @param id
     * @return
     */
    boolean checkResolve(int id);

    /**
     * 将帖子设置为已解决状态
     * @param id
     * @return
     */
    int setResolve(int id);

    /**
     * 回复数-1
     * @param id
     * @return
     */
    int deductReplyNum(int id);

    /**
     * 根据用户id，查找所发帖子
     * @param id
     * @return
     */
    List<Post> findByConsumerId(int id);

    /**
     * 根据用户id，查找其发帖数
     * @param id
     * @return
     */
    int findCountByConsumerId(int id);

    /**
     * 查找置顶帖子数
     * @return
     */
    int findPeakCount();

    /**
     * 置顶帖子
     * @param id
     * @return
     */
    int makePeakById(int id);

    /**
     * 取消置顶
     * @param id
     * @return
     */
    int removePeak(int id);

    /**
     * 根据id，删除帖子
     * @param id
     * @return
     */
    int deleteById(int id);
}
