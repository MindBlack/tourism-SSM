package cn.bm.ssm.service.impl;

import cn.bm.ssm.dao.RoleDao;
import cn.bm.ssm.domain.Role;
import cn.bm.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    /**
     * 添加
     * @param role
     */
    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    /**
     * 查询所有数据返回
     * @return
     */
    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }
}
