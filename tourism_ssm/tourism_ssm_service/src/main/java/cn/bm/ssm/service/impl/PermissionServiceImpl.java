package cn.bm.ssm.service.impl;

import cn.bm.ssm.dao.PermissionDao;
import cn.bm.ssm.domain.Permission;
import cn.bm.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    /**
     * 添加权限
     * @param permission
     */
    @PreAuthorize("principal.username=='black' and hasRole('ROLE_SAVE')")
    @Override
    public void save(Permission permission)throws Exception {
        permissionDao.save(permission);
    }

    /**
     * 查询所有权限
     * @return
     */
    @Override
    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }
}
