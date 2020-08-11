package com.systop.service.impl;


import com.systop.dao.CommentMapper;
import com.systop.dao.DiscussMapper;
import com.systop.po.Comment;
import com.systop.po.Discuss;
import com.systop.service.CommentService;
import com.systop.service.DiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DicussServiceImpl implements DiscussService {
    @Autowired
    private DiscussMapper discussMapper;


    @Override
    public List<Discuss> selectall() {
        return discussMapper.selectall();
    }

    @Override
    public Integer discussupdatesta(Discuss discuss) {
        return discussMapper.discussupdatesta(discuss);
    }

    @Override
    public Integer discuss_delete(List list) {
        return discussMapper.discuss_delete(list);
    }

    @Override
    public Integer discuss_deletefyid(Integer discuss_id) {
        return discussMapper.discuss_deletefyid(discuss_id);
    }
}
