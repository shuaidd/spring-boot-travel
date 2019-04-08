package com.travel;

import org.junit.Test;

/**
 * 描述
 *
 * @author ddshuai
 * @date 2019-04-05 16:01
 **/
public class TokenServiceTest extends BaseTest {
    @Test
    public void get() {
        System.out.println(weChatManager.tokenService().getAccessToken("little-helper"));
        System.out.println(weChatManager.tokenService().getAccessToken("little-helper"));
        System.out.println(weChatManager.tokenService().getAccessToken("little-helper"));
        System.out.println(weChatManager.tokenService().getAccessToken("little-helper"));
        System.out.println(weChatManager.tokenService().getAccessToken("little-helper"));
    }
}
