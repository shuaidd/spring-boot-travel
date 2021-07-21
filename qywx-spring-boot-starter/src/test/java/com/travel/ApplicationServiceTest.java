package com.travel;

import com.github.shuaidd.dto.tool.ApplicationButton;
import com.github.shuaidd.enums.ButtonType;
import com.github.shuaidd.response.application.ApplicationButtonResponse;
import com.github.shuaidd.response.application.WeChatApplicationResponse;
import com.github.shuaidd.resquest.application.ApplicationButtonRequest;
import org.junit.Test;

import java.util.Collections;

/**
 * 描述
 *
 * @author ddshuai
 * @date 2019-04-08 15:40
 **/
public class ApplicationServiceTest extends BaseTest {

    @Test
    public void getApplication() {
        WeChatApplicationResponse response = weChatManager.applicationService().getApplication("1000004", "reporter");
        logger.info("{}", response);
    }

    @Test
    public void createApplicationMenu() {
        ApplicationButtonRequest request = new ApplicationButtonRequest();
        ApplicationButton applicationButton = new ApplicationButton();
        applicationButton.setKey("test-click");
        applicationButton.setType(ButtonType.CLICK);
        applicationButton.setName("测试点击");
        request.setButtonList(Collections.singletonList(applicationButton));
        weChatManager.applicationService().createApplicationButton(request,"1000004", "reporter");
    }

    @Test
    public void getApplicationButton() {
        ApplicationButtonResponse response = weChatManager.applicationService().getApplicationButtons("1000004", "reporter");
        logger.info("{}", response);
    }

    @Test
    public void deleteApplicationButton() {
        weChatManager.applicationService().deleteApplicationButtons("1000004", "reporter");
    }
}
