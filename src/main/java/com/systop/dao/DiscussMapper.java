package com.systop.dao;

import com.systop.po.Discuss;

import java.util.List;

public interface DiscussMapper {
        List<Discuss> selectall();
        Integer discussupdatesta(Discuss discucss);
        Integer discuss_delete(List list);
        Integer discuss_deletefyid(Integer discuss_id);
}
