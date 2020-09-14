package com.travel;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;
import java.util.UUID;

/**
 * 描述
 *
 * @author ddshuai
 * @date 2020-09-10 15:44
 **/
public class TestMethodReplacer implements MethodReplacer {

    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println("方法被替换了-String-Obj:from method-replacer-" + UUID.randomUUID());
        return "String-Obj:from method-replacer-" + UUID.randomUUID();
    }
}
