package com.mybatis.plus.example.travelmybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatis.plus.example.travelmybatisplus.entity.User;
import com.mybatis.plus.example.travelmybatisplus.mapper.ItemMapper;
import com.mybatis.plus.example.travelmybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class SampleTest {

    @SuppressWarnings("all")
    @Autowired
    private UserMapper userMapper;

    @SuppressWarnings("all")
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

    @Test
    public void saveUser() {
        User user = new User();
        user.setAge(1);
        user.setEmail("shuaidd@139.com");
        user.setName("ddshuai");
        userMapper.insert(user);
    }

    @Test
    public void updateUser() {
        User user = userMapper.selectById(1);
        user.setCreateTime(LocalDateTime.now());
        userMapper.updateById(user);
    }

    @Test
    public void selectByWrapper() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","Jone").eq("age",18).or(wrapper1-> {
            wrapper1.eq("id",1).likeRight("email","test111");
        });
        userMapper.selectList(wrapper);
    }

    @Test
    public void selectByPage() {
        Page<User> page = new Page<>(1,2);
        userMapper.selectPage(page,null);
        System.out.println(page);
    }
}
