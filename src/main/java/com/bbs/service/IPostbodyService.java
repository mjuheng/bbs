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

    ReturnInfo makeAdopt(int post_id, int postbody_id);
}
