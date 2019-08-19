package cn.bm.ssm.service;

import cn.bm.ssm.domain.SysLog;

import java.util.List;

public interface SysLogService {

    /**
     * 添加日志
     * @param sysLog
     */
    void save(SysLog sysLog);

    /**
     * 查询所有日志信息
     * @return
     */
    List<SysLog> findAll();
}
