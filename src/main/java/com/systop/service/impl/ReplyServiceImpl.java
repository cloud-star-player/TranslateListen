package com.systop.service.impl;


import com.systop.dao.ReplyMapper;
import com.systop.po.Reply;
import com.systop.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    private ReplyMapper replyMapper;


    @Override
    public List<Reply> selectall() {
        return replyMapper.selectall();
    }


    @Override
    public Integer reply_delete(List list) {
        return replyMapper.reply_delete(list);
    }

    @Override
    public Integer reply_deletefyid(Integer reply_id) {
        return replyMapper.reply_deletefyid(reply_id);
    }
}
