package com.systop.service;

import com.systop.po.Reply;

import java.util.List;

public interface ReplyService {
    List<Reply> selectall();
    Integer reply_delete(List list);
    Integer reply_deletefyid(Integer reply_id);
}
