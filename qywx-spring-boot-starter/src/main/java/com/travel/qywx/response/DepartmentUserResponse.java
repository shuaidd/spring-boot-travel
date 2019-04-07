package com.travel.qywx.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.travel.qywx.dto.WeChatUser;

import java.util.List;

/**
 * 描述
 *
 * @author ddshuai
 * @date 2019-04-05 18:26
 **/
public class DepartmentUserResponse extends AbstractBaseResponse {

    @JsonProperty("userlist")
    private List<WeChatUser> weChatUserList;

    public List<WeChatUser> getWeChatUserList() {
        return weChatUserList;
    }

    public void setWeChatUserList(List<WeChatUser> weChatUserList) {
        this.weChatUserList = weChatUserList;
    }
}
