package cn.bm.ssm.aop;

import cn.bm.ssm.domain.SysLog;
import cn.bm.ssm.service.SysLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

//注解扫描
@Controller
//切面类
@Aspect
public class LogAop {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SysLogService sysLogService;

    //定义环绕通知
    @Around("execution(* cn.bm.ssm.controller.*.*(..))")
    public Object saveLog(ProceedingJoinPoint joinPoint) {
        try {
    /*
  visitTime     TIMESTAMP(6),  // --->访问时间
  username      VARCHAR2(50),  // --->访问用户
  ip            VARCHAR2(30),  // --->访问ip
  url           VARCHAR2(50),  // --->访问路径
  executionTime INTEGER,       // --->执行时长
  method        VARCHAR2(200)  //---->访问方法
     */
            Date visitTime = new Date();  //访问时间
            String username = SecurityContextHolder.getContext().getAuthentication().getName(); //访问用户
            long start = System.currentTimeMillis();
            Object proceed = joinPoint.proceed();
            String ip = request.getRemoteAddr(); // id
            String url = request.getRequestURI(); //url
            long end = System.currentTimeMillis();
            long executionTime = end - start; //访问时长
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            String method =className + "." + methodName; //访问方法
            SysLog sysLog = new SysLog();
            sysLog.setVisitTime(visitTime);
            sysLog.setUsername(username);
            sysLog.setIp(ip);
            sysLog.setUrl(url);
            sysLog.setExecutionTime(executionTime);
            sysLog.setMethod(method);
            //打印一下..代用service层保存
            sysLogService.save(sysLog);
            return proceed;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }


}
