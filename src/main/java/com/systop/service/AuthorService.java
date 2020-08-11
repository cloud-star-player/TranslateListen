package com.systop.service;

import com.systop.po.Author;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthorService {
//    public Author login(String author_code,String author_Password);
//    public List<Author> selectall();
      public List<Author> authorbyid();
      public Integer authoradd(Author author);
      public List<Author> authorall();
      public Author authorselectid(Integer author_id);
      public Integer update_author(Author author);
      public Integer author_delete(List list);
      public Integer author_deletefyid(Integer author_id);

}
