package com.systop.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.systop.po.Discuss;
import com.systop.service.DiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DiscussController {
    @Autowired
    private DiscussService discussService;

    /**
     * 查询所有
     * @param model
     * @return
     */


    @RequestMapping(value="/discussdelectall/{arr}",method=RequestMethod.POST)
    public @ResponseBody Integer discussdelectall(@PathVariable("arr") List list){
        Integer rows=discussService.discuss_delete(list);
        return rows;
    }

    @RequestMapping(value ="/discussdeletefyid/{discuss_id}", method = RequestMethod.POST)
    public @ResponseBody Integer discussdeletefyid(@PathVariable("discuss_id")Integer discuss_id)throws Exception {
       Integer row=discussService.discuss_deletefyid(discuss_id);
        System.out.println(row);
       return row;
    }
    @RequestMapping("/discussselectall")
    public String list(@RequestParam(value="pn", defaultValue="1")Integer pn,Model model){
        //紧跟查询结果的分页情况（第几页， 每页多少记录）
        PageHelper.startPage(pn,5);
        List<Discuss> dep= discussService.selectall();
        System.out.println(dep+"jilu");
        //骚操作： 将结果放入pageinfo中，这个pageinfo就有很多有用的参数
        PageInfo<Discuss> list=new PageInfo<>(dep,5);
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
        return "discuss-list";   //跳转到success.jsp 页面
    }
    @PostMapping(value = "/discussupdatesta/{discuss_id}/{discuss_state}")
    public @ResponseBody Integer discussupdatesta(@PathVariable("discuss_id")Integer discuss_id,@PathVariable("discuss_state")Integer discuss_state){
        Discuss discuss=new Discuss();
        discuss.setDiscuss_id(discuss_id);
        discuss.setDiscuss_status(discuss_state);
        return discussService.discussupdatesta(discuss);
    }
}


