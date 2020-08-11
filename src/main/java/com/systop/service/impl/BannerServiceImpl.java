package com.systop.service.impl;

import com.systop.dao.BannerMapper;
import com.systop.po.Banner;
import com.systop.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerMapper bannerMapper;
    @Override
    public Integer banneradd(Banner banner) {
        return bannerMapper.banneradd(banner);
    }

    @Override
    public List<Banner> bannerall() {
        return bannerMapper.bannerall();
    }

    @Override
    public Banner bannerselectid(Integer banner_id) {
        return bannerMapper.bannerselectid(banner_id);
    }

    @Override
    public Integer update_banner(Banner banner) {
        return bannerMapper.update_banner(banner);
    }

    @Override
    public Integer banner_delete(List list) {
        return bannerMapper.banner_delete(list);
    }

    @Override
    public Integer banner_deletefyid(Integer banner_id) {
        return bannerMapper.banner_deletefyid(banner_id);
    }

    @Override
    public Banner bannerweizhi(Integer banner_weizhi) {
        return bannerMapper.bannerweizhi(banner_weizhi);
    }

    @Override
    public Integer bannerupdatesta(Banner banner) {
        return bannerMapper.bannerupdatesta(banner);
    }
}
