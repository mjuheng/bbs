package com.bbs.dao;

import com.bbs.entity.Consumer;

public interface IConsumerDao {
    /**
     * 检查用户名是否重复
     * @param username
     * @return
     */
    int checkUsername(String username);

    /**
     * 添加用户信息
     * @param consumer
     */
    void insertConsumer(Consumer consumer);

    /**
     * 检查是否存在该用户
     * @param consumer
     * @return
     */
    Consumer findByUsernameAndPassword(Consumer consumer);
}
