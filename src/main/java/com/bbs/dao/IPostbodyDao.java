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
     * @param postbody_id
     * @return
     */
    int setAdopt(int postbody_id);
}
