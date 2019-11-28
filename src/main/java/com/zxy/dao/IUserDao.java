package com.zxy.dao;

import com.zxy.pojo.User;

import java.util.List;

/**
 * @Description: 用户的持久层接口
 * @Author: zhangxy
 * @Date: Created in 2019/11/27
 * @Modified By:
 */
public interface IUserDao {
    /**
     * 查询所有用户，并获取用户下的所有账户信息
     *
     * @return
     */
    List<User> findAll();

    /**
     * 根据id 查询用户信息
     *
     * @param userId
     * @return
     */
    User findById(Integer userId);

}
