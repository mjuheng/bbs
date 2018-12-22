package com.bbs.controller;

import com.bbs.entity.Attention;
import com.bbs.entity.Consumer;
import com.bbs.service.IAttentionService;
import com.bbs.service.IConsumerService;
import com.bbs.util.ReturnInfo;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private IConsumerService consumerService;
    @Autowired
    private Producer captchaProducer;
    @Autowired
    private IAttentionService attentionService;

    /**
     * 注册操作
     * @param consumer
     * @param password_confirm
     * @param image
     * @param request
     * @return
     */
    @RequestMapping(value = "/createAccount.do")
    public String login(Consumer consumer, String password_confirm, MultipartFile image,HttpServletRequest request){
        /*判断两次密码是否一致*/
        if (!consumerService.isEqualsPassword(consumer.getPassword(), password_confirm)){
            request.setAttribute("errorPassword","两次密码不一致");
            return "forward:/opt/createAccount.do";
        }
        String imageName = "";       //图片的保存地址
        if(!image.isEmpty() && image.getSize() > 0){
            //获取请求的各项信息
            String contextPath = "/headImage/";
            String originalFilename = image.getOriginalFilename();
            String dirPath = request.getServletContext().getRealPath(contextPath);
            //判断存放的文件夹是否存在，不存在则创建
            File file = new File(dirPath);
            if (!file.exists()){
                file.mkdirs();
            }
            //保存图片操作
            imageName = UUID.randomUUID() + originalFilename;
            try {
                image.transferTo(new File(dirPath + imageName));
            } catch (IOException e) {
                System.out.println("上传失败");
            }
            //拼接图片地址
            imageName = contextPath + imageName;
        }
        //保存信息至数据库
        consumer.setHeadImage(imageName);
        try {
            consumerService.createAccount(consumer);
        } catch (DuplicateKeyException e){
            return "forward:/opt/createAccount.do";
        }
        return "redirect:/opt/login.do";
    }

    /**
     * 检查用户注册时输入的名字，避免重复，保证用户名字的唯一性
     * @param params
     * @return
     */
    @RequestMapping(value = "/checkUsername.do",method = RequestMethod.POST)
    @ResponseBody
    public ReturnInfo checkUsername(@RequestBody Map<String,String> params){
        ReturnInfo returnInfo = new ReturnInfo();
        String username = params.get("username");
        int count = consumerService.checkUsername(username);
        if (count > 0){
            returnInfo.setCode(-1);
            returnInfo.setInfo("用户名已被注册，请重新输入");
        }else {
            returnInfo.setCode(0);
        }
        return returnInfo;

    }


    /**
     * 生成验证码
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/getCapture.do")
    public void getCapture(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");

        //生成验证码文本
        String verify = captchaProducer.createText();
        request.getSession().setAttribute("verify", verify);
        //利用生成的字符串构建图片
        BufferedImage bi = captchaProducer.createImage(verify);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 登录验证
     * @param consumer
     * @param verify
     * @param request
     * @return
     */
    @RequestMapping(value = "/login.do",method = RequestMethod.POST)
    public String login(Consumer consumer, String verify, HttpServletRequest request){
        HttpSession session = request.getSession();
        ReturnInfo returnInfo = new ReturnInfo();
        //检查验证码是否正确
        String verifyRight = (String) session.getAttribute("verify");
        if (verifyRight != null && verifyRight.equals(verify)){
            //验证码正确则进行账号判断
            returnInfo = consumerService.login(consumer);
            session.setAttribute("consumer",returnInfo.getObj());
        }else {
            returnInfo.setCode(-1);
            returnInfo.setInfo("验证码错误");
        }
        //判断结果进行跳转
        if (returnInfo.getCode() == 0){
            return "redirect:/index.jsp";
        }else {
            request.setAttribute("loginError",returnInfo);
            return "forward:/opt/login.do";
        }
    }

    /**
     * 更新信息
     * @param consumer
     * @param request
     * @return
     */
    @RequestMapping("/updateInfo.do")
    public String updateInfo(Consumer consumer, HttpServletRequest request){
        Consumer updateConsumer = (Consumer) request.getSession().getAttribute("consumer");
        int consumer_id = updateConsumer.getId();
        consumer.setId(consumer_id);
        //对数据库信息修改
        ReturnInfo returnInfo = consumerService.updateInfo(consumer);
        request.setAttribute("result",returnInfo.getInfo());
        return "/consumerDetail";
    }

    /**
     * 修改密码
     * @param password
     * @param confirm_password
     * @param request
     * @return
     */
    @RequestMapping("/updatePassword.do")
    public String updatePassword(String password, String confirm_password, HttpServletRequest request){
        Consumer consumer = (Consumer) request.getSession().getAttribute("consumer");
        consumer.setPassword(password);
        ReturnInfo returnInfo = consumerService.updatePassword(consumer, confirm_password);
        request.setAttribute("result",returnInfo.getInfo());
        return "/consumerDetail";
    }

    /**
     * 退出登录
     * @param session
     * @return
     */
    @RequestMapping("/exit.do")
    public String exit(HttpSession session){
        session.removeAttribute("consumer");
        return "/head";
    }

    @RequestMapping("/findBasicInfo.do")
    public String findBasicInfo(int consumer_id, HttpServletRequest request){
        Consumer basicConsumerInfo = consumerService.findBasicInfo(consumer_id);
        //查看两人是否已关注
        Attention attention = new Attention();
        Consumer consumer = (Consumer) request.getSession().getAttribute("consumer");
        if (consumer != null){
            attention.setFromConsumer_id(consumer.getId());
            attention.setToConsumer_id(consumer_id);
            boolean flag = attentionService.checkAttention(attention);
            if (flag){
                request.setAttribute("isAttention",true);
            }
        }
        request.setAttribute("basicConsumerInfo", basicConsumerInfo);
        return "/showDetail";
    }

}
