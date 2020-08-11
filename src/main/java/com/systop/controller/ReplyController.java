package com.systop.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.systop.po.Reply;
import com.systop.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    /**
     * 查询所有
     * @param model
     * @return
     */


    @RequestMapping(value="/replydelectall/{arr}",method=RequestMethod.POST)
    public @ResponseBody Integer replydelectall(@PathVariable("arr") List list){
        Integer rows=replyService.reply_delete(list);
        return rows;
    }

    @RequestMapping(value ="/replydeletefyid/{reply_id}", method = RequestMethod.POST)
    public @ResponseBody Integer replydeletefyid(@PathVariable("reply_id")Integer reply_id)throws Exception {
       Integer row=replyService.reply_deletefyid(reply_id);
        System.out.println(row);
       return row;
    }
    @RequestMapping("/replyselectall")
    public String list(@RequestParam(value="pn", defaultValue="1")Integer pn,Model model){
        //紧跟查询结果的分页情况（第几页， 每页多少记录）
        PageHelper.startPage(pn,5);
        List<Reply> dep= replyService.selectall();
        System.out.println(dep+"jilu");
        //骚操作： 将结果放入pageinfo中，这个pageinfo就有很多有用的参数
        PageInfo<Reply> list=new PageInfo<>(dep,5);
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
        return "reply-list";   //跳转到success.jsp 页面
    }
}


