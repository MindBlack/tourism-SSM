package cn.bm.ssm.service;

import cn.bm.ssm.domain.Permission;
import cn.bm.ssm.domain.Role;
import cn.bm.ssm.domain.Role_Permission;

import java.util.List;

public interface RoleService {

    /**
     * 查询所有
     */
    List<Role> findAll() throws Exception;

    /**
     * 添加用户
     * @param role
     */
    void save(Role role) throws Exception;

    /**
     * 根据用户查询角色
     * @param id
     * @return
     */
    Role findById(String id);

    /**
     * 根据角色查询资源权限
     * @param roleId
     * @return
     */
    List<Permission> findRoleByIdAndAllPermission(String roleId)throws Exception;

    /**
     * 给用户添加资源权限
     * @param roleId
     * @param ids
     */
    void addPermissionToRole(String roleId, String[] ids, Role_Permission role_permission);
}
