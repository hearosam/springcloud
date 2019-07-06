package com.sam.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Data
public class Dept implements Serializable {
    private String deptno;//主键
    private String dname;//部门名称
    private String db_source;//来自哪个数据库
}
