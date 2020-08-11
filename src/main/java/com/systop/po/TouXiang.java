package com.systop.po;

import java.util.Date;

public class TouXiang {
    private Integer touxiang_id;
    private String touxiang_image;
    private Integer touxiang_state;
    private Date touxiang_date;

    public Integer getTouxiang_id() {
        return touxiang_id;
    }

    public void setTouxiang_id(Integer touxiang_id) {
        this.touxiang_id = touxiang_id;
    }

    public String getTouxiang_image() {
        return touxiang_image;
    }

    public void setTouxiang_image(String touxiang_image) {
        this.touxiang_image = touxiang_image;
    }



    public Integer getTouxiang_state() {
        return touxiang_state;
    }

    public void setTouxiang_state(Integer touxiang_state) {
        this.touxiang_state = touxiang_state;
    }

    public Date getTouxiang_date() {
        return touxiang_date;
    }

    public void setTouxiang_date(Date touxiang_date) {
        this.touxiang_date = touxiang_date;
    }

    @Override
    public String toString() {
        return "TouXiang{" +
                "touxiang_id=" + touxiang_id +
                ", touxiang_image='" + touxiang_image + '\'' +
                ", touxiang_state=" + touxiang_state +
                ", touxiang_date=" + touxiang_date +
                '}';
    }
}
