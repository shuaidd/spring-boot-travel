package com.travel;

import com.travel.qywx.dto.ApplicationButton;
import com.travel.qywx.enums.ButtonType;
import com.travel.qywx.response.ApplicationButtonResponse;
import com.travel.qywx.response.WeChatApplicationResponse;
import com.travel.qywx.resquest.ApplicationButtonRequest;
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
