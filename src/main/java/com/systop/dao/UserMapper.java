package com.systop.dao;

import com.systop.po.User;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface UserMapper {
//    User login(@Param("user_code") String user_code, @Param("user_password") String user_Password);
    List<User> selectall();
    User select(@Param("user_id")Integer user_id);
    Integer update_user(User user);
    Integer user_delete(List list);
    Integer user_deletefyid(Integer user_id);
    Integer update_read(List list2);
    List<Integer> seletcrelation(Integer author_id);
}
