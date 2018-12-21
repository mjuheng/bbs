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

    /**
     * 更新用户的信息
     * @param consumer
     * @return
     */
    int updateInfo(Consumer consumer);

    /**
     * 修改用户密码
     * @param consumer
     * @return
     */
    int updatePassword(Consumer consumer);
}
