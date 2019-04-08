package com.travel.qywx.service;

import com.travel.qywx.dto.ChatInfo;
import com.travel.qywx.response.BaseResponse;
import com.travel.qywx.response.CreateAppChatResponse;
import com.travel.qywx.response.SearchAppChatResponse;
import com.travel.qywx.response.SendMessageResponse;
import com.travel.qywx.resquest.CreateAppChatRequest;
import com.travel.qywx.resquest.SendAppChatRequest;
import com.travel.qywx.resquest.SendMessageRequest;
import com.travel.qywx.resquest.UpdateAppChatRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

/**
 * 描述
 *
 * @author ddshuai
 * @date 2019-04-08 16:51
 **/
@Service
public class MessageService extends AbstractBaseService {

    /**
     * 发送消息
     *
     * @param request
     * @param applicationName
     * @return
     */
    public SendMessageResponse sendMessage(SendMessageRequest request, String applicationName) {
        SendMessageResponse response = null;
        if (Objects.nonNull(request)) {
            response = weChatClient.sendMessage(request, applicationName);
            if (isSuccess(response)) {
                logger.info("消息发送成功");
            }
        }

        return response;
    }

    /**
     * 发送群消息
     *
     * @param request
     * @param applicationName
     */
    public void sendAppChatMessage(SendAppChatRequest request, String applicationName) {
        if (Objects.nonNull(request)) {
            BaseResponse response = weChatClient.sendAppChatMessage(request, applicationName);
            if (isSuccess(response)) {
                logger.info("消息发送成功");
            }
        }
    }

    /**
     * 创建群聊
     *
     * @param request
     * @param applicationName
     * @return
     */
    public String createAppChat(CreateAppChatRequest request, String applicationName) {
        String chatId = "";
        if (Objects.nonNull(request)) {
            CreateAppChatResponse response = weChatClient.createAppChat(request, applicationName);
            if (isSuccess(response)) {
                chatId = response.getChatId();
            }
        }

        return chatId;
    }

    /**
     * 修改群聊会话
     *
     * @param request
     * @param applicationName
     */
    public void updateAppChat(UpdateAppChatRequest request, String applicationName) {
        if (Objects.nonNull(request)) {
            BaseResponse response = weChatClient.updateAppChat(request, applicationName);
            if (isSuccess(response)) {
                logger.info("更新群聊成功");
            }
        }
    }

    /**
     * 获取群聊会话
     *
     * @param chatId
     * @param applicationName
     * @return
     */
    public ChatInfo searchAppChat(String chatId, String applicationName) {
        ChatInfo chatInfo = null;
        if (StringUtils.isNotEmpty(chatId)) {
            SearchAppChatResponse response = weChatClient.searchAppChat(chatId, applicationName);
            if (isSuccess(response)) {
                chatInfo = response.getChatInfo();
                logger.info("查询到的群聊信息：{}", chatInfo);
            }
        }

        return chatInfo;
    }
}
