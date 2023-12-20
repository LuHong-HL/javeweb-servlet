package com.java.mapper;

import com.java.pojo.User;

import java.util.List;

/**
 * 获取所有用户
 */
public interface UserMapper {
    List<User> selectAll();
}
