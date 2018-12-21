package com.bbs.comtroller;

import com.bbs.entity.Consumer;
import com.bbs.entity.Postbody;
import com.bbs.service.IPostService;
import com.bbs.service.IPostbodyService;
import com.bbs.service.impl.PostService;
import com.bbs.util.ReturnInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/postbody")
public class PostbodyController {

    @Autowired
    private IPostbodyService postbodyService;

    /**
     * 查看单个帖子的详细信息
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("/findPostbody/{id}.do")
    public String findPostbody(@PathVariable Integer id, HttpServletRequest request){
        List<Postbody> postbodys = postbodyService.findPostbody(id);
        request.setAttribute("postbodys",postbodys);
        return "/postbody";
    }

    /**
     * 发送评论信息
     * @param postbody
     * @param request
     * @return
     */
    @RequestMapping("/writingDiscuss.do")
    public String writingDiscuss(Postbody postbody,HttpServletRequest request){
        HttpSession session = request.getSession();
        //加载各项数据
        Consumer consumer = (Consumer) session.getAttribute("consumer");
        postbody.setConsumer_id(consumer.getId());
        postbody.setReplyTime(new Date());

        ReturnInfo returnInfo = postbodyService.writingDiscuss(postbody);
        if (returnInfo.getCode() == 0){
            request.setAttribute("writingResult","评论成功");
        }else {
            request.setAttribute("writingResult","评论失败");
        }
        return "forward:/postbody/findPostbody/" + postbody.getPost_id() + ".do";
    }

    /**
     * 采纳评论
     * @return
     */
    @RequestMapping("/makeAdopt.do")
    public String makeAdopt(Integer post_id, Integer postbody_id, HttpServletRequest request){
        ReturnInfo returnInfo = postbodyService.makeAdopt(post_id, postbody_id);
        request.setAttribute("result",returnInfo);
        return "forward:/postbody/findPostbody/" + post_id + ".do";
    }

    /**
     * 删除评论
     * @param postbody_id
     * @return
     */
    @RequestMapping("/deletePost.do")
    public String deletePost(Integer post_id, Integer postbody_id, HttpServletRequest request){
        ReturnInfo returnInfo = postbodyService.deleteById(post_id, postbody_id);
        request.setAttribute("result",returnInfo);
        return "forward:/postbody/findPostbody/" + post_id + ".do";
    }
}
