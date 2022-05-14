package com.shf.mybatis.test;

import com.shf.mybatis.mapper.CacheMapper;
import com.shf.mybatis.pojo.Emp;
import com.shf.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CacheMapperTest {
    @Test
    public void getEmpByEid(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp = mapper.getEmpByEid(1);
        System.out.println(emp);
        emp = mapper.getEmpByEid(1);
        System.out.println(emp);
    }

    @Test
    public void getEmpByEidTwoCache() {
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
            System.out.println(mapper.getEmpByEid(1));
            sqlSession.close();

            SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
            CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
            System.out.println(mapper2.getEmpByEid(1));
            sqlSession2.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
