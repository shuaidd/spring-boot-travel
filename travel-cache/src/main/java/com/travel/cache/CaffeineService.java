package com.travel.cache;

import net.bytebuddy.utility.RandomString;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 描述
 *
 * @author ddshuai
 * date 2022-01-24 15:17
 **/

@Service
public class CaffeineService {

    @Cacheable(value = "cache1",key = "#key")
    public String getData(String key) {
        System.out.println("进来了");
        return RandomString.make(20);
    }
}
