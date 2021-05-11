package com.travel.mybatis.mapper;

import com.travel.mybatis.DO.Article;
import com.travel.mybatis.DO.Author;
import com.travel.mybatis.DO.Post;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 描述 新通教育
 *
 * @author ddshuai
 * @date 2021-05-10 09:30
 **/
public interface ArticleMapper {
    List<Article> selectAll();
    List<Article> selectForTitle(@Param("title") String title);
    Article selectById(Long id);
    Author selectAuthor(Long id);
    List<Post> selectPost(Long id);
}
