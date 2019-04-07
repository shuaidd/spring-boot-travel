package com.travel;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 描述
 *
 * @author ddshuai
 * @date 2019-04-03 20:26
 **/
@SpringBootTest(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseTest {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
}
