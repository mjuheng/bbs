package com.bbs.service.impl;

import com.bbs.dao.IAttentionDao;
import com.bbs.entity.Attention;
import com.bbs.service.IAttentionService;
import com.bbs.util.ReturnInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttentionService implements IAttentionService {

    @Autowired
    private IAttentionDao attentionDao;

    @Override
    public boolean checkAttention(Attention attention) {
        int count = attentionDao.checkAttention(attention);
        if (count > 0) {
            return true;
        }
        return false;
    }

    @Override
    public ReturnInfo deleteAttention(Attention attention) {
        ReturnInfo returnInfo = new ReturnInfo();
        returnInfo.setInfo("取消关注成功");
        int row = attentionDao.deleteAttention(attention);
        if (row == 0){
            returnInfo.setCode(-1);
            returnInfo.setInfo("取消失败");
        }
        return returnInfo;
    }

    @Override
    public ReturnInfo makeAttention(Attention attention) {
        ReturnInfo returnInfo = new ReturnInfo();
        returnInfo.setInfo("关注成功");
        int row = attentionDao.insertAttention(attention);
        if (row == 0){
            returnInfo.setCode(-1);
            returnInfo.setInfo("关注失败");
        }
        return returnInfo;
    }
}
