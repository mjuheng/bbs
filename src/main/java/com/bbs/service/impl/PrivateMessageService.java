package com.bbs.service.impl;

import com.bbs.dao.IPrivateMessageDao;
import com.bbs.entity.PrivateMessage;
import com.bbs.service.IPrivateMessageService;
import com.bbs.util.ReturnInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrivateMessageService implements IPrivateMessageService {

    @Autowired
    private IPrivateMessageDao privateMessageDao;

    @Override
    public List<PrivateMessage> findMessage(int consumer_id) {
        //将消息设置为已读
        privateMessageDao.makeAlreadySee(consumer_id);
        //返回结果集
        return privateMessageDao.findAllById(consumer_id);
    }

    @Override
    public int countWithoutWatch(int consumer_id) {
        return privateMessageDao.countWithoutWatch(consumer_id);
    }

    @Override
    public ReturnInfo deleteByConsumerId(int consumer_id) {
        ReturnInfo returnInfo = new ReturnInfo();
        returnInfo.setInfo("全部删除成功");
        int row = privateMessageDao.deleteByConsumerId(consumer_id);
        if (row == 0){
            returnInfo.setInfo("删除失败");
        }
        return returnInfo;
    }

    @Override
    public ReturnInfo deleteOne(int message_id) {
        ReturnInfo returnInfo = new ReturnInfo();
        returnInfo.setInfo("删除消息成功");
        int row = privateMessageDao.deleteById(message_id);
        if (row == 0){
            returnInfo.setInfo("删除消息失败");
        }
        return returnInfo;
    }
}
