package com.bbs.service.impl;

import com.bbs.dao.IConsumerDao;
import com.bbs.entity.Consumer;
import com.bbs.service.IConsumerService;
import com.bbs.util.ReturnInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService implements IConsumerService {

    @Autowired
    private IConsumerDao consumerDao;

    @Override
    public ReturnInfo login(Consumer consumer) {
        ReturnInfo returnInfo = new ReturnInfo();
        Consumer c = consumerDao.findByUsernameAndPassword(consumer);
        //如果为空，则表示没有对应的账号，用户名或者密码错误
        if (c == null){
            returnInfo.setCode(-1);
            returnInfo.setInfo("账号或者密码错误");
        }else {
            returnInfo.setObj(c);
        }
        return returnInfo;
    }

    /**
     * 注册
     * @param consumer
     * @throws DuplicateKeyException    用户名存在，抛出
     */
    @Override
    public void createAccount(Consumer consumer) throws DuplicateKeyException{
        consumerDao.insertConsumer(consumer);
    }

    @Override
    public boolean isEqualsPassword(String password, String password_confirm) {
        boolean result = false;
        if (password != null && password.equals(password_confirm)){
            result = true;
        }
        return result;

    }

    @Override
    public int checkUsername(String username) {
        int count = consumerDao.checkUsername(username);
        return count;
    }
}
