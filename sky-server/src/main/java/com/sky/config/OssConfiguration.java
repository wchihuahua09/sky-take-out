package com.sky.config;

import com.sky.properties.AliOssProperties;
import com.sky.utils.AliOssUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类，用于创建alioss对象
 */
@Configuration
@Slf4j
public class OssConfiguration {

    @Bean
    @ConditionalOnMissingBean  //只创建一个
    public AliOssUtil aliOssUtil(AliOssProperties aliOssProperties){
        log.info("开始上传阿里云参数对象");
        return new AliOssUtil(aliOssProperties.getEndpoint(),aliOssProperties.getAccessKeyId(),
                aliOssProperties.getAccessKeySecret(),aliOssProperties.getBucketName());
    }
}
