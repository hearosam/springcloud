package com.sam.springcloud.controller;

import com.sam.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController_Consumer {

    @Autowired
    private RestTemplate template;
//    private static final String PRODUCER_PROFIX_URL = "http://localhost:8001/";
    //使用eureka server上的服务名称，而不是写死url
    private static final String PRODUCER_PROFIX_URL = "http://MICROSERVICECLOUD-DEPT/";

    @GetMapping("/consumer/dept/list")
    public List<Dept> list() {
        return template.getForObject(PRODUCER_PROFIX_URL+"dept/list",List.class);
    }
    @GetMapping("/consumer/dept/add")
    public boolean add(@RequestBody  Dept dept) {
        return template.postForObject(PRODUCER_PROFIX_URL+"dept/add",dept,Boolean.class);
    }
    @GetMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return template.getForObject(PRODUCER_PROFIX_URL+"dept/get/"+id,Dept.class);
    }



}
