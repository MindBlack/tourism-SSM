package cn.bm.ssm.service.impl;

import cn.bm.ssm.dao.SysLogDao;
import cn.bm.ssm.domain.SysLog;
import cn.bm.ssm.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogDao sysLogDao;

    /**
     * 查询所有日志信息
     * @return
     */
    @Override
    public List<SysLog> findAll() {
        return sysLogDao.findAll();
    }

    /**
     * 添加日志信息到数据库
     * @param sysLog
     */
    @Override
    public void save(SysLog sysLog) {
        sysLogDao.save(sysLog);
    }
}
