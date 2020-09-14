package com.travel;

/**
 * 描述
 *
 * @author ddshuai
 * @date 2020-09-10 15:37
 **/
public abstract class LookUpBean {
    public void print(){
        System.out.println("动态获取MessageService了");
        System.out.println(this.getBean().getMessage());
    }
    public abstract MessageService getBean();
}
