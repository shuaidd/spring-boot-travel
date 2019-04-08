package com.travel.qywx.service;

import com.travel.qywx.autoconfigure.ApplicationProperties;
import com.travel.qywx.autoconfigure.WeChatConfigurationProperties;
import com.travel.qywx.client.WeChatClient;
import com.travel.qywx.client.WeChatMediaClient;
import com.travel.qywx.enums.ErrorCode;
import com.travel.qywx.exception.WeChatException;
import com.travel.qywx.response.AbstractBaseResponse;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

/**
 * 描述
 *
 * @author ddshuai
 * @date 2019-04-04 14:24
 **/
public abstract class AbstractBaseService {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected WeChatClient weChatClient;

    @Autowired
    protected WeChatMediaClient weChatMediaClient;

    @Autowired
    protected WeChatConfigurationProperties properties;

    boolean isSuccess(AbstractBaseResponse baseResponse) {
        if (Objects.nonNull(baseResponse)) {
            if (ErrorCode.ERROR_CODE_0.getErrorCode().equals(baseResponse.getErrCode().toString())) {
                return true;
            } else {
                ErrorCode errorCode = ErrorCode.errorCode(baseResponse.getErrCode());
                logger.error("企业微信调用异常：errorCode[{}],msg:[{}],response:{}", errorCode.getErrorCode(), errorCode.getErrorDesc(), baseResponse.getErrMsg());
                throw new WeChatException(errorCode.getErrorDesc(), errorCode);
            }
        } else {
            return false;
        }

    }

    /**
     * 获取应用密匙
     *
     * @param applicationName
     * @return
     */
    String getApplicationSecret(String applicationName) {
        String secret = "";
        List<ApplicationProperties> list = properties.getApplicationList();
        if (CollectionUtils.isNotEmpty(list)) {
            for (ApplicationProperties applicationProperties : list) {
                if (Objects.equals(applicationName, applicationProperties.getApplicationName())) {
                    secret = applicationProperties.getSecret();
                }
            }
        }
        if (StringUtils.isEmpty(secret)) {
            //不存在的应用 则抛出异常
            throw new WeChatException(applicationName + "应用不存在密匙");
        }

        return secret;
    }
}
