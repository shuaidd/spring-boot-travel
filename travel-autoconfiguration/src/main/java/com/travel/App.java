package com.travel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 * @author shuaidongdong
 */
@RestController
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.travel.other")
public class App 
{
    public static void main( String[] args ) {
        SpringApplication.run(App.class,args);
    }
}


