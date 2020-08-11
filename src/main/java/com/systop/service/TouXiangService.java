package com.systop.service;

import com.systop.po.Banner;
import com.systop.po.TouXiang;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TouXiangService {
    Integer touxiangadd(TouXiang touxiang);
    List<TouXiang> touxiangall();
    TouXiang touxiangselectid(Integer touxiang_id);
    Integer update_touxiang(TouXiang touxiang);
    Integer touxiang_delete(List list);
    Integer touxiang_deletefyid(Integer touxiang_id);
    Integer touxiangupdatesta(TouXiang touxiang);
}
