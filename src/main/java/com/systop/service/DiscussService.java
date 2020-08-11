package com.systop.service;

import com.systop.po.Discuss;

import java.util.List;

public interface DiscussService {
    List<Discuss> selectall();
    Integer discussupdatesta(Discuss discucss);
    Integer discuss_delete(List list);
    Integer discuss_deletefyid(Integer discuss_id);
}
