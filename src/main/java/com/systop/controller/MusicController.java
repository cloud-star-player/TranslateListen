package com.systop.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


import com.systop.po.Author;
import com.systop.po.Music;
import com.systop.service.AuthorService;
import com.systop.service.MusicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.List;
import java.util.UUID;

@Controller
public class MusicController {
    @Autowired
    private MusicService musicService;
    @Autowired
    private AuthorService authorService;
    @RequestMapping("/musicall")
    public String list(@RequestParam(value="pn", defaultValue="1")Integer pn, Model model){
        //紧跟查询结果的分页情况（第几页， 每页多少记录）
        PageHelper.startPage(pn,5);
        List<Music> dep= musicService.musicall();
        System.out.println(dep+"jilu");
        //骚操作： 将结果放入pageinfo中，这个pageinfo就有很多有用的参数
        PageInfo<Music> list=new PageInfo<>(dep,5);
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
        return "music-list";   //跳转到success.jsp 页面
    }
    @RequestMapping("/tomusicadd")
    public String tomusicadd(Model model){
        List<Author> author=authorService.authorbyid();
        model.addAttribute("authorid",author);
        return "music-add";
    }
    @RequestMapping("/huanchong")
    public String huanchong(){
        return "huanchong";
    }
    @RequestMapping(value="/upload",method = RequestMethod.POST)
    public @ResponseBody ModelAndView upload(ModelAndView model,String music_name, int music_author_id,int music_type,@RequestParam(value="music_image",required=false)MultipartFile music_image, @RequestParam(value="music_music",required=false)MultipartFile music_music, HttpServletRequest request) {
        //文件的原始名称
        String originalMusic_image = music_image.getOriginalFilename();
        String originalMusic_music = music_music.getOriginalFilename();
        System.out.println(originalMusic_image);
        System.out.println(originalMusic_music);
        //新建file文件
        String filePath1 = "D:\\upload/image";
        String filePath2 = "D:\\upload/music";
        File filepath1 = new File(filePath1);
        File filepath2 = new File(filePath2);
        if(!filepath1.exists()) {
            filepath1.mkdirs();
        }
        if(!filepath2.exists()) {
            filepath2.mkdirs();
        }
        String newMusic_image=UUID.randomUUID() + originalMusic_image;
        String newMusic_music=UUID.randomUUID() + originalMusic_music;
        System.out.println(newMusic_image);
        System.out.println(newMusic_music);
        //生成新的名字
        try {
            //使用MultipartFile类transferTo方法上传参数是个文件filepath+newFileName==/upload/xxx_1.txt
            File targetFile1 = new File(filePath1, newMusic_image);
            File targetFile2 = new File(filePath2, newMusic_music);
            music_image.transferTo(targetFile1);
            music_music.transferTo(targetFile2);

            Music M=new Music();

            M.setMusic_author_id(music_author_id);
            M.setMusic_name(music_name);
            M.setMusic_image(newMusic_image);
            M.setMusic_music(newMusic_music);
            M.setMusic_type(music_type);
            Integer row=musicService.musicadd(M);
        } catch (Exception e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();

        }
        model.setViewName("redirect:/huanchong");
        return model;
    }
    @RequestMapping("/ShowImage")
    public void picShow(HttpServletRequest request,HttpServletResponse response,String picName) throws IOException {

        picName=new String(picName.getBytes("ISO8859-1"),"UTF-8"); //防止中文乱码
        String filePath = "D:\\upload/image/";
        String imagePath =filePath+picName;
        System.out.println(imagePath);
        response.reset();
        //判断文件是否存在
        File file = new File(imagePath);
        if (!file.exists()) {
            imagePath =filePath+picName;
        }
        // 得到输出流
        OutputStream output = response.getOutputStream();
//        if (imagePath.toLowerCase().endsWith(".jpg"))// 使用编码处理文件流的情况：
//        {
//            System.out.println("进入");
//            response.setContentType("image/jpeg;charset=GB2312");// 设定输出的类型
//            // 得到图片的真实路径
//            // 得到图片的文件流
//            InputStream imageIn = new FileInputStream(new File(imagePath));
//            // 得到输入的编码器，将文件流进行jpg格式编码
//            JPEGImageDecoder decoder = JPEGCodec.createJPEGDecoder(imageIn);
//            // 得到编码后的图片对象
//            BufferedImage image = decoder.decodeAsBufferedImage();
//            // 得到输出的编码器
//            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(output);
//            encoder.encode(image);// 对图片进行输出编码
//            imageIn.close();// 关闭文件流
//        }
//        if (imagePath.toLowerCase().endsWith(".png"))// 使用编码处理文件流的情况：
//        {
            FileInputStream is = new FileInputStream(new File(imagePath));
            int i = is.available(); // 得到文件大小
            byte data[] = new byte[i];
            is.read(data); // 读数据
            is.close();
            response.setContentType("image/*"); // 设置返回的文件类型
            OutputStream toClient = response.getOutputStream(); // 得到向客户端输出二进制数据的对象
            toClient.write(data); // 输出数据
            toClient.close();
//        }
//        if (imagePath.toLowerCase().endsWith(".gif"))// 不使用编码处理文件流的情况：
//             {
//                 System.out.println("进入w");
//                 response.setContentType("image/gif;charset=GB2312");
//                 ServletContext context  = RequestContextUtils.getWebApplicationContext(request).getServletContext();// 得到背景对象
//                 InputStream imageIn = context.getResourceAsStream(imagePath);// 文件流
//                 BufferedInputStream bis = new BufferedInputStream(imageIn);// 输入缓冲流
//                 BufferedOutputStream bos = new BufferedOutputStream(output);// 输出缓冲流
//                 byte data[] = new byte[4096];// 缓冲字节数
//                 int size = 0;
//                 size = bis.read(data);
//                 while (size != -1) {
//                     bos.write(data, 0, size);
//                     size = bis.read(data);
//                 }
//                 bis.close();
//                 bos.flush();// 清空输出缓冲流
//                 bos.close();
//             }
        output.close();
    }

//    音乐文件
    @RequestMapping("/ShowMusic")
    public void sicShow(HttpServletRequest request,HttpServletResponse response,String sicName) throws IOException {
        sicName=new String(sicName.getBytes("ISO8859-1"),"UTF-8"); //防止中文乱码
        String filePath = "D:\\upload/music/";
        String imagePath =filePath+sicName;
        response.reset();
        //判断文件是否存在
        File file = new File(imagePath);
        if (!file.exists()) {
            imagePath =filePath+sicName;
        }
        // 得到输出流
        OutputStream output = response.getOutputStream();
        FileInputStream is = new FileInputStream(new File(imagePath));
        int i = is.available(); // 得到文件大小
        byte data[] = new byte[i];
        is.read(data); // 读数据
        is.close();
        response.setContentType("audio/*"); // 设置返回的文件类型
        OutputStream toClient = response.getOutputStream(); // 得到向客户端输出二进制数据的对象
        toClient.write(data); // 输出数据
        toClient.close();
    }

