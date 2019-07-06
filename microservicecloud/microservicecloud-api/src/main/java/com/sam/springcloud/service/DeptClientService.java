package com.sam.springcloud.service;

import com.sam.springcloud.entities.Dept;
import com.sam.springcloud.fallback.DeptClientServiceFallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "MICROSERVICECLOUD-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

    @GetMapping("/dept/get/{id}")
    Dept get(@PathVariable("id") Long id);
    @PostMapping("/dept/add")
    boolean add(Dept dept);
    @GetMapping("/dept/list")
    List<Dept> list();
}
