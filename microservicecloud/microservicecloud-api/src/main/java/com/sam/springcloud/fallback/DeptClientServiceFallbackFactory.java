package com.sam.springcloud.fallback;

import com.sam.springcloud.entities.Dept;
import com.sam.springcloud.service.DeptClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 针对部门消费者客户端的统一服务降级处理 fallbackFactory
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {

        return new DeptClientService() {
            @Override
            public Dept get(Long id) {
                return new Dept()
                        .setDb_source("该ID："+id+"没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭")
                        .setDname("no this database in MySQL");
            }

            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public List<Dept> list() {
                List<Dept> list = new ArrayList<>();
                Dept dept = new Dept();
                dept.setDname("获取列表异常，comsumer提供服务降级信息");
                dept.setDb_source("get dept list exception comsumer apply exception info ");
                list.add(dept);
                return list;
            }
        };
    }
}
