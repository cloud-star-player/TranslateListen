package com.systop.dao;

import com.systop.po.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
    Admin login(@Param("admin_code") String admin_code, @Param("admin_password") String admin_Password);
//    Integer upda(@Param("admin_code") String admin_code, @Param("admin_password") String admin_Password);
    List<Admin> selectall();
}