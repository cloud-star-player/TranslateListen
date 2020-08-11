package com.systop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Lhref {
    @RequestMapping("/towelcome")
    public String towelcome(){
        return "welcome";
    }
    @RequestMapping("/toadminrole")
    public String toadminrole(){
        return "admin-role";
    }
    @RequestMapping("/toadmincate")
    public String toadmincate(){
        return "admin-cate";
    }
    @RequestMapping("/toadminlist")
    public String toadminlist(){
        return "admin-list";
    }

}
