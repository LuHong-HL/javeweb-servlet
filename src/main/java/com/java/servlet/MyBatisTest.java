package com.java.servlet;

import com.java.mapper.UserMapper;
import com.java.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    public static void main(String[] args) throws IOException {
        // 1. 加载mybatis核心配置文件，获取 sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取 sqlSession 对象，用来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 执行sql
        // List<User> userList = sqlSession.selectList("test.selectAll");

        // mapper的方式使用
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.selectAll();

        System.out.println(userList);
        System.out.println("我的+++");
        sqlSession.close();
    }
}
