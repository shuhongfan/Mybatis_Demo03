package com.shf.mybatis.test;

import com.shf.mybatis.mapper.UserMapper;
import com.shf.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    public static void main(String[] args) throws IOException {
        /**
         * sqlSessuion默认不自动提交事务，若需要自动提交事务 openSession(true)
         */
        //    加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
//        获取SQLSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
//        获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
//        获取SQLSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//        获取mapper接口对象  代理模式
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        测试功能
        int result = mapper.insertUser();
//        提交事务
//        sqlSession.commit();
        System.out.println("result="+result);
    }

    @Test
    public void testCURD() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        mapper.updateUser();
//        User user = mapper.getUserById();
//        System.out.println(user);

        List<User> list = mapper.getUserList();
        list.forEach(user -> System.out.println(user));
    }
}
