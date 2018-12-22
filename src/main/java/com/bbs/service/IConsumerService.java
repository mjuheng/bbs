package com.bbs.service;


import com.bbs.entity.Consumer;
import com.bbs.util.ReturnInfo;

public interface IConsumerService {
    /**
     * 检查注册的用户名，保证唯一性
     * @param username
     * @return 数据库中该用户名存在的个数
     */
    int checkUsername(String username);

    /**
     * 检查两次密码是否相等
     * @param password
     * @param password_confirm
     * @return
     */
    boolean isEqualsPassword(String password, String password_confirm);

    /**
     * 注册操作
     * @param consumer
     */
    void createAccount(Consumer consumer);

    /**
     * 登录验证
     * @param consumer
     * @return
     */
    ReturnInfo login(Consumer consumer);

    /**
     * 更新用户信息
     * @param consumer
     * @return
     */
    ReturnInfo updateInfo(Consumer consumer);

    /**
     * 修改用户密码
     * @param consumer
     * @param confirm_password
     * @return
     */
    ReturnInfo updatePassword(Consumer consumer, String confirm_password);

    Consumer findBasicInfo(int consumer_id);
}
