package cn.bm.ssm.dao;

import cn.bm.ssm.domain.Role;
import cn.bm.ssm.domain.Role_Permission;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleDao {

    /**
     * 根据userId查询
     *   ------>>>根据查出的角色查询资源权限
     * @param userId
     * @return
     */
    @Select("select * from Role where id in (select roleId from users_role where userId = #{userId}) ")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissionList",column = "id" ,many = @Many(select = "cn.bm.ssm.dao.PermissionDao.findByRoleId")),
    })
    List<Role> findByUserId(String userId) throws Exception;

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from role")
    List<Role> findAll() throws Exception;

    /**
     * 添加用户
     * @param role
     */
    @Insert("insert into Role (roleName,roleDesc) values (#{roleName},#{roleDesc})")
    void save(Role role) throws Exception;

    /**
     * 通过id查询用户所没有的权限并进行添加
     * @param userId
     */
    @Select("select * from role where id not in (select roleId from users_role where userId = #{userId})")
    List<Role> findUserByIdAndRole(String userId)throws Exception;

    /**
     * 根据id查询角色
     * @param id
     * @return
     */
    @Select("select * from role where id = #{id}")
    Role findById(String id);

    /**
     * 给用户添加资源权限
     * @param role_permission
     */
    @Insert("insert into role_permission (roleId,permissionId) values (#{roleId},#{permissionId})")
    void addPermissionToRole(Role_Permission role_permission);
}
