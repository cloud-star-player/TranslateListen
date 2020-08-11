package com.systop.dao;

import com.systop.po.Reply;

import java.util.List;

public interface ReplyMapper {
        List<Reply> selectall();
        Integer reply_delete(List list);
        Integer reply_deletefyid(Integer reply_id);
}
