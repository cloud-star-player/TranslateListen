package com.systop.dao;

import com.systop.po.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsMapper {
//    News login(@Param("news_code") String news_code, @Param("news_password") String news_Password);
    List<News> selectall();
    News newsselect(@Param("news_id") Integer news_id);
    Integer news_delete(List list);
    Integer news_deletefyid(@Param("news_id")Integer news_id);
    Integer newsupdatesta(News news);
    Integer newsadd(News news);
    Integer newsupdate(News news);
}
