package com.travel;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void testXml() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
        System.out.println("context 启动成功");

        // 从 context 中取出我们的 Bean，而不是用 new MessageServiceImpl() 这种方式
        MessageServiceImpl messageService = context.getBean(MessageServiceImpl.class);
        // 这句将输出: hello world
        System.out.println(messageService.getName());
        messageService.sayHi();

        context.getBean(LookUpBean.class).print();
    }

    @Test
    public void testAnnotation(){
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext("com.travel");
        configApplicationContext.getBean(AnnotationTest.class).printMsg();
    }
}
