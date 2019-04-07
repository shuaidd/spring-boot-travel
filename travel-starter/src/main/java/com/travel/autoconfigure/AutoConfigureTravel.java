package com.travel.autoconfigure;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 描述
 *
 * @author ddshuai
 * @date 2019-04-02 15:57
 **/

@Configuration
@EnableConfigurationProperties(AutoConfigureTravelProperties.class)
public class AutoConfigureTravel {

}
