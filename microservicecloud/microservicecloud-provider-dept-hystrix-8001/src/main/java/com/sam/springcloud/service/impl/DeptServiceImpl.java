package com.sam.springcloud.service.impl;

import com.sam.springcloud.dao.DeptDao;
import com.sam.springcloud.entities.Dept;
import com.sam.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao dao;

    @Override
    public Dept get(Long id) {
        return dao.findById(id);
    }

    @Override
    public boolean add(Dept dept) {
        return dao.addDept(dept);
    }

    @Override
    public List<Dept> list() {
        return dao.findAll();
    }
}
