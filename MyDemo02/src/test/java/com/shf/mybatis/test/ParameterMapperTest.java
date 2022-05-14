package com.shf.mybatis.test;

import com.shf.mybatis.mapper.ParameterMapper;
import com.shf.mybatis.pojo.User;
import com.shf.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;

public class ParameterMapperTest {
    /**
     * Mybatis获取参数值的两种方式：${}和#{}
     * ${} 本质是字符串拼接
     * #{} 本质是占位符赋值
     */

    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        for (User user : mapper.getAllUser()) {
            System.out.println(user);
        }
    }

    @Test
    public void testGetUserByUsername() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.GetUserByUsername("李四");
        System.out.println(user);
    }

    @Test
    public void testCheckLogin() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLogin("李四", "123");
        System.out.println(user);
    }

    @Test
    public void testCheckLoginByMap() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);

        HashMap<String, Object> map = new HashMap<>();
        map.put("username", "李四");
        map.put("pwd", "123");

        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }

    @Test
    public void insertUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);

        User u = new User(null, "凡", "123", 23, "男", "erw@wq.com");

        int result = mapper.insertUser(u);
        System.out.println(result);
    }


}
