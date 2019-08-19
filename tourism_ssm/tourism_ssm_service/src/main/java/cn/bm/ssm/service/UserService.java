package cn.bm.ssm.service;

import cn.bm.ssm.domain.Role;
import cn.bm.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    /**
     * 查询所有的用户
     * @return
     */
    List<UserInfo> findAll() throws Exception;

    /**
     * 添加用户
     * @param userInfo
     */
    void save(UserInfo userInfo) throws Exception;

    /**
     * 通过id查询用户信息
     * @param id
     * @return
     */
    UserInfo findById(String id) throws Exception;

    /**
     * 通过id查询用户所没有的权限并进行添加
     * @param userId
     * @return
     */
    List<Role> findUserByIdAndRole(String userId) throws Exception;

    /**
     * 给用户添加角色
     * @param userId
     * @param ids
     */
    void addRoleToUser(String userId, String[] ids)throws Exception;
}
