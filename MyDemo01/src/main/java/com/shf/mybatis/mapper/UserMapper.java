package com.shf.mybatis.mapper;

import com.shf.mybatis.pojo.User;

import java.util.List;

/**
 * 面向接口编程
 *
 * Mybatis面向接口编程的两个一致
 * 1.映射文件的namespace要和Mapper接口的全类名保持一致
 * 2.映射文件中SQL语句的id和mapper接口中的方法名保持一致
 */
public interface UserMapper {
    /**
     * 添加用户信息
     */
    int insertUser();

    /**
     * 修改用户信息
     */
    void updateUser();

    User getUserById();

    List<User> getUserList();
}
