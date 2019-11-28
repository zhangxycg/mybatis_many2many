package com.zxy.dao;

import com.zxy.pojo.Role;

import java.util.List;

/**
 * @Description:
 * @Author: zhangxy
 * @Date: Created in 2019/11/27
 * @Modified By:
 */
public interface IRoleDao {

    /**
     * 查询所有角色
     * @return
     */
    List<Role> findAll();
}
