package com.travel.qywx.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 描述
 *
 * @author ddshuai
 * @date 2019-04-06 22:47
 **/
public class AllowUser {
    @JsonProperty("user")
    private List<WeChatUser> userList;

    public List<WeChatUser> getUserList() {
        return userList;
    }

    public void setUserList(List<WeChatUser> userList) {
        this.userList = userList;
    }
}
