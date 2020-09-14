package com.travel;

public class MessageServiceImpl implements MessageService {
    private String name;

    @Override
    public String getMessage() {
        return "hello world";
    }

    public String getName() {
        return name;
    }

    public void init(){
        System.out.println("init bean");
    }

    public void sayHi(){
        System.out.println("say hi");
    }

    public void setName(String name) {
        this.name = name;
    }
}
