package com.systop.service;

import com.systop.po.User;

import java.util.List;

public interface UserService {
//    public User login(String user_code,String user_Password);
    public List<User> selectall();
    public User select(Integer user_id);
    public Integer update_user(User user);
    public Integer user_delete(List list);
    public Integer user_deletefyid(Integer user_id);
    public Integer update_read(List list2);
    public List<Integer> seletcrelation(Integer author_id);
}
