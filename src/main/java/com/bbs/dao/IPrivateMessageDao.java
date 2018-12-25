package com.bbs.dao;

import com.bbs.entity.PrivateMessage;

import java.util.List;

public interface IPrivateMessageDao {

    /**
     * 根据用户，查找全部消息
     * @param id
     * @return
     */
    List<PrivateMessage> findAllById(int id);

    /**
     * 根据id删除单个消息
     * @param id
     * @return
     */
    int deleteById(int id);

    /**
     * 添加信息
     * @param privateMessage
     * @return
     */
    int insertMessage(PrivateMessage privateMessage);

    /**
     * 根据用户删除全部消息
     * @param id
     * @return
     */
    int deleteByConsumerId(int id);

    /**
     * 未查看的消息数
     * @param id
     * @return
     */
    int countWithoutWatch(int id);

    /**
     * 将消息设置为已读
     * @param id
     * @return
     */
    int makeAlreadySee(int id);
}
