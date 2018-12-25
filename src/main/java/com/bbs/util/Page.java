package com.bbs.util;

import com.bbs.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Page {


    private int pageNow;    //当前页面
    private int pageTotal;  //全部页面
    private int numEach;    //每页个数
    private int startPosition;  //起始位置


    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        if (pageNow < 0){
            this.pageNow = 0;
        }else if (pageNow > pageTotal){
            this.pageNow = pageTotal;
        }else {
            this.pageNow = pageNow;
        }
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
    }


    public int getNumEach() {
        return numEach;
    }

    public void setNumEach(int numEach) {
        this.numEach = numEach;
    }

    public int getStartPosition() {
        return pageNow * numEach;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }
}
