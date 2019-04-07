package com.travel;

import com.travel.qywx.service.AuthenticationService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 描述
 *
 * @author ddshuai
 * @date 2019-04-06 21:46
 **/
public class AuthenticationServiceTest extends BaseTest {
    @Autowired
    private AuthenticationService authenticationService;

    @Test
    public void get(){
        authenticationService.getAuthentication("sdss","address-book");
    }
}
