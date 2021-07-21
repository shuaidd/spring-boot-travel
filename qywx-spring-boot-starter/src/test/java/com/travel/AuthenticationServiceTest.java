package com.travel;

import org.junit.Test;

/**
 * 描述
 *
 * @author ddshuai
 * @date 2019-04-06 21:46
 **/
public class AuthenticationServiceTest extends BaseTest {

    @Test
    public void get(){
        weChatManager.authenticationService().getAuthentication("sdss","address-book");
    }
}
