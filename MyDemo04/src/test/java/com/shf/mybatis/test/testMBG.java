package com.shf.mybatis.test;

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

public class testMBG {
    @Test
    public void test(){
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
//            查询所有数据
//            List<Emp> empList = mapper.selectByExample(null);
//            empList.forEach(System.out::println);

            EmpExample example = new EmpExample();
            example.createCriteria().andEmpNameEqualTo("张三");
            example.or().andDidIsNotNull();
            List<Emp> empList = mapper.selectByExample(example);
            empList.forEach(System.out::println);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