    @RequestMapping(value ="/musicselect/{music_id}", method = RequestMethod.GET)
    public String musicselect(Model model,@PathVariable("music_id")Integer music_id){
        List<Author> author=authorService.authorbyid();
        Music music=musicService.musicselectid(music_id);
        model.addAttribute("authorid",author);
        model.addAttribute("music",music);
        return "music-update";
    }
    @RequestMapping(value ="/musicselect2/{music_id}", method = RequestMethod.GET)
    public @ResponseBody Music musicselect2(@PathVariable("music_id")Integer music_id){
        Music music=musicService.musicselectid(music_id);
        return music;
    }

    @RequestMapping(value="/musicupdate/{music_id}",method = RequestMethod.POST)
    public @ResponseBody ModelAndView musicupdate(ModelAndView model,@PathVariable("music_id")Integer music_id,String music_name, int music_author_id,int music_collect,int music_hot,int music_type,@RequestParam(value="music_image",required=false)MultipartFile music_image, @RequestParam(value="music_music",required=false)MultipartFile music_music, HttpServletRequest request) {
        //文件的原始名称
        System.out.println(music_image);
        System.out.println(music_collect);
        String originalMusic_image = music_image.getOriginalFilename();
        String originalMusic_music = music_music.getOriginalFilename();
        System.out.println(originalMusic_image);
        System.out.println(originalMusic_music);
        //新建file文件
        String filePath1 = "D:\\upload/image";
        String filePath2 = "D:\\upload/music";
        File filepath1 = new File(filePath1);
        File filepath2 = new File(filePath2);
        if(!filepath1.exists()) {
            filepath1.mkdirs();
        }
        if(!filepath2.exists()) {
            filepath2.mkdirs();
        }
        String newMusic_image=UUID.randomUUID() + originalMusic_image;
        String newMusic_music=UUID.randomUUID() + originalMusic_music;
        System.out.println(newMusic_image+"update");
        System.out.println(newMusic_music+"update2");
        //生成新的名字
        try {
            //使用MultipartFile类transferTo方法上传参数是个文件filepath+newFileName==/upload/xxx_1.txt
            File targetFile1 = new File(filePath1, newMusic_image);
            File targetFile2 = new File(filePath2, newMusic_music);
            music_image.transferTo(targetFile1);
            music_music.transferTo(targetFile2);
            Music M=new Music();
            M.setMusic_author_id(music_author_id);
            M.setMusic_name(music_name);
            M.setMusic_image(newMusic_image);
            M.setMusic_music(newMusic_music);
            M.setMusic_type(music_type);
            M.setMusic_collect(music_collect);
            M.setMusic_hot(music_hot);
            M.setMusic_id(music_id);
            Integer row=musicService.update_music(M);
        } catch (Exception e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        model.setViewName("redirect:/huanchong");
        return model;
    }
    @RequestMapping(value="/musicdelectall/{arr}",method=RequestMethod.POST)
    public @ResponseBody Integer musicdelectall(@PathVariable("arr") List list){
        Integer rows=musicService.music_delete(list);
        return rows;
    }

    @RequestMapping(value ="/musicdeletefyid/{music_id}", method = RequestMethod.POST)
    public @ResponseBody Integer musicdeletefyid(@PathVariable("music_id")Integer music_id)throws Exception {
        Integer row=musicService.music_deletefyid(music_id);
        System.out.println(row);
        return row;
    }
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
