package com.zxy.test;

import com.zxy.dao.IUserDao;
import com.zxy.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @Description: 测试mybatis的一对多(查询所有用户信息及用户关联的账户信息)
 * 用户信息出发查询用户下的账户信息则为一对多查询，因为一个用户可以有多个账户
 * @Author: zhangxy
 * @Date: Created in 2019/11/27
 * @Modified By:
 */
public class UserTest {
    private InputStream input;
    private SqlSession session;
    private IUserDao userDao;

    /**
     * 初始化操作
     *
     * @throws Exception
     */
    @Before // 用于在测试方法执行之前执行
    public void init() throws Exception {
        // 1.读取配置文件
        input = Resources.getResourceAsStream("Mybatis-config.xml");
        // 2.获取SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(input);
        // 3.获取SqlSession 对象
        session = factory.openSession();
        // 4.获取dao接口的代理对象
        userDao = session.getMapper(IUserDao.class);
    }

    @After // 用于在测试方法执行之后执行
    public void destroy() throws Exception {
        // 提交事务
        session.commit();
        // 释放资源
        session.close();
        input.close();
    }

    /**
     * 测试查询所有账户信息
     */
    @Test
    public void testFindAll() {
        List<User> users = userDao.findAll();
        for(User user : users) {
            System.out.println("-------每个用户的信息------");
            System.out.println(user);
            System.out.println(user.getRoles());
        }
    }
}
