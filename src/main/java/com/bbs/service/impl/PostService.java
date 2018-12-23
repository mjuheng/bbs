package com.bbs.service.impl;

import com.bbs.dao.*;
import com.bbs.entity.Consumer;
import com.bbs.entity.Post;
import com.bbs.entity.Postbody;
import com.bbs.entity.PrivateMessage;
import com.bbs.entity.custom.WritingPostCustom;
import com.bbs.service.IPostService;
import com.bbs.util.ReturnInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PostService implements IPostService {

    @Autowired
    private ICategoryDao categoryDao;
    @Autowired
    private IPostDao postDao;
    @Autowired
    private IPostbodyDao postbodyDao;
    @Autowired
    private IAttentionDao attentionDao;
    @Autowired
    private IPrivateMessageDao privateMessageDao;

    @Override
    public List<Post> findByCategory(String category) {
        Integer category_id = categoryDao.findIdByName(category);
        return postDao.findByCategory(category_id);
    }

    @Override
    public List<Post> findPostPeak() {
        return postDao.findPostPeak();
    }

    @Override
    public List<Post> findAll() {
        return postDao.findAll();
    }

    @Override
    public List<Post> findByConsumerId(int consumer_id) {
        return postDao.findByConsumerId(consumer_id);
    }

    @Override
    public int findCountByConsumerId(int consumer_id) {
        return postDao.findCountByConsumerId(consumer_id);
    }

    @Override
    public ReturnInfo makePeak(int post_id) {
        ReturnInfo returnInfo = new ReturnInfo();
        returnInfo.setInfo("置顶成功");
        //如果置顶帖子数总数超过3，则不能置顶（最大置顶数3）
        int peakNum = postDao.findPeakCount();
        if (peakNum < 3){
            //将帖子设置为置顶状态
            int row = postDao.makePeakById(post_id);
            if (row == 0){
                returnInfo.setCode(-1);
                returnInfo.setInfo("置顶失败");
            }
        } else {
            returnInfo.setCode(-1);
            returnInfo.setInfo("指定总数不能超过三，置顶失败");
        }
        return returnInfo;
    }

    @Override
    public ReturnInfo removePeak(int post_id) {
        ReturnInfo returnInfo = new ReturnInfo();
        returnInfo.setInfo("置顶已取消");
        int row = postDao.removePeak(post_id);
        if (row == 0){
            returnInfo.setCode(-1);
            returnInfo.setInfo("取消失败");
        }
        return returnInfo;
    }

    @Override
    public ReturnInfo deletePost(int post_id) {
        ReturnInfo returnInfo = new ReturnInfo();
        returnInfo.setInfo("删除成功");
        int row = postDao.deleteById(post_id);
        if (row == 0){
            returnInfo.setCode(-1);
            returnInfo.setInfo("删除失败");
        }
        return returnInfo;
    }

    @Override
    public List<Post> findPostByTitle(String title) {
        return postDao.findPostByTitle(title);
    }

    @Override
    public ReturnInfo writingPost(WritingPostCustom writingPostCustom) {
        ReturnInfo returnInfo = new ReturnInfo();
        Post post = new Post();
        Postbody postbody = new Postbody();
        //查询分类的id
        Integer category_id = categoryDao.findIdByName(writingPostCustom.getCategory());
        /*写入数据库*/
        Date date = new Date();
        //写入post
        post.setTitle(writingPostCustom.getTitle());
        post.setFirstTime(date);
        post.setLastTime(date);
        post.setCategory_id(category_id);
        post.setConsumer_id(writingPostCustom.getConsumer_id());
        postDao.insertPost(post);
        //写入postbody
        postbody.setContent(writingPostCustom.getContent());
        postbody.setConsumer_id(writingPostCustom.getConsumer_id());
        postbody.setRank(1);
        postbody.setReplyTime(date);
        postbody.setPost_id(post.getId());
        postbodyDao.insertPostbody(postbody);
        //发帖时发送通知
        sendMessage(writingPostCustom.getConsumer_id(),post.getId());
        return returnInfo;
    }

    private void sendMessage(int consumer_id, int post_id){
        List<Integer> attention = attentionDao.findAttention(consumer_id);
        PrivateMessage message = new PrivateMessage();

        //分装参数
        message.setFromConsumer_id(consumer_id);
        message.setContent("发表了新帖");
        message.setSendTime(new Date());
        message.setPost_id(post_id);
        //添加数据库
        for (Integer i: attention){
            message.setConsumer_id(i);
            privateMessageDao.insertMessage(message);
        }


    }
}
