package com.bbs.controller;

import com.bbs.entity.Attention;
import com.bbs.entity.Consumer;
import com.bbs.service.IAttentionService;
import com.bbs.util.ReturnInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/attention")
public class AttentionController {

    @Autowired
    private IAttentionService attentionService;

    /**
     * 添加关注
     * @param attention
     * @param session
     * @return
     */
    @RequestMapping("/makeAttention.do")
    @ResponseBody
    public ReturnInfo makeAttention(@RequestBody Attention attention, HttpSession session){
        ReturnInfo returnInfo = new ReturnInfo();
        //设置基本信息
        Consumer consumer = (Consumer) session.getAttribute("consumer");
        Integer fromConsumer_id = consumer.getId();
        attention.setFromConsumer_id(fromConsumer_id);
        //存入数据库
        returnInfo = attentionService.makeAttention(attention);
        return returnInfo;
    }

    /**
     * 取消关注
     * @param attention
     * @param session
     * @return
     */
    @RequestMapping("/deleteAttention.do")
    @ResponseBody
    public ReturnInfo deleteAttention(@RequestBody Attention attention, HttpSession session){
        Consumer consumer = (Consumer) session.getAttribute("consumer");
        int fromConsumer_id = consumer.getId();
        attention.setFromConsumer_id(fromConsumer_id);
        ReturnInfo returnInfo = attentionService.deleteAttention(attention);
        return returnInfo;
    }
}
