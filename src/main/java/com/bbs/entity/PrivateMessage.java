package com.bbs.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PrivateMessage {
    private Integer id;
    private String content;
    private boolean watch;
    private Date sendTime;
    private Integer fromConsumer_id;
    private Integer consumer_id;
    private Integer post_id;
    private Consumer fromConsumer;
    private Post post;
    private Consumer consumer;
    private String formatSendTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isWatch() {
        return watch;
    }

    public void setWatch(boolean watch) {
        this.watch = watch;
    }

    public Integer getFromConsumer_id() {
        return fromConsumer_id;
    }

    public void setFromConsumer_id(Integer fromConsumer_id) {
        this.fromConsumer_id = fromConsumer_id;
    }

    public Consumer getFromConsumer() {
        return fromConsumer;
    }

    public void setFromConsumer(Consumer fromConsumer) {
        this.fromConsumer = fromConsumer;
    }

    public Integer getConsumer_id() {
        return consumer_id;
    }

    public void setConsumer_id(Integer consumer_id) {
        this.consumer_id = consumer_id;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public Integer getPost_id() {
        return post_id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getFormatSendTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(this.sendTime);
    }
}
