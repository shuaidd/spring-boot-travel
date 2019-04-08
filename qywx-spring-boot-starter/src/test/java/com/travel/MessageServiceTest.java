package com.travel;

import com.travel.qywx.dto.MsgText;
import com.travel.qywx.enums.MsgType;
import com.travel.qywx.resquest.CreateAppChatRequest;
import com.travel.qywx.resquest.SendAppChatRequest;
import com.travel.qywx.resquest.SendMessageRequest;
import com.travel.qywx.resquest.UpdateAppChatRequest;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * 描述
 *
 * @author ddshuai
 * @date 2019-04-08 18:39
 **/
public class MessageServiceTest extends BaseTest {

    @Test
    public void send() {
        SendMessageRequest request = new SendMessageRequest();
        request.setAgentId("1000004");
        request.setText(new MsgText("shuai dd"));
        request.setToUser("20170410022717");
        request.setMsgType(MsgType.TEXT);
        weChatManager.messageService().sendMessage(request, "reporter");
    }


    @Test
    public void sendAppChat() {
        SendAppChatRequest request = new SendAppChatRequest();
        request.setChatId("12523103191213827120");
        request.setText(new MsgText("shuai dd"));
        request.setMsgType(MsgType.TEXT);
        weChatManager.messageService().sendAppChatMessage(request, "reporter");
    }

    @Test
    public void createAppChat() {
        CreateAppChatRequest request = new CreateAppChatRequest();
        request.setName("帥司常");
        request.setOwner("20170410022717");
        request.setUserList(Arrays.asList("20170410022717", "SiGuangMeng"));
        String id = weChatManager.messageService().createAppChat(request, "reporter");
        logger.info("群聊id:{}", id);
    }

    @Test
    public void updateAppChat() {
        UpdateAppChatRequest request = new UpdateAppChatRequest();
        request.setChatId("12523103191213827120");
        request.setAddUserList(Collections.singletonList("13259220281"));
        weChatManager.messageService().updateAppChat(request, "reporter");
    }

    @Test
    public void getAppChat() {
        weChatManager.messageService().searchAppChat("12523103191213827120", "reporter");
    }
}
