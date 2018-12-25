package com.bbs.service;

import com.bbs.entity.PrivateMessage;
import com.bbs.util.ReturnInfo;

import java.util.List;

public interface IPrivateMessageService {

    /**
     * 查找帖子
     * @param consumer_id
     * @return
     */
    List<PrivateMessage> findMessage(int consumer_id);

    /**
     * 删除单条消息
     * @param message_id
     * @return
     */
    ReturnInfo deleteOne(int message_id);

    /**
     * 根据用户id删除全部消息
     * @param consumer_id
     * @return
     */
    ReturnInfo deleteByConsumerId(int consumer_id);

    /**
     * 未查看的消息数
     * @param consumer_id
     * @return
     */
    int countWithoutWatch(int consumer_id);
}
