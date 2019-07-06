package com.sam.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sam.springcloud.entities.Dept;
import com.sam.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService service;
    @Autowired
    private DiscoveryClient eurekaClient;

    @PostMapping("/dept/add")
    public boolean add(@RequestBody Dept dept) {
        return service.add(dept);
    }
    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "processHystrix_get")
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = service.get(id);
        if(dept == null) {
            throw new RuntimeException("xixi");
        }
        return dept;
    }
    @GetMapping("/dept/list")
    public List<Dept> list() {
        return service.list();
    }
    @GetMapping("/dept/discovery")
    public Object discovery() {
        return this.eurekaClient;
    }

    public Dept processHystrix_get(@PathVariable("id") Long id) {

        Dept errorObj = new Dept();
        errorObj.setDname("该id"+id+",没有对应的信息 null @processHystrix_get");
        errorObj.setDb_source("no this in databases");
        return errorObj;
    }
}
