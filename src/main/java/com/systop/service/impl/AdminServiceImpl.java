package com.systop.service.impl;

import com.systop.dao.AdminMapper;
import com.systop.po.Admin;
import com.systop.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(String admin_code, String admin_password) {
        Admin admin=adminMapper.login(admin_code,admin_password);
        return admin;
    }

    @Override
    public List<Admin> selectall() {
        List list= (List) adminMapper.selectall();
        return list;
    }
}
