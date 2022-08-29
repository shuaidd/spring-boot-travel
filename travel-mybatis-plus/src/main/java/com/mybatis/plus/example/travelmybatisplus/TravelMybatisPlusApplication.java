package com.mybatis.plus.example.travelmybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mybatis.plus.example.travelmybatisplus.mapper")
public class TravelMybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravelMybatisPlusApplication.class, args);
    }

}
