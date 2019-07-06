package com.sam.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //启用eureka客户端
@EnableDiscoveryClient //启用eureka服务发现
public class DeptApp8003 {
    public static void main(String[] args) {
        SpringApplication.run(DeptApp8003.class,args);
    }
}
