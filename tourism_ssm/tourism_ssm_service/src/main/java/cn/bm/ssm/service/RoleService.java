package cn.bm.ssm.service;

import cn.bm.ssm.domain.Role;

import java.util.List;

public interface RoleService {

    /**
     * 查询所有
     */
    List<Role> findAll();

    /**
     * 添加用户
     * @param role
     */
    void save(Role role);
}
