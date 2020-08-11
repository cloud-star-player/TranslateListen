package com.systop.service;

import com.systop.po.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsService {
//    public News login(String news_code,String news_Password);
    public List<News> selectall();
    public Integer news_delete(List list);
    public Integer news_deletefyid(Integer news_id);
    public Integer newupdatesta(News news);
    public Integer newsadd(News news);
    public News newsselect(Integer news_id);
    public Integer newsupdate(News news);
}
