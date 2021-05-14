package com.travel.mybatis;

import com.travel.mybatis.DO.Article;
import com.travel.mybatis.DO.Author;
import com.travel.mybatis.DO.Post;
import com.travel.mybatis.mapper.ArticleMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

/**
 * 描述 测试mybatis初始化
 *
 * @author ddshuai
 * @date 2021-05-08 14:23
 **/
@Component
public class NormalCommandLineRunner implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final SqlSessionFactory sqlSessionFactory;

    public NormalCommandLineRunner(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public void run(String... args) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ArticleMapper articleMapper = sqlSession.getMapper(ArticleMapper.class);
            List<Article> articles = articleMapper.selectAll();
            logger.info("测试普通查询---{}", articles);
            articles = articleMapper.selectAll();
            logger.info("测试普通查询--第二次---{}", articles);
            Article article = articleMapper.selectById(1L);
            logger.info("{}",article.getId());
            logger.info("{}",article.getPosts());
            articleMapper.selectForTitle("ww");
        }
    }
}
