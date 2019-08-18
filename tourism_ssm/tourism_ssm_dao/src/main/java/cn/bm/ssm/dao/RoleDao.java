package cn.bm.ssm.dao;

import cn.bm.ssm.domain.Role;
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
    List<Role> findByUserId(String userId);

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from role")
    List<Role> findAll();

    /**
     * 添加用户
     * @param role
     */
    @Insert("insert into Role (roleName,roleDesc) values (#{roleName},#{roleDesc})")
    void save(Role role);
}
