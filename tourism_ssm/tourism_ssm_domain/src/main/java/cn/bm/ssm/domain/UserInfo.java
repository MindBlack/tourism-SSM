package cn.bm.ssm.domain;

import java.util.List;

/**
 * 与数据库中users对应
 */
public class UserInfo {
    /*
  id       VARCHAR2(32) default SYS_GUID() not null,  // --->主键
  email    VARCHAR2(50) not null,  // --->邮箱
  username VARCHAR2(50), // --->用户名
  password VARCHAR2(50), // --->密码
  phoneNum VARCHAR2(20), // --->电话号
  status   INTEGER  //  状态0 未开启 1 开启
     */

    private String id;
    private String email;
    private String username;
    private String password;
    private String phoneNum;
    private Integer status;
    private String statusStr;
    private List<Role> roleList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusStr() {
        if (status!=null){
            //0 未开启 1 开启
            if (status==0)
                statusStr="未开启";
            if (status==1)
                statusStr="开启";
        }
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
