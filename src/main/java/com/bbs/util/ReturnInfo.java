package com.bbs.util;


/**
 * ajax返回信息
 * @author Mr.heng
 */
public class ReturnInfo {

    private int code;       //信息代码
    private String info;    //提示信息
    private Object obj;     //携带的数据


    public ReturnInfo(){
        this.code = 0;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
