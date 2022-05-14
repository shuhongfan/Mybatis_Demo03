package com.shf.mybatis.test;

import com.shf.mybatis.mapper.SQLMapper;
import com.shf.mybatis.pojo.User;
import com.shf.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class SQLMapperTest {
    @Test
    public void getUserByLike(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> userList = mapper.getUserByLike("张");
        userList.forEach(System.out::println);
    }

    @Test
    public void deleteMore(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        int result = mapper.deleteMore("1,2,3");
        System.out.println(result);
    }

    @Test
    public void getUserByTableName(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> userList = mapper.getUserByTableName("t_user");
        userList.forEach(System.out::println);
    }

    @Test
    public void insertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        User u = new User(null, "凡1", "123", 23, "男", "erw@wq.com");
        mapper.insertUser(u);
        System.out.println(u);
    }
}
