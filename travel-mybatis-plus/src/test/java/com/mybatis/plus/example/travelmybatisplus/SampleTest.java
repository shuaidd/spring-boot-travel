package com.mybatis.plus.example.travelmybatisplus;

import com.mybatis.plus.example.travelmybatisplus.entity.User;
import com.mybatis.plus.example.travelmybatisplus.mapper.ItemMapper;
import com.mybatis.plus.example.travelmybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SampleTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
    }

    @Test
    public void selectItem() {
        itemMapper.selectList(null);
    }
}
