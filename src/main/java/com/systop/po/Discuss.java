package com.systop.po;

import java.util.Date;

public class Discuss {
    private Integer discuss_id;
    private Integer discuss_user_id;
    private String  discuss_content;
    private Date discuss_date;
    private Integer discuss_music_id;
    private Integer discuss_status;
    private User user;
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getDiscuss_id() {
        return discuss_id;
    }

    public void setDiscuss_id(Integer discuss_id) {
        this.discuss_id = discuss_id;
    }

    public Integer getDiscuss_user_id() {
        return discuss_user_id;
    }

    public void setDiscuss_user_id(Integer discuss_user_id) {
        this.discuss_user_id = discuss_user_id;
    }

    public String getDiscuss_content() {
        return discuss_content;
    }

    public void setDiscuss_content(String discuss_content) {
        this.discuss_content = discuss_content;
    }

    public Date getDiscuss_date() {
        return discuss_date;
    }

    public void setDiscuss_date(Date discuss_date) {
        this.discuss_date = discuss_date;
    }

    public Integer getDiscuss_music_id() {
        return discuss_music_id;
    }

    public void setDiscuss_music_id(Integer discuss_music_id) {
        this.discuss_music_id = discuss_music_id;
    }

    public Integer getDiscuss_status() {
        return discuss_status;
    }

    public void setDiscuss_status(Integer discuss_status) {
        this.discuss_status = discuss_status;
    }
}
