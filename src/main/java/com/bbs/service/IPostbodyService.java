package com.bbs.service;

import com.bbs.entity.Postbody;
import com.bbs.util.ReturnInfo;

import java.util.List;

public interface IPostbodyService {

    /**
     *查看帖子详情
     * @return
     */
    List<Postbody> findPostbody(Integer id);

    /**
     * 发表评论
     * @param postbody
     * @return
     */
    ReturnInfo writingDiscuss(Postbody postbody);

    /**
     * 采纳评论
     * @param post_id
     * @param postbody_id
     * @return
     */
    ReturnInfo makeAdopt(int post_id, int postbody_id);

    /**
     * 删除评论
     * @param postbody_id
     * @return
     */
    ReturnInfo deleteById(int post_id, int postbody_id);
}
