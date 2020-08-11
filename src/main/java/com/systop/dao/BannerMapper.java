package com.systop.dao;

import com.systop.po.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerMapper {
    Integer banneradd(Banner banner);
    List<Banner> bannerall();
    Banner bannerselectid(@Param("banner_id")Integer banner_id);
    Integer update_banner(Banner banner);
    Integer banner_delete(List list);
    Integer banner_deletefyid(Integer banner_id);
    Banner bannerweizhi(Integer banner_weizhi);
    Integer bannerupdatesta(Banner banner);
}
