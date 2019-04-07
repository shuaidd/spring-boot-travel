package com.travel.qywx.client.config;

import com.travel.qywx.client.interceptor.WeChatInterceptor;
import feign.Feign;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 描述 企业微信feign客户端配置
 *
 * @author ddshuai
 * @date 2019-04-04 16:18
 **/
public class WeChatConfiguration {

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public Decoder decoder() {
        return new JacksonDecoder();
    }

    @Bean
    public Encoder encoder() {
        return new JacksonEncoder();
    }

    @Bean
    public Feign.Builder builder() {
        return new Feign.Builder().requestInterceptor(new WeChatInterceptor(applicationContext));
    }
}
