package com.systop.dao;

import com.systop.po.TouXiang;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TouXiangMapper {
    Integer touxiangadd(TouXiang touxiang);
    List<TouXiang> touxiangall();
    TouXiang touxiangselectid(@Param("touxiang_id")Integer touxiang_id);
    Integer update_touxiang(TouXiang touxiang);
    Integer touxiang_delete(List list);
    Integer touxiang_deletefyid(Integer touxiang_id);
    Integer touxiangupdatesta(TouXiang touxiang);
}
