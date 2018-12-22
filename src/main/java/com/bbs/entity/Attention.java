package com.bbs.entity;

public class Attention {
    private Integer id;
    private Integer fromConsumer_id;
    private Integer toConsumer_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFromConsumer_id() {
        return fromConsumer_id;
    }

    public void setFromConsumer_id(Integer fromConsumer_id) {
        this.fromConsumer_id = fromConsumer_id;
    }

    public Integer getToConsumer_id() {
        return toConsumer_id;
    }

    public void setToConsumer_id(Integer toConsumer_id) {
        this.toConsumer_id = toConsumer_id;
    }
}
