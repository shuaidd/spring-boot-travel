package com.travel;

import com.travel.component.PersonComponent;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

/**
 * Unit test for simple App.
 */
//@Import(PersonComponent.class)
public class AppTest extends AbstractBaseTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    private PersonComponent personComponent;

    @Test
    public void getConfigObject(){
        logger.info("获取自动配置的对象:{}",personComponent);
    }
}
