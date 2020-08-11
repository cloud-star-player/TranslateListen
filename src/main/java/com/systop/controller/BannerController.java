package com.systop.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.systop.po.Banner;
import com.systop.po.Banner;
import com.systop.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

@Controller
public class BannerController {
    @Autowired
    private BannerService bannerService;
    @RequestMapping("/bannerall")
    public String list(@RequestParam(value="pn", defaultValue="1")Integer pn, Model model){
        //紧跟查询结果的分页情况（第几页， 每页多少记录）
        PageHelper.startPage(pn,5);
        List<Banner> dep= bannerService.bannerall();
        System.out.println(dep+"jilu");
        //骚操作： 将结果放入pageinfo中，这个pageinfo就有很多有用的参数
        PageInfo<Banner> list=new PageInfo<>(dep,5);
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
        return "banner-list";   //跳转到success.jsp 页面
    }
    @RequestMapping("/tobanneradd")
    public String tobanneradd(){
        return "banner-add";
    }
    @RequestMapping("/tobannerupdate")
    public String tobannerupdate(){
        return "banner-update";
    }
    @RequestMapping("/huanchong2")
    public String huanchong(){
        return "huanchong2";
    }
    @RequestMapping(value="/Bannerupload",method = RequestMethod.POST)
    public @ResponseBody
    ModelAndView upload(ModelAndView model, String banner_name, int banner_weizhi, @RequestParam(value="banner_image",required=false) MultipartFile banner_image, HttpServletRequest request) {
        //文件的原始名称
        String originalBanner_image = banner_image.getOriginalFilename();
        System.out.println(originalBanner_image);
        //新建file文件
        String filePath1 = "D:\\upload/banner";
        File filepath1 = new File(filePath1);
        if(!filepath1.exists()) {
            filepath1.mkdirs();
        }
        String newBanner_image= UUID.randomUUID() + originalBanner_image;
        System.out.println(newBanner_image);
        //生成新的名字
        try {
            //使用MultipartFile类transferTo方法上传参数是个文件filepath+newFileName==/upload/xxx_1.txt
            File targetFile1 = new File(filePath1, newBanner_image);
            banner_image.transferTo(targetFile1);
            Banner M=new Banner();
            M.setBanner_weizhi(banner_weizhi);
            M.setBanner_name(banner_name);
            M.setBanner_image(newBanner_image);
            Integer row=bannerService.banneradd(M);
        } catch (Exception e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();

        }
        model.setViewName("redirect:/huanchong2");
        return model;
    }
    @RequestMapping(value ="/bannerselect/{banner_id}", method = RequestMethod.GET)
    public String bannerselect(Model model,@PathVariable("banner_id")Integer banner_id){
        Banner banner=bannerService.bannerselectid(banner_id);
        model.addAttribute("banner",banner);
        return "banner-update";
    }
    @RequestMapping("/BannerShowImage")
    public void picShow(HttpServletRequest request, HttpServletResponse response, String picName) throws IOException {

        picName=new String(picName.getBytes("ISO8859-1"),"UTF-8"); //防止中文乱码
        String filePath = "D:\\upload/banner/";
        String imagePath =filePath+picName;
        response.reset();
        //判断文件是否存在
        File file = new File(imagePath);
        if (!file.exists()) {
            imagePath =filePath+picName;
        }
        // 得到输出流
        OutputStream output = response.getOutputStream();
        FileInputStream is = new FileInputStream(new File(imagePath));
        int i = is.available(); // 得到文件大小
        byte data[] = new byte[i];
        is.read(data); // 读数据
        is.close();
        response.setContentType("image/*"); // 设置返回的文件类型
        OutputStream toClient = response.getOutputStream(); // 得到向客户端输出二进制数据的对象
        toClient.write(data); // 输出数据
        toClient.close();
        output.close();
    }
    @PostMapping(value = "/weizhi/{banner_weizhi}")
    public @ResponseBody Integer  Weizhich(@PathVariable("banner_weizhi")Integer banner_weizhi){
        Integer r=null;
        Banner a=bannerService.bannerweizhi(banner_weizhi);
        if(a!=null){
            r=1;
        }else {
            r=0;
        }
        return r;
    }
    @RequestMapping(value="/bannerdelectall/{arr}",method=RequestMethod.POST)
    public @ResponseBody Integer bannerdelectall(@PathVariable("arr") List list){
        Integer rows=bannerService.banner_delete(list);
        return rows;
    }

    @RequestMapping(value ="/bannerdeletefyid/{banner_id}", method = RequestMethod.POST)
    public @ResponseBody Integer bannerdeletefyid(@PathVariable("banner_id")Integer banner_id)throws Exception {
        Integer row=bannerService.banner_deletefyid(banner_id);
        System.out.println(row);
        return row;
    }
    @RequestMapping(value="/bannerupdate/{banner_id}",method = RequestMethod.POST)
    public @ResponseBody ModelAndView bannerupdate(ModelAndView model,@PathVariable("banner_id")Integer banner_id,String banner_name,int banner_weizhi,@RequestParam(value="banner_image",required=false)MultipartFile banner_image, HttpServletRequest request) {
        //文件的原始名称
        String originalBanner_image = banner_image.getOriginalFilename();
        System.out.println(originalBanner_image);
        //新建file文件
        String filePath1 = "D:\\upload/banner";
        File filepath1 = new File(filePath1);
        if (!filepath1.exists()) {
            filepath1.mkdirs();
        }
        String newBanner_image = UUID.randomUUID() + originalBanner_image;
        //生成新的名字
        try {
            //使用MultipartFile类transferTo方法上传参数是个文件filepath+newFileName==/upload/xxx_1.txt
            File targetFile1 = new File(filePath1, newBanner_image);
            banner_image.transferTo(targetFile1);
            Banner M = new Banner();
            M.setBanner_id(banner_id);
            M.setBanner_weizhi(banner_weizhi);
            M.setBanner_name(banner_name);
            M.setBanner_image(newBanner_image);
            Integer row = bannerService.update_banner(M);
            System.out.println(row);
        } catch (Exception e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();

        }
        model.setViewName("redirect:/huanchong2");
        return model;
    }
    @PostMapping(value = "/bannerupdatesta/{banner_id}/{banner_state}")
    public @ResponseBody Integer bannerupdatesta(@PathVariable("banner_id")Integer banner_id,@PathVariable("banner_state")Integer banner_state){
        Banner banner=new Banner();
        banner.setBanner_id(banner_id);
        banner.setBanner_state(banner_state);
        return bannerService.bannerupdatesta(banner);
    }
}
