package cn.bm.ssm.service.impl;

import cn.bm.ssm.dao.PermissionDao;
import cn.bm.ssm.dao.RoleDao;
import cn.bm.ssm.domain.Permission;
import cn.bm.ssm.domain.Role;
import cn.bm.ssm.domain.Role_Permission;
import cn.bm.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PermissionDao permissionDao;

    /**
     * 个角色添加权限
     * @param roleId
     * @param ids
     */
    @Override
    public void addPermissionToRole(String roleId, String[] ids , Role_Permission role_permission) {
        role_permission.setRoleId(roleId);
        for (String permissionId : ids) {
            role_permission.setPermissionId(permissionId);
            roleDao.addPermissionToRole(role_permission);
        }
    }

    /**
     * 通过角色id查询未添加的资源权限
     * @param roleId
     * @return
     * @throws Exception
     */
    @Override
    public List<Permission> findRoleByIdAndAllPermission(String roleId) throws Exception {
        return permissionDao.findRoleByIdAndAllPermission(roleId);
    }

    /**
     * 根据id查询角色
     * @param id
     * @return
     */
    @Override
    public Role findById(String id) {
        return roleDao.findById(id);
    }

    /**
     * 添加
     * @param role
     */
    @Override
    @Secured("ROLE_SAVE")
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    /**
     * 查询所有数据返回
     * @return
     */
    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }
}
