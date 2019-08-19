package cn.bm.ssm.service.impl;

import cn.bm.ssm.dao.RoleDao;
import cn.bm.ssm.dao.UserDao;
import cn.bm.ssm.domain.Role;
import cn.bm.ssm.domain.UserInfo;
import cn.bm.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    /**
     * 给用户添加角色
     * @param userId
     * @param ids
     */
    @Override
    public void addRoleToUser(String userId, String[] ids)throws Exception {
        for (String roleId : ids) {
            userDao.addRoleToUser(userId,roleId);
        }
    }

    /**
     * 通过id查询用户所没有的权限并进行添加
     * @param userId
     * @return
     */
    @Override
    public List<Role> findUserByIdAndRole(String userId) throws Exception {
        return roleDao.findUserByIdAndRole(userId);
    }

    /**
     * 通过id查询用户信息
     * @param id
     * @return
     */
    @Override
    @RolesAllowed("USER")
    public UserInfo findById(String id) throws Exception {
        return userDao.findById(id);
    }

    /**
     * 添加用户  --->事务已经开启
     * @param userInfo
     */
    @Override
    public void save(UserInfo userInfo) throws Exception {
        userInfo.setPassword(new BCryptPasswordEncoder().encode(userInfo.getPassword()));
        userDao.save(userInfo);
    }

    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<UserInfo> findAll() throws Exception {
        return userDao.findAll();
    }

    /**
     * 登录
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = userDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //处理自己的用户对象封装成userDetails
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus()==1?true:false,true,true,true,getAuthorities(userInfo.getRoleList()));
        return user;
    }

    //实现登录自己给与授权
    private List<SimpleGrantedAuthority> getAuthorities(List<Role> roleList){
        List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
        for (Role role : roleList) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }
}
