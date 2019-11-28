package com.zxy.test;

import com.zxy.dao.IRoleDao;
import com.zxy.dao.IUserDao;
import com.zxy.pojo.Role;
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
 * @Description: 多对多
 * @Author: zhangxy
 * @Date: Created in 2019/11/27
 * @Modified By:
 */
public class RoleTest {
    private InputStream input;
    private SqlSession session;
    private IRoleDao roleDao;

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
        roleDao = session.getMapper(IRoleDao.class);
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
       List<Role> roles = roleDao.findAll();
       for (Role role : roles) {
           System.out.println("-------每个角色信息-----");
           System.out.println(role);
           System.out.println(role.getUsers());
       }
    }

}
