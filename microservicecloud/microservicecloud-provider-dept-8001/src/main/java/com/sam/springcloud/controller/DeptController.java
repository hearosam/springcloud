package com.sam.springcloud.controller;

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
    public Dept get(@PathVariable("id") Long id) {
        return service.get(id);
    }
    @GetMapping("/dept/list")
    public List<Dept> list() {
        return service.list();
    }
    @GetMapping("/dept/discovery")
    public Object discovery() {
        return this.eurekaClient;
    }


}
