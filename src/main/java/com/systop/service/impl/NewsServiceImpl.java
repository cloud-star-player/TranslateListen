package com.systop.service.impl;


import com.systop.dao.NewsMapper;
import com.systop.po.News;
import com.systop.service.NewsService;
import com.systop.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper newsMapper;


    @Override
    public List<News> selectall() {
        return newsMapper.selectall();
    }

    @Override
    public Integer news_delete(List list) {
        return newsMapper.news_delete(list);
    }

    @Override
    public Integer news_deletefyid(Integer news_id) {
        return newsMapper.news_deletefyid(news_id);
    }

    @Override
    public Integer newupdatesta(News news) {
        return newsMapper.newsupdatesta(news);
    }
    @Override
    public Integer newsadd(News news) {
        return newsMapper.newsadd(news);
    }

    @Override
    public News newsselect(Integer news_id) {
        return newsMapper.newsselect(news_id);
    }

    @Override
    public Integer newsupdate(News news) {
        return newsMapper.newsupdate(news);
    }
}
