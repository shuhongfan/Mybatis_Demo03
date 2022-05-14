package com.shf.mybatis.mapper;

import com.shf.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface CacheMapper {
    Emp getEmpByEid(@Param("eid") Integer eid);
}
