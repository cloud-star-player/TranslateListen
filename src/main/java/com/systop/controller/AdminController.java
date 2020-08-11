package com.systop.controller;


import com.systop.po.Admin;
import com.systop.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/tologin")
    public String sayHi() {
        return "login";
    }

    @RequestMapping(value = "/user/{admin_code}/{admin_password}", method = RequestMethod.GET)
    public @ResponseBody
    Integer selectUser(@PathVariable("admin_code") String admin_code, @PathVariable("admin_password") String admin_password) throws Exception {
        Admin a = adminService.login(admin_code, admin_password);
        int b = 1;
        System.out.println(a);
        if (a != null) {
            b = 1;
        } else {
            b = 0;
        }
        System.out.println(b);
        return b;
    }

    @RequestMapping("/toindex")
    public String toindex() {
        return "index";
    }

    @RequestMapping("/selectall")
    public String selectall(Model model) {
        List<Admin> list = adminService.selectall();
        model.addAttribute("list", list);
        return "admin-list";
    }

}