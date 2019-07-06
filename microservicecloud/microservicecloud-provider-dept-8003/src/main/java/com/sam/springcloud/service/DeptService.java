package com.sam.springcloud.service;

import com.sam.springcloud.entities.Dept;

import java.util.List;

public interface DeptService {
    Dept get(Long id);
    boolean add(Dept dept);
    List<Dept> list();
}
