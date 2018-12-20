package com.bbs.service.impl;

import com.bbs.dao.IPostDao;
import com.bbs.dao.IPostbodyDao;
import com.bbs.entity.Post;
import com.bbs.entity.Postbody;
import com.bbs.service.IPostbodyService;
import com.bbs.util.ReturnInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostbodyService implements IPostbodyService {

    @Autowired
    private IPostbodyDao postbodyDao;
    @Autowired
    private IPostDao postDao;

    /**
     * 发表评论
     * @param postbody
     * @return
     */
    @Override
    public ReturnInfo writingDiscuss(Postbody postbody) {
        ReturnInfo returnInfo = new ReturnInfo();
        returnInfo.setCode(-1);
        int row = postbodyDao.insertPostbody(postbody);
        if (row != 0){
            postDao.updateReplyNum(postbody.getPost_id());
            returnInfo.setCode(0);
        }
        return returnInfo;
    }

    /**
     * 查看帖子
     * @param id
     * @return
     */
    @Override
    public List<Postbody> findPostbody(Integer id) {
        //帖子访问+1
        postDao.updateWatchNum(id);
        return postbodyDao.findPostbodyById(id);
    }

    @Override
    public ReturnInfo makeAdopt(int post_id, int postbody_id) {
        return null;
    }
}
