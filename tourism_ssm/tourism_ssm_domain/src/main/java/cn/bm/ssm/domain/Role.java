package cn.bm.ssm.domain;

import java.util.List;

/**
 * 角色表
 */
public class Role {
    /*
  id       VARCHAR2(32) default SYS_GUID() not null,  // --->主键
  roleName VARCHAR2(50),  // --->角色名
  roleDesc VARCHAR2(50)   // --->角色描述
     */
    private String id;
    private String roleName;
    private String roleDesc;
    private List<Permission> permissionList;  // --->角色表
    private List<UserInfo> userList;        // --->用户表

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }

    public List<UserInfo> getUserList() {
        return userList;
    }

    public void setUserList(List<UserInfo> userList) {
        this.userList = userList;
    }
}
