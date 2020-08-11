package com.systop.service.impl;


import com.systop.dao.AuthorMapper;
import com.systop.po.Author;
import com.systop.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorMapper authorMapper;


    @Override
    public List<Author> authorbyid() {
        return authorMapper.authorbyid();
    }

    @Override
    public Integer authoradd(Author author) {
        return authorMapper.authoradd(author);
    }

    @Override
    public List<Author> authorall() {
        return authorMapper.authorall();
    }

    @Override
    public Author authorselectid(Integer author_id) {
        return authorMapper.authorselectid(author_id);
    }

    @Override
    public Integer update_author(Author author) {
        return authorMapper.update_author(author);
    }

    @Override
    public Integer author_delete(List list) {
        return authorMapper.author_delete(list);
    }

    @Override
    public Integer author_deletefyid(Integer author_id) {
        return authorMapper.author_deletefyid(author_id);
    }
//    @Override
//    public Author login(String author_code, String author_Password) {
//        Author author=authorMapper.login(author_code,author_Password);
//        return author;
//    }

//public List<Author> selectall() {
//    List list= (List)authorMapper.selectall();
//    return list;
//}




//    @Override
//    public PageBean getBrandList(int pageCode, int sizePage) {
//            System.out.println("service"+pageCode);
//            PageHelper.startPage(pageCode, sizePage);
//            List list= (List)authorMapper.selectall();
//            PageBean bean=new PageBean();
//            bean.setRows(list);//将结果封装						//获取总记录数
//            PageInfo<Author> pageInfo=new PageInfo<Author>(list);
//            bean.setTotalCount((int)pageInfo.getTotal());//返回总条数
//            bean.setSizePage(sizePage);//设置每页条数
//            bean.setPageCode(pageCode);//设置第几页
//            return bean;
//    }
}
