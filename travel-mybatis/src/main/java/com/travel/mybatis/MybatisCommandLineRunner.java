package com.travel.mybatis;

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
import java.util.Map;

/**
 * 描述 测试mybatis初始化
 *
 * @author ddshuai
 * @date 2021-05-08 14:23
 **/
@Component
public class MybatisCommandLineRunner implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run(String... args) {
        SqlSession sqlSession = null;
        try(InputStream inputStream = Resources.getResourceAsStream("mybatis.xml")) {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
            String productName = sqlSession.getConnection().getMetaData().getDatabaseProductName();
            String version = sqlSession.getConnection().getMetaData().getDatabaseProductVersion();
            logger.info("---------测试mybatis初始化--{}---{}----------",productName,version);
            Map<String, Class<?>> map = sqlSessionFactory.getConfiguration().getTypeAliasRegistry().getTypeAliases();
            map.forEach((key,value)->{
                logger.info("mybatis注册过的别名列表--{}----{}",key,value);
            });
        } catch (IOException | SQLException e) {
            logger.error("初始化异常了");
        } finally {
            assert sqlSession != null;
            sqlSession.close();
        }
    }
}
