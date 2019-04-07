package com.travel;

import com.travel.qywx.service.TokenService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 描述
 *
 * @author ddshuai
 * @date 2019-04-05 16:01
 **/
public class TokenServiceTest extends BaseTest {
    @Autowired
    private TokenService tokenService;

    @Test
    public void get() {
        System.out.println(tokenService.getAccessToken("little-helper"));
        System.out.println(tokenService.getAccessToken("little-helper"));
        System.out.println(tokenService.getAccessToken("little-helper"));
        System.out.println(tokenService.getAccessToken("little-helper"));
        System.out.println(tokenService.getAccessToken("little-helper"));
    }
}
