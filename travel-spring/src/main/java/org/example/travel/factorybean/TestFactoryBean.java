package org.example.travel.factorybean;

import org.springframework.beans.factory.FactoryBean;

public class TestFactoryBean implements FactoryBean<TestBean> {

    @Override
    public TestBean getObject() throws Exception {
        return TestBean.builder().age("12").name("test").build();
    }

    @Override
    public Class<?> getObjectType() {
        return TestBean.class;
    }
}
