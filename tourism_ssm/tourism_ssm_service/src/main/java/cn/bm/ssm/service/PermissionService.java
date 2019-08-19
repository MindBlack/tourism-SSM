package cn.bm.ssm.service;

import cn.bm.ssm.domain.Permission;

import java.util.List;

public interface PermissionService {

    /**
     * 查询所有权限
     * @return
     */
    List<Permission> findAll() throws Exception;

    /**
     * 添加权限
     * @param permission
     */
    void save(Permission permission) throws Exception;
}
