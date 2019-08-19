package cn.bm.ssm.domain;

import java.util.Date;

public class SysLog {
    /*
  id            VARCHAR2(32) default SYS_GUID() not null,  // --->主键
  visitTime     TIMESTAMP(6),  // --->访问时间
  username      VARCHAR2(50),  // --->访问用户
  ip            VARCHAR2(30),  // --->访问ip
  url           VARCHAR2(50),  // --->访问路径
  executionTime INTEGER,       // --->执行时长
  method        VARCHAR2(200)  //---->访问方法
     */

    private String id;
    private Date visitTime;
    private String username;
    private String ip;
    private String url;
    private long executionTime;
    private String method;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(long executionTime) {
        this.executionTime = executionTime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
