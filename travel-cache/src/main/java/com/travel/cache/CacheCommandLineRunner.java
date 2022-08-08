package com.travel.cache;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 描述
 *
 * @author ddshuai
 * date 2022-01-24 15:24
 **/
@Component
public class CacheCommandLineRunner implements CommandLineRunner {

    private final CaffeineService caffeineService;

    public CacheCommandLineRunner(CaffeineService caffeineService) {
        this.caffeineService = caffeineService;
    }

    @Override
    public void run(String... args) throws Exception {
        String data = caffeineService.getData("ddshuai");
        System.out.println(data);
        data = caffeineService.getData("ddshuai");
        System.out.println(data);
        data = caffeineService.getData("ddshuai");
        System.out.println(data);
        data = caffeineService.getData("ddshuai");
        System.out.println(data);
        data = caffeineService.getData("ddshuai");
        System.out.println(data);
        Thread.sleep(2100);
        data = caffeineService.getData("ddshuai");
        System.out.println(data);
    }
}
