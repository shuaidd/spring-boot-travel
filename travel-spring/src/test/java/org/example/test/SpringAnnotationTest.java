package org.example.test;

import org.example.travel.PojoBean;
import org.example.travel.di.SetterExample;
import org.example.travel.di.SimpleMovieLister;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAnnotationTest {

    private static final Logger log = LoggerFactory.getLogger(SpringAnnotationTest.class);

    @Test
    public void testAnnotation() throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("org.example.travel");
        context.refresh();
        PojoBean bean = context.getBean(PojoBean.class);
        log.info("Annotation bean: {}" , bean);
        bean = context.getBean(PojoBean.class);
        log.info("Annotation bean: {}" , bean);

        //构造函数注入
        SimpleMovieLister lister = context.getBean(SimpleMovieLister.class);
        lister.find();

        //setter方式注入 和 构造器注入 配合 构造器注入必须存在的字段 setter处理 可空字段
        SetterExample setterExample = context.getBean(SetterExample.class);
        setterExample.find();
    }
}
