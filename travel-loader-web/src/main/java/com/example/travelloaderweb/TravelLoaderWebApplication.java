package com.example.travelloaderweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ddshuai
 */
@RestController
@SpringBootApplication
public class TravelLoaderWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravelLoaderWebApplication.class, args);
    }

    @GetMapping("/")
    public String echo() {
        return "Welcome";
    }
}
