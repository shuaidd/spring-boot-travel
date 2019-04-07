package com.travel.qywx.service;

import com.travel.qywx.response.WeChatApplicationResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * 应用管理
 *
 * @author ddshuai
 * @date 2019-04-06 21:53
 **/
@Service
public class ApplicationService extends AbstractBaseService {

    /**
     * 获取应用
     *
     * @param agentId
     * @param applicationName
     * @return
     */
    public WeChatApplicationResponse getApplication(String agentId, String applicationName) {
        WeChatApplicationResponse response = null;
        if (StringUtils.isNotEmpty(agentId)) {
            response = weChatClient.getApplication(agentId, applicationName);
            if (isSuccess(response)) {
                logger.info("应用获取成功");
            }
        }

        return response;
    }

}
