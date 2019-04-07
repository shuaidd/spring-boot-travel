package com.travel.qywx.client.config;

import com.travel.qywx.client.decoder.WeChatMediaDecoder;
import com.travel.qywx.client.interceptor.WeChatInterceptor;
import feign.Feign;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author shuaidongdong
 */

public class MultipartSupportConfig {

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public Encoder feignFormEncoder() {
        return new SpringFormEncoder();
    }

    @Bean
    public Decoder decoder(){
        return new WeChatMediaDecoder();
    }

    @Bean
    public Feign.Builder builder() {
        return new Feign.Builder().requestInterceptor(new WeChatInterceptor(applicationContext));
    }
}