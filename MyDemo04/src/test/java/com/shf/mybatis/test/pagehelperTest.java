package com.shf.mybatis.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shf.mybatis.mapper.EmpMapper;
import com.shf.mybatis.pojo.Emp;
import com.shf.mybatis.pojo.EmpExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class pagehelperTest {
    @Test
    public void test(){
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

            PageHelper.startPage(1,4);
            List<Emp> empList = mapper.selectByExample(null);
            PageInfo<Emp> pageInfo = new PageInfo<>(empList, 3);
            System.out.println(pageInfo);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
