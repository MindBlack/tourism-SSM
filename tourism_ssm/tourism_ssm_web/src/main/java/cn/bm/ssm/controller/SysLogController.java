package cn.bm.ssm.controller;

import cn.bm.ssm.domain.SysLog;
import cn.bm.ssm.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<SysLog> sysLogList = sysLogService.findAll();
        model.addAttribute("sysLogList",sysLogList);
        return "syslog-list";
    }


}
