package cn.bm.ssm.domain;

/**
 * 会员表
 */
public class Member {
    /*
  id       VARCHAR2(32) default SYS_GUID() not null,  // --->主键
  name     VARCHAR2(20),  // --->名字
  nickName VARCHAR2(20),  // --->昵称
  phoneNum VARCHAR2(20),  // --->电话号码
  email    VARCHAR2(20)   // --->邮箱
 */
    private String id;
    private String name;
    private String nickName;
    private String phoneNum;
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
