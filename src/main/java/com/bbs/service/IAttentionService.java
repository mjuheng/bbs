package com.bbs.service;

import com.bbs.entity.Attention;
import com.bbs.util.ReturnInfo;

public interface IAttentionService {

    /**
     * 关注用户
     * @param attention
     * @return
     */
    ReturnInfo makeAttention(Attention attention);

    /**
     * 查看是否已关注
     * @param attention
     * @return
     */
    boolean checkAttention(Attention attention);

    /**
     * 取消关注
     * @param attention
     * @return
     */
    ReturnInfo deleteAttention(Attention attention);

}
