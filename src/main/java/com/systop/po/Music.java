package com.systop.po;

import java.util.Date;
public class Music {
    private int music_id;
    private String music_name;
    private String music_image;
    private String music_music;
    private int music_author_id;
    private int music_type;          //1.  2.  3.  4.
    private int music_collect;
    private int music_hot;
    private Date music_date;
    public int getMusic_id() {
        return music_id;
    }

    public void setMusic_id(int music_id) {
        this.music_id = music_id;
    }

    public String getMusic_name() {
        return music_name;
    }

    public void setMusic_name(String music_name) {
        this.music_name = music_name;
    }

    public String getMusic_image() {
        return music_image;
    }

    public void setMusic_image(String music_image) {
        this.music_image = music_image;
    }

    public String getMusic_music() {
        return music_music;
    }

    public void setMusic_music(String music_music) {
        this.music_music = music_music;
    }

    public int getMusic_author_id() {
        return music_author_id;
    }

    public void setMusic_author_id(int music_author_id) {
        this.music_author_id = music_author_id;
    }

    public Date getMusic_date() {
        return music_date;
    }

    public void setMusic_date(Date music_date) {
        this.music_date = music_date;
    }

    public int getMusic_type() {
        return music_type;
    }

    public void setMusic_type(int music_type) {
        this.music_type = music_type;
    }

    public int getMusic_collect() {
        return music_collect;
    }

    public void setMusic_collect(int music_collect) {
        this.music_collect = music_collect;
    }

    public int getMusic_hot() {
        return music_hot;
    }

    public void setMusic_hot(int music_hot) {
        this.music_hot = music_hot;
    }

    @Override
    public String toString() {
        return "Music{" +
                "music_id=" + music_id +
                ", music_name='" + music_name + '\'' +
                ", music_image='" + music_image + '\'' +
                ", music_music='" + music_music + '\'' +
                ", music_author_id=" + music_author_id +
                ", music_type=" + music_type +
                ", music_collect=" + music_collect +
                ", music_hot=" + music_hot +
                ", music_date=" + music_date +
                '}';
    }
}
