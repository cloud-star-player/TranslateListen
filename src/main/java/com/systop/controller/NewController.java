package com.systop.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.systop.po.Author;
import com.systop.po.News;
import com.systop.service.AuthorService;
import com.systop.service.NewsService;
import com.systop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class NewController {
    @Autowired
    private NewsService newsService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private UserService userService;
    /**
     * 查询所有
     * @param
     * @return
     */

   @RequestMapping("tonewsadd")
   public String tonewsadd(Model model){
       List<Author> author=authorService.authorbyid();
       model.addAttribute("authorid",author);
       return "news-add";
   }
    @RequestMapping("/newsadd")
    public@ResponseBody Integer newsadd(News news){
        Integer i = newsService.newsadd(news);
        System.out.println(i);
        if(i>0){
            List<Integer>list=userService.seletcrelation(news.getNews_author_id());
            if(list!=null) {
                Integer row = userService.update_read(list);
            }
        }
        return i;
    }
    @RequestMapping("/newsupdate")
    public@ResponseBody Integer newsupdate(News news){
        Integer o = newsService.newsupdate(news);
        return o;
    }
    @RequestMapping(value="/newsdelectall/{arr}",method=RequestMethod.POST)
    public @ResponseBody Integer newsdelectall(@PathVariable("arr") List list){
        Integer rows=newsService.news_delete(list);
        return rows;
    }

    @RequestMapping(value ="/newsdeletefyid/{news_id}", method = RequestMethod.POST)
    public @ResponseBody Integer newsdeletefyid(@PathVariable("news_id")Integer news_id)throws Exception {
       Integer row=newsService.news_deletefyid(news_id);
       return row;
    }
    @RequestMapping(value ="/newsselect/{news_id}", method = RequestMethod.GET)
    public String userselect(Model model,@PathVariable("news_id")Integer news_id){
        News news=newsService.newsselect(news_id);
        model.addAttribute("news",news);
        List<Author> author=authorService.authorbyid();
        model.addAttribute("authorid",author);
        return "news-update";
    }
    @RequestMapping(value ="/newsselect2/{news_id}", method = RequestMethod.GET)
    public @ResponseBody News newsselect2(@PathVariable("news_id")Integer news_id){
        News news=newsService.newsselect(news_id);
        return news;
    }
    @RequestMapping("/newsselectall")
    public String list(@RequestParam(value="pn", defaultValue="1")Integer pn,Model model){
        //紧跟查询结果的分页情况（第几页， 每页多少记录）
        PageHelper.startPage(pn,5);
        List<News> dep= newsService.selectall();
        System.out.println(dep+"jilu");
        //骚操作： 将结果放入pageinfo中，这个pageinfo就有很多有用的参数
        PageInfo<News> list=new PageInfo<>(dep,5);
   		//new PageInfo<>(dep)单页  连续5分页new PageInfo<>(dep,5);**
        System.out.println("当前页面"+list.getPageNum());
        System.out.println("总页码"+list.getPages());
        System.out.println("总记录数"+list.getTotal());
        System.out.println("当前页有几个记录"+list.getSize());
        System.out.println("当前页的pagesize"+list.getPageSize());
        System.out.println("前一页"+list.getPrePage());
        System.out.println("结果"+list.getList());
        int[] nums=list.getNavigatepageNums();
        List<Author>list2=authorService.authorbyid();
        model.addAttribute("list", list);
        model.addAttribute("author",list2);
        return "news-list";   //跳转到success.jsp 页面
    }
    @PostMapping(value = "/newsupdatesta/{news_id}/{news_state}")
    public @ResponseBody Integer newsupdatesta(@PathVariable("news_id")Integer news_id,@PathVariable("news_state")Integer news_state){
        News news=new News();
        news.setNews_id(news_id);
        news.setNews_state(news_state);
        return newsService.newupdatesta(news);
    }
}


