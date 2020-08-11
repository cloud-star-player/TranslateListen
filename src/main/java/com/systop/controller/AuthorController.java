package com.systop.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.systop.po.Author;
import com.systop.service.AuthorService;
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
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @RequestMapping("/authorall")
    public String list(@RequestParam(value="pn", defaultValue="1")Integer pn, Model model){
        //紧跟查询结果的分页情况（第几页， 每页多少记录）
        PageHelper.startPage(pn,5);
        List<Author> dep= authorService.authorall();
        System.out.println(dep+"jilu");
        //骚操作： 将结果放入pageinfo中，这个pageinfo就有很多有用的参数
        PageInfo<Author> list=new PageInfo<>(dep,5);
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
        return "author-list";   //跳转到success.jsp 页面
    }
    @RequestMapping("/toauthoradd")
    public String toauthoradd(){
        return "author-add";
    }
    @RequestMapping("/toauthorupdate")
    public String toauthorupdate(){
        return "author-update";
    }
    @RequestMapping("/huanchong4")
    public String huanchong(){
        return "huanchong4";
    }
    @RequestMapping(value="/Authorupload",method = RequestMethod.POST)
    public @ResponseBody
    ModelAndView upload(ModelAndView model, String author_name, @RequestParam(value="author_image",required=false) MultipartFile author_image, HttpServletRequest request) {
        //文件的原始名称
        String originalAuthor_image = author_image.getOriginalFilename();
        System.out.println(originalAuthor_image);
        //新建file文件
        String filePath1 = "D:\\upload/author";
        File filepath1 = new File(filePath1);
        if(!filepath1.exists()) {
            filepath1.mkdirs();
        }
        String newAuthor_image= UUID.randomUUID() + originalAuthor_image;
        System.out.println(newAuthor_image);
        //生成新的名字
        try {
            //使用MultipartFile类transferTo方法上传参数是个文件filepath+newFileName==/upload/xxx_1.txt
            File targetFile1 = new File(filePath1, newAuthor_image);
            author_image.transferTo(targetFile1);
            Author M=new Author();
            M.setAuthor_name(author_name);
            M.setAuthor_image(newAuthor_image);
            Integer row=authorService.authoradd(M);
        } catch (Exception e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();

        }
        model.setViewName("redirect:/huanchong4");
        return model;
    }
    @RequestMapping(value ="/authorselect/{author_id}", method = RequestMethod.GET)
    public String authorselect(Model model,@PathVariable("author_id")Integer author_id){
        Author author=authorService.authorselectid(author_id);
        model.addAttribute("author",author);
        return "author-update";
    }
    @RequestMapping("/AuthorShowImage")
    public void picShow(HttpServletRequest request, HttpServletResponse response, String picName) throws IOException {

        picName=new String(picName.getBytes("ISO8859-1"),"UTF-8"); //防止中文乱码
        String filePath = "D:\\upload/author/";
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
    @RequestMapping(value="/authorupdate/{author_id}",method = RequestMethod.POST)
    public @ResponseBody ModelAndView authorupdate(ModelAndView model,@PathVariable("author_id")Integer author_id,String author_name,@RequestParam(value="author_image",required=false)MultipartFile author_image, HttpServletRequest request) {
        //文件的原始名称
        String originalAuthor_image = author_image.getOriginalFilename();
        System.out.println(originalAuthor_image);
        //新建file文件
        String filePath1 = "D:\\upload/author";
        File filepath1 = new File(filePath1);
        if (!filepath1.exists()) {
            filepath1.mkdirs();
        }
        String newAuthor_image = UUID.randomUUID() + originalAuthor_image;
        //生成新的名字
        try {
            //使用MultipartFile类transferTo方法上传参数是个文件filepath+newFileName==/upload/xxx_1.txt
            File targetFile1 = new File(filePath1, newAuthor_image);
            author_image.transferTo(targetFile1);
            Author M = new Author();
            M.setAuthor_id(author_id);
            M.setAuthor_name(author_name);
            M.setAuthor_image(newAuthor_image);
            Integer row = authorService.update_author(M);
            System.out.println(row);
        } catch (Exception e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();

        }
        model.setViewName("redirect:/huanchong4");
        return model;
    }
    @RequestMapping(value="/authordelectall/{arr}",method=RequestMethod.POST)
    public @ResponseBody Integer authordelectall(@PathVariable("arr") List list){
        Integer rows=authorService.author_delete(list);
        return rows;
    }

    @RequestMapping(value ="/authordeletefyid/{author_id}", method = RequestMethod.POST)
    public @ResponseBody Integer authordeletefyid(@PathVariable("author_id")Integer author_id)throws Exception {
        Integer row=authorService.author_deletefyid(author_id);
        return row;
    }
}
