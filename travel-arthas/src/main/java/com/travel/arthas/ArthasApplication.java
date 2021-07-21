package com.travel.arthas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ArthasApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArthasApplication.class, args);
    }

    @RequestMapping("test")
    public String test(){
        long i = 0;
        long start = System.currentTimeMillis();
        while (i++ < 500000000){

        }
        System.out.println(System.currentTimeMillis() - start);
        return String.valueOf(i);
    }
}
