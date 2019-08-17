package cn.bm.ssm.domain;

import java.util.List;

/**
 * 资源权限表
 */
public class Permission {
    /*
  id             VARCHAR2(32) default SYS_GUID() not null,  // --->主键
  permissionName VARCHAR2(50),  // --->权限名
  url            VARCHAR2(50)   // --->资源路径
     */
    private String id;
    private String permissionName;
    private String url;
    private List<Role> roleList;

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
