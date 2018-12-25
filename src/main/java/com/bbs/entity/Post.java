package com.bbs.entity;

import com.bbs.util.Page;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Post {
    private Integer id;         //唯一标识
    private String title;       //标题
    private Date firstTime;     //发帖时间
    private Date lastTime;      //最后回复时间
    private Boolean resolve;    //是否解决
    private Boolean peak;       //是否置顶
    private Integer watchNum;   //浏览数
    private Integer replyNum;   //回复数量
    private Integer category_id;
    private Integer consumer_id;
    private Consumer consumer;
    private Category category;
    private String formatLastTime;
    public Post(){
        this.resolve = false;
        this.peak = false;
        this.replyNum = 0;
    }

    public Integer getConsumer_id() {
        return consumer_id;
    }

    public void setConsumer_id(Integer consumer_id) {
        this.consumer_id = consumer_id;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFormatLastTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(this.lastTime);
    }
    public String getFormatFirstTime(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(this.firstTime);
    }

    public Integer getWatchNum() {
        return watchNum;
    }

    public void setWatchNum(Integer watchNum) {
        this.watchNum = watchNum;
    }

    public Date getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(Date firstTime) {
        this.firstTime = firstTime;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public Boolean getResolve() {
        return resolve;
    }

    public void setResolve(Boolean resolve) {
        this.resolve = resolve;
    }

    public Boolean getPeak() {
        return peak;
    }

    public void setPeak(Boolean peak) {
        this.peak = peak;
    }

    public Integer getReplyNum() {
        return replyNum;
    }

    public void setReplyNum(Integer replyNum) {
        this.replyNum = replyNum;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setFormatLastTime(String formatLastTime) {
        this.formatLastTime = formatLastTime;
    }


}
