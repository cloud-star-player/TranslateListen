package com.systop.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.systop.po.User;
import com.systop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 查询所有
     * @param model
     * @return
     */
//    @RequestMapping("/userselectall")
//    public String userselectall(Model model){
//        List<User> list=userService.selectall();
//        model.addAttribute("list",list);
//        return "member-list";
//    }

    /**
     * 更新前的检查
     * @param model
     * @param user_id
     * @return
     */
    @RequestMapping(value ="/userselect/{user_id}", method = RequestMethod.GET)
    public String userselect(Model model,@PathVariable("user_id")Integer user_id){
        User user=userService.select(user_id);
        model.addAttribute("user",user);
        return "member-password";
    }

    /**
     * 更新
     * @param user
     * @return
     */
    @RequestMapping(value="/userupdate",method=RequestMethod.POST)
    public @ResponseBody int userupdate(@RequestBody User user){
        Integer row=userService.update_user(user);
        return row;
    }


    @RequestMapping(value="/userdelectall/{arr}",method=RequestMethod.POST)
    public @ResponseBody Integer userdelectall(@PathVariable("arr") List list){
        Integer rows=userService.user_delete(list);
        return rows;
    }

    @RequestMapping(value ="/userdeletefyid/{user_id}", method = RequestMethod.POST)
    public @ResponseBody Integer userdeletefyid(@PathVariable("user_id")Integer user_id)throws Exception {
       Integer row=userService.user_deletefyid(user_id);
        System.out.println(row);
       return row;
    }
    @RequestMapping("/userselectall")
    public String list(@RequestParam(value="pn", defaultValue="1")Integer pn,Model model){
        //紧跟查询结果的分页情况（第几页， 每页多少记录）
        PageHelper.startPage(pn,5);
        List<User> dep= userService.selectall();
        System.out.println(dep+"jilu");
        //骚操作： 将结果放入pageinfo中，这个pageinfo就有很多有用的参数
        PageInfo<User> list=new PageInfo<>(dep,5);
   		//new PageInfo<>(dep)单页  连续5分页new PageInfo<>(dep,5);**
        System.out.println("当前页面"+list.getPageNum());
        System.out.println("总页码"+list.getPages());
        System.out.println("总记录数"+list.getTotal());
        System.out.println("当前页有几个记录"+list.getSize());
        System.out.println("当前页的pagesize"+list.getPageSize());
        System.out.println("前一页"+list.getPrePage());
        System.out.println("结果"+list.getList());
        int[] nums=list.getNavigatepageNums();
        model.addAttribute("list", list);
        return "member-list";   //跳转到success.jsp 页面
    }


}


