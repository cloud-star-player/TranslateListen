package com.systop.service;

import com.systop.po.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerService {
    public Integer banneradd(Banner banner);
    public List<Banner> bannerall();
    public Banner bannerselectid(Integer banner_id);
    public Integer update_banner(Banner banner);
    public Integer banner_delete(List list);
    public Integer banner_deletefyid(Integer banner_id);
    public Banner bannerweizhi(Integer banner_weizhi);
    public Integer bannerupdatesta(Banner banner);
}
