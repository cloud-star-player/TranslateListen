package com.systop.po;

import java.util.Date;

public class Banner {
    public Integer banner_id;
    public Integer banner_weizhi;
    public String banner_image;
    public String banner_name;
    public Date banner_date;
    public Integer banner_state;
    public Integer getBanner_id() {
        return banner_id;
    }

    public void setBanner_id(Integer banner_id) {
        this.banner_id = banner_id;
    }

    public Integer getBanner_weizhi() {
        return banner_weizhi;
    }

    public void setBanner_weizhi(Integer banner_weizhi) {
        this.banner_weizhi = banner_weizhi;
    }

    public String getBanner_image() {
        return banner_image;
    }

    public void setBanner_image(String banner_image) {
        this.banner_image = banner_image;
    }

    public String getBanner_name() {
        return banner_name;
    }

    public void setBanner_name(String banner_name) {
        this.banner_name = banner_name;
    }

    public Date getBanner_date() {
        return banner_date;
    }

    public void setBanner_date(Date banner_date) {
        this.banner_date = banner_date;
    }

    public Integer getBanner_state() {
        return banner_state;
    }

    public void setBanner_state(Integer banner_state) {
        this.banner_state = banner_state;
    }
}
