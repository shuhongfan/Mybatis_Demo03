package com.shf.mybatis.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Dept implements Serializable {
    private Integer did;
    private String deptName;

    private List<Emp> emps;
}
