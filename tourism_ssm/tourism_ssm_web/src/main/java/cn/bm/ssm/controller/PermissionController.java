package cn.bm.ssm.controller;

import cn.bm.ssm.domain.Permission;
import cn.bm.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 资源权限相关的操作
 */
@Controller
@RequestMapping("permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    /**
     * 查询所有权限
     * @param model
     * @return
     */
    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Permission> permissionList = permissionService.findAll();
        model.addAttribute("permissionList",permissionList);
        return "permission-list";
    }

    /**
     * 添加权限
     * @param permission
     * @return
     */
    @RequestMapping("/save")
    public String save(Permission permission){
        permissionService.save(permission);
        return "redirect:findAll.do";
    }
}
