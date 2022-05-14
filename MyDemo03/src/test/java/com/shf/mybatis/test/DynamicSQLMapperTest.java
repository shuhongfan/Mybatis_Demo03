package com.shf.mybatis.test;

import com.shf.mybatis.mapper.DynamicSQLMapper;
import com.shf.mybatis.pojo.Emp;
import com.shf.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DynamicSQLMapperTest {
    @Test
    public void DynamicSQLMapper(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> condition = mapper.getEmpByCondition(new Emp(null, "张三", 23, "男", "32r22@qq.com", null));
        System.out.println(condition);
    }

    @Test
    public void getEmpByChoose(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> emp = mapper.getEmpByChoose(new Emp(null, "张三", 23, "男", "32r22@qq.com", null));
        System.out.println(emp);
    }

    @Test
    public void deleteMoreByArray(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        int result = mapper.deleteMoreByArray(new Integer[]{6, 7, 8});
        System.out.println(result);
    }

    @Test
    public void insertMoreByList(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null, "emp1", 23, "男", "32r22@qq.com", null);
        Emp emp2 = new Emp(null, "emp2", 13, "女", "32r22@qq.com", null);
        Emp emp3 = new Emp(null, "emp3", 43, "男", "32r22@qq.com", null);
        List<Emp> emps = Arrays.asList(emp1, emp2, emp3);
        System.out.println(mapper.insertMoreByList(emps));
    }
}
