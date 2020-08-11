package com.systop.service.impl;

import com.systop.dao.TouXiangMapper;
import com.systop.po.TouXiang;
import com.systop.service.TouXiangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TouXiangServiceImpl implements TouXiangService {
    @Autowired
    private TouXiangMapper touxiangMapper;
    @Override
    public Integer touxiangadd(TouXiang touxiang) {
        return touxiangMapper.touxiangadd(touxiang);
    }

    @Override
    public List<TouXiang> touxiangall() {
        return touxiangMapper.touxiangall();
    }

    @Override
    public TouXiang touxiangselectid(Integer touxiang_id) {
        return touxiangMapper.touxiangselectid(touxiang_id);
    }

    @Override
    public Integer update_touxiang(TouXiang touxiang) {
        return touxiangMapper.update_touxiang(touxiang);
    }

    @Override
    public Integer touxiang_delete(List list) {
        return touxiangMapper.touxiang_delete(list);
    }

    @Override
    public Integer touxiang_deletefyid(Integer touxiang_id) {
        return touxiangMapper.touxiang_deletefyid(touxiang_id);
    }

    @Override
    public Integer touxiangupdatesta(TouXiang touxiang) {
        return touxiangMapper.touxiangupdatesta(touxiang);
    }
}
