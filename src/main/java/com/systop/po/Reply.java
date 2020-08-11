package com.systop.po;

import java.util.Date;

public class Reply {
    private Integer reply_id;
    private Integer reply_user_id;
    private Integer reply_dis_user_id;
    private String  reply_content;
    private Date reply_date;
    private Integer reply_status;
    private User user;

    public Integer getReply_dis_user_id() {
        return reply_dis_user_id;
    }

    public void setReply_dis_user_id(Integer reply_dis_user_id) {
        this.reply_dis_user_id = reply_dis_user_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getReply_id() {
        return reply_id;
    }

    public void setReply_id(Integer reply_id) {
        this.reply_id = reply_id;
    }

    public Integer getReply_user_id() {
        return reply_user_id;
    }

    public void setReply_user_id(Integer reply_user_id) {
        this.reply_user_id = reply_user_id;
    }

    public String getReply_content() {
        return reply_content;
    }

    public void setReply_content(String reply_content) {
        this.reply_content = reply_content;
    }

    public Date getReply_date() {
        return reply_date;
    }

    public void setReply_date(Date reply_date) {
        this.reply_date = reply_date;
    }


    public Integer getReply_status() {
        return reply_status;
    }

    public void setReply_status(Integer reply_status) {
        this.reply_status = reply_status;
    }
}
