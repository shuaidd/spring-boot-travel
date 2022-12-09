package org.example.test;

import org.example.travel.*;
import org.example.travel.factorybean.AccountServiceImpl;
import org.example.travel.factorybean.ClientService;
import org.example.travel.factorybean.ClientServiceImpl;
import org.example.travel.factorybean.TestBean;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringClassPathTest {

    private static final Logger log = LoggerFactory.getLogger(SpringClassPathTest.class);

    @Test
    public void testAnnotation() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Pojo2Bean bean = context.getBean(Pojo2Bean.class);
        log.info("Annotation bean: {}" , bean);

        //通过静态工厂方法创建的实例
        ClientService clientService = context.getBean("clientService",ClientService.class);
        log.info("Annotation clientService: {}" , clientService);

        //通过静态工厂方法创建的实例
        ClientServiceImpl clientServiceImpl = context.getBean("clientServiceImpl",ClientServiceImpl.class);
        AccountServiceImpl accountServiceImpl = context.getBean("accountServiceImpl", AccountServiceImpl.class);
        log.info("Annotation clientServiceImpl: {} ---accountServiceImpl--{}" , clientServiceImpl, accountServiceImpl);

        //通过实现FactoryBean实例化对象
        TestBean testBean = context.getBean(TestBean.class);
        log.info("FactoryBean: {}" , testBean);

        //获取Bean的类型
        log.info("getType: {}" , context.getBeanFactory().getType("clientServiceImpl"));
    }
}
