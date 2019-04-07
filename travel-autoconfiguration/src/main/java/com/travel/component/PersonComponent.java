package com.travel.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 描述
 *
 * @author ddshuai
 * @date 2019-03-12 11:09
 **/
@Component
public class PersonComponent {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public void hello(){
        logger.info("hello world");
    }
}
