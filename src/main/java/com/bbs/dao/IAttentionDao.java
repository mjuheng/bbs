package com.bbs.dao;

import com.bbs.entity.Attention;

import java.util.List;

public interface IAttentionDao {
    /**
     * 添加关注
     * @param attention
     * @return
     */
    int insertAttention(Attention attention);

    /**
     * 查看是否已关注
     * @param attention
     * @return
     */
    int checkAttention(Attention attention);

    /**
     * 取消关注
     * @param attention
     * @return
     */
    int deleteAttention(Attention attention);

    /**
     * 查看所有关注此人的用户
     * @param toConsumer_id
     * @return
     */
    List<Integer> findAttention(int toConsumer_id);
}
