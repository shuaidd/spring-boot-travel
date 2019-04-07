package com.travel.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 描述
 *
 * @author ddshuai
 * @date 2019-04-02 16:00
 **/
@ConfigurationProperties(prefix = "travel")
public class AutoConfigureTravelProperties {
    private String name;
    private String password;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
