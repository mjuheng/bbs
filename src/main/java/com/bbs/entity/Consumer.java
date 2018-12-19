package com.bbs.entity;

import java.io.Serializable;

public class Consumer implements Serializable {

    private Integer id;             //唯一标识
    private String username;        //名字（唯一）
    private String password;        //密码
    private String headImage;       //头像图片地址
    private String email;           //账号邮箱

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", headImage='" + headImage + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
