package com.bbs.controller;

import com.bbs.entity.Consumer;
import com.bbs.entity.PrivateMessage;
import com.bbs.service.IPrivateMessageService;
import com.bbs.util.ReturnInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/message")
public class PrivateMessageController {

    @Autowired
    private IPrivateMessageService privateMessageService;

    /**
     * 查找消息
     * @param request
     * @return
     */
    @RequestMapping("/findMessage.do")
    public String findMessage(HttpServletRequest request){
        HttpSession session = request.getSession();
        Consumer consumer = (Consumer) session.getAttribute("consumer");
        Integer consumer_id = 0;
        try {
            consumer_id = consumer.getId();
        } catch (NullPointerException e){
            //未登录跳回到登录界面后查看
            return "/login";
        }
        List<PrivateMessage> messages = privateMessageService.findMessage(consumer_id);
        request.setAttribute("messages",messages);
        return "/message";
    }

    /**
     * 删除单个消息
     * @param message_id
     * @param request
     * @return
     */
    @RequestMapping("/deleteMessageOne.do")
    public String deleteMessageOne(int message_id, HttpServletRequest request){
        ReturnInfo returnInfo = privateMessageService.deleteOne(message_id);
        request.setAttribute("result",returnInfo.getInfo());
        return "forward:/message/findMessage.do";
    }

    /**
     * 删除全部消息
     * @param request
     * @return
     */
    @RequestMapping("/deleteAll.do")
    public String deleteAll(HttpServletRequest request){
        HttpSession session = request.getSession();
        Consumer consumer = (Consumer) session.getAttribute("consumer");
        int consumer_id = consumer.getId();
        ReturnInfo returnInfo = privateMessageService.deleteByConsumerId(consumer_id);
        request.setAttribute("result",returnInfo.getInfo());
        return "forward:/message/findMessage.do";
    }
}
