package com.travel.config;

import com.travel.component.PersonComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述
 *
 * @author ddshuai
 * @date 2019-03-12 13:23
 **/
@Configuration
public class ComponentConfiguration {

    @Bean
    public PersonComponent personComponent(){
        return new PersonComponent();
    }
}
