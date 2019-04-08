package com.travel;

import com.travel.qywx.support.WeChatManager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
