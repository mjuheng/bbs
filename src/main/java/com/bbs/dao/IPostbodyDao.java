package com.bbs.dao;

import com.bbs.entity.Postbody;
import com.bbs.util.ReturnInfo;

import java.util.List;

public interface IPostbodyDao {
    /**
     * 插入帖子内容
     * @param postbody
     */
    int insertPostbody(Postbody postbody);

    /**
     * 查看帖子详情
     * @param id
     * @return
     */
    List<Postbody> findPostbodyById(int id);

    /**
     * 将评论设置为采纳
     * @param id
     * @return
     */
    int setAdopt(int id);

    /**
     * 根据id，删除评论
     * @param id
     * @return
     */
    int deleteById(int id);

    /**
     * 根据id，查看评论是否被采纳
     * @return
     */
    boolean getAdopt(int id);
}
