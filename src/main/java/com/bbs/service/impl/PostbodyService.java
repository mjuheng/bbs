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

    /**
     * 删除评论
     * @param postbody_id
     * @return
     */
    @Override
    public ReturnInfo deleteById(int post_id, int postbody_id) {
        ReturnInfo returnInfo = new ReturnInfo();
        returnInfo.setInfo("删除成功");
        //如果此条评论被采纳，则不能删除
        if (!postbodyDao.getAdopt(postbody_id)) {
            int row = postbodyDao.deleteById(postbody_id);
            if (row == 0) {
                returnInfo.setCode(-1);
                returnInfo.setInfo("删除失败");
            } else {
                postDao.deductReplyNum(post_id);
            }
        }else {
            returnInfo.setCode(-1);
            returnInfo.setInfo("评论已被采纳，不能删除");
        }
        return returnInfo;
    }

    @Override
    public ReturnInfo makeAdopt(int post_id, int postbody_id) {
        ReturnInfo returnInfo = new ReturnInfo();
        //判断帖子是否已经被采纳（每个帖子只能采纳一条评论）
        boolean isResolve = postDao.checkResolve(post_id);
        if (!isResolve){
            //将评论设置为采纳
            postbodyDao.setAdopt(postbody_id);
            //将帖子设置为已解决
            postDao.setResolve(post_id);
            returnInfo.setInfo("采纳成功");
        }else {
            returnInfo.setCode(-1);
            returnInfo.setInfo("该帖子已结贴，无法采纳");
        }
        return returnInfo;
    }
}
