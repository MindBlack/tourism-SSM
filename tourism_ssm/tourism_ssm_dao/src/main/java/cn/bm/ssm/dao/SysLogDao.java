package cn.bm.ssm.dao;

import cn.bm.ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysLogDao {

    /**
     * 查询所有日志信息
     * @return
     */
    @Select("select * from syslog")
    List<SysLog> findAll();

    /**
     * 添加日志到数据库
     * @param sysLog
     */
    @Insert("insert into syslog (visitTime,username,ip,url,executionTime,method) values (#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(SysLog sysLog);

    /*
  id            VARCHAR2(32) default SYS_GUID() not null,
  visittime     TIMESTAMP(6),
  username      VARCHAR2(50),
  ip            VARCHAR2(30),
  url           VARCHAR2(50),
  executiontime INTEGER,
  method        VARCHAR2(200)
     */
}
