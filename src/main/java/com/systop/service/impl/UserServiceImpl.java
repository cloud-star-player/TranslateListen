package com.systop.service.impl;


import com.systop.dao.UserMapper;
import com.systop.po.User;
import com.systop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
//    @Override
//    public User login(String user_code, String user_Password) {
//        User user=userMapper.login(user_code,user_Password);
//        return user;
//    }

//public List<User> selectall() {
//    List list= (List)userMapper.selectall();
//    return list;
//}


    @Override
    public List<User> selectall() {
        List list= (List)userMapper.selectall();
        return list;
    }

    @Override
    public User select(Integer user_id) {
        User user=userMapper.select(user_id);
        return user;
    }

    @Override
    public Integer update_user(User user) {
        Integer i= userMapper.update_user(user);
        return  i;
    }

    @Override
    public Integer user_delete(List list) {
        Integer o=userMapper.user_delete(list);
        return o;
    }

    @Override
    public Integer user_deletefyid(Integer user_id) {
        Integer i=userMapper.user_deletefyid(user_id);
        return i;
    }

    @Override
    public Integer update_read(List list2) {
        return userMapper.update_read(list2);
    }

    @Override
    public List<Integer> seletcrelation(Integer author_id) {
        return userMapper.seletcrelation(author_id);
    }


//    @Override
//    public PageBean getBrandList(int pageCode, int sizePage) {
//            System.out.println("service"+pageCode);
//            PageHelper.startPage(pageCode, sizePage);
//            List list= (List)userMapper.selectall();
//            PageBean bean=new PageBean();
//            bean.setRows(list);//将结果封装						//获取总记录数
//            PageInfo<User> pageInfo=new PageInfo<User>(list);
//            bean.setTotalCount((int)pageInfo.getTotal());//返回总条数
//            bean.setSizePage(sizePage);//设置每页条数
//            bean.setPageCode(pageCode);//设置第几页
//            return bean;
//    }
}
