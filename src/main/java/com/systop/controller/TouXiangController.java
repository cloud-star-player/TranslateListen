package com.systop.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.systop.po.TouXiang;
import com.systop.service.TouXiangService;
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
public class TouXiangController {
    @Autowired
    private TouXiangService touxiangService;
    @RequestMapping("/touxiangall")
    public String list(@RequestParam(value="pn", defaultValue="1")Integer pn, Model model){
        //紧跟查询结果的分页情况（第几页， 每页多少记录）
        PageHelper.startPage(pn,5);
        List<TouXiang> dep= touxiangService.touxiangall();
        System.out.println(dep+"jilu");
        //骚操作： 将结果放入pageinfo中，这个pageinfo就有很多有用的参数
        PageInfo<TouXiang> list=new PageInfo<>(dep,5);
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
        return "touxiang-list";   //跳转到success.jsp 页面
    }
    @RequestMapping("/totouxiangadd")
    public String totouxiangadd(){
        return "touxiang-add";
    }
    @RequestMapping("/totouxiangupdate")
    public String totouxiangupdate(){
        return "touxiang-update";
    }
    @RequestMapping("/huanchong3")
    public String huanchong(){
        return "huanchong3";
    }
    @RequestMapping(value="/TouXiangupload",method = RequestMethod.POST)
    public @ResponseBody
    ModelAndView upload(ModelAndView model,@RequestParam(value="touxiang_image",required=false) MultipartFile touxiang_image, HttpServletRequest request) {
        //文件的原始名称
        String originalTouXiang_image = touxiang_image.getOriginalFilename();
        System.out.println(originalTouXiang_image);
        //新建file文件
        String filePath1 = "D:\\upload/touxiang";
        File filepath1 = new File(filePath1);
        if(!filepath1.exists()) {
            filepath1.mkdirs();
        }
        String newTouXiang_image= UUID.randomUUID() + originalTouXiang_image;
        System.out.println(newTouXiang_image);
        //生成新的名字
        try {
            //使用MultipartFile类transferTo方法上传参数是个文件filepath+newFileName==/upload/xxx_1.txt
            File targetFile1 = new File(filePath1, newTouXiang_image);
            touxiang_image.transferTo(targetFile1);
            TouXiang M=new TouXiang();
            M.setTouxiang_image(newTouXiang_image);
            Integer row=touxiangService.touxiangadd(M);
        } catch (Exception e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();

        }
        model.setViewName("redirect:/huanchong3");
        return model;
    }
    @RequestMapping(value ="/touxiangselect/{touxiang_id}", method = RequestMethod.GET)
    public String touxiangselect(Model model,@PathVariable("touxiang_id")Integer touxiang_id){
        TouXiang touxiang=touxiangService.touxiangselectid(touxiang_id);
        model.addAttribute("touxiang",touxiang);
        return "touxiang-update";
    }
    @RequestMapping("/TouXiangShowImage")
    public void picShow(HttpServletRequest request, HttpServletResponse response, String picName) throws IOException {

        picName=new String(picName.getBytes("ISO8859-1"),"UTF-8"); //防止中文乱码
        String filePath = "D:\\upload/touxiang/";
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
    @RequestMapping(value="/touxiangdelectall/{arr}",method=RequestMethod.POST)
    public @ResponseBody Integer touxiangdelectall(@PathVariable("arr") List list){
        Integer rows=touxiangService.touxiang_delete(list);
        return rows;
    }

    @RequestMapping(value ="/touxiangdeletefyid/{touxiang_id}", method = RequestMethod.POST)
    public @ResponseBody Integer touxiangdeletefyid(@PathVariable("touxiang_id")Integer touxiang_id)throws Exception {
        Integer row=touxiangService.touxiang_deletefyid(touxiang_id);
        System.out.println(row);
        return row;
    }
    @RequestMapping(value="/touxiangupdate/{touxiang_id}",method = RequestMethod.POST)
    public @ResponseBody ModelAndView touxiangupdate(ModelAndView model,@PathVariable("touxiang_id")Integer touxiang_id,@RequestParam(value="touxiang_image",required=false)MultipartFile touxiang_image, HttpServletRequest request) {
        //文件的原始名称
        String originalTouXiang_image = touxiang_image.getOriginalFilename();
        System.out.println(originalTouXiang_image);
        //新建file文件
        String filePath1 = "D:\\upload/touxiang";
        File filepath1 = new File(filePath1);
        if (!filepath1.exists()) {
            filepath1.mkdirs();
        }
        String newTouXiang_image = UUID.randomUUID() + originalTouXiang_image;
        //生成新的名字
        try {
            //使用MultipartFile类transferTo方法上传参数是个文件filepath+newFileName==/upload/xxx_1.txt
            File targetFile1 = new File(filePath1, newTouXiang_image);
            touxiang_image.transferTo(targetFile1);
            TouXiang M = new TouXiang();
            M.setTouxiang_image(newTouXiang_image);
            Integer row = touxiangService.update_touxiang(M);
            System.out.println(row);
        } catch (Exception e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();

        }
        model.setViewName("redirect:/huanchong3");
        return model;
    }
    @PostMapping(value = "/touxiangupdatesta/{touxiang_id}/{touxiang_state}")
    public @ResponseBody Integer touxiangupdatesta(@PathVariable("touxiang_id")Integer touxiang_id,@PathVariable("touxiang_state")Integer touxiang_state){
        TouXiang touxiang=new TouXiang();
        touxiang.setTouxiang_id(touxiang_id);
        touxiang.setTouxiang_state(touxiang_state);
        return touxiangService.touxiangupdatesta(touxiang);
    }
}
