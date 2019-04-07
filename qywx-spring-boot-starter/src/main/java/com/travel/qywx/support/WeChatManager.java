package com.travel.qywx.support;

import com.travel.qywx.autoconfigure.WeChatConfigurationProperties;
import com.travel.qywx.service.AddressBookService;
import com.travel.qywx.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 描述
 *
 * @author ddshuai
 * @date 2019-04-03 16:10
 **/
@Component
public class WeChatManager {

    private final AddressBookService addressBookService;
    private final TokenService tokenService;
    private final WeChatConfigurationProperties properties;

    @Autowired
    public WeChatManager(AddressBookService addressBookService, TokenService tokenService, WeChatConfigurationProperties properties) {
        this.addressBookService = addressBookService;
        this.tokenService = tokenService;
        this.properties = properties;
    }

    /**
     * 通讯录管理服务
     *
     * @return
     */
    public AddressBookService addressBookService() {
        return addressBookService;
    }

    /**
     * 令牌管理服务
     *
     * @return
     */
    public TokenService tokenService() {
        return tokenService;
    }

    /**
     * 企业微信配置信息
     * @return
     */
    public WeChatConfigurationProperties properties(){
        return properties;
    }

}
