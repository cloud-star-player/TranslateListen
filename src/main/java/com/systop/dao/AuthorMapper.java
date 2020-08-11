package com.systop.dao;

import com.systop.po.Author;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthorMapper {
    List<Author>authorbyid();
    Integer authoradd(Author author);
    List<Author> authorall();
    Author authorselectid(Integer author_id);
    Integer update_author(Author author);
    Integer author_delete(List list);
    Integer author_deletefyid(@Param("author_id")Integer music_id);
}
