package com.travel;

import com.github.shuaidd.autoconfigure.EnableWeChat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 描述
 *
 * @author ddshuai
 * @date 2019-04-03 15:42
 **/
@EnableAspectJAutoProxy
@EnableCaching
@EnableWeChat
@SpringBootApplication(scanBasePackages = "com.travel.qywx")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
