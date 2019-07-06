package com.sam.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <h1>配置类</h1>
 */
@Configuration
public class ConfigBean {//等价于spring的applicationContext.xml文件

    @Bean
    @LoadBalanced //启用ribbon客户端负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
