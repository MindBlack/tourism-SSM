package cn.bm.ssm.dao;

import cn.bm.ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionDao {

    /**
     * 查询所有权限
     * @return
     */
    @Select("select * from permission")
    List<Permission> findAll() throws Exception;

    /**
     * 根据roleId查询对应资源权限展示
     * @param roleId
     * @return
     */
    @Select("select * from permission where id in (select permissionId from Role_Permission where roleId = #{roleId})")
    List<Permission> findByRoleId(String roleId) throws Exception;

    /**
     * 添加权限
     * @param permission
     */
    @Insert("insert into permission (permissionName,url) values (#{permissionName},#{url})")
    void save(Permission permission) throws Exception;

    /**
     * 通过id查询未添加的资源权限
     * @param roleId
     * @return
     */
    @Select("select * from permission where id not in (select permissionId from Role_Permission where roleId = #{roleId})")
    List<Permission> findRoleByIdAndAllPermission(String roleId);
}
