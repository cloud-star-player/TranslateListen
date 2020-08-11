package com.systop.service;

import com.systop.po.Admin;


import java.util.List;


public interface AdminService {
   public Admin login(String admin_code,String admin_password);
   public List<Admin> selectall();
}
