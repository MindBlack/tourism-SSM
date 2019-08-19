package cn.bm.ssm.controller;

import cn.bm.ssm.domain.Permission;
import cn.bm.ssm.domain.Role;
import cn.bm.ssm.domain.Role_Permission;
import cn.bm.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 角色相关操作
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 给用户添加资源权限
     * @return
     */
    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(String roleId , String[] ids, Role_Permission role_permission){
        roleService.addPermissionToRole(roleId,ids,role_permission);
        return "redirect:findAll.do";
    }

    /**
     * 通过角色Id查询资源权限展示
     * @param id
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/findRoleByIdAndAllPermission")
    public String findRoleByIdAndAllPermission(String id, Model model) throws Exception {
        Role role = roleService.findById(id);
        List<Permission> permissionList = roleService.findRoleByIdAndAllPermission(id);
        model.addAttribute("role",role);
        model.addAttribute("permissionList",permissionList);
        return "role-permission-add";
    }

    /**
     * 查询所有角色
     *
     * @param model
     * @return
     */
    @Secured("ROLE_ADMIN")
    @RequestMapping("/findAll")
    public String findAll(Model model) throws Exception {
        List<Role> roleList = roleService.findAll();
        model.addAttribute("roleList", roleList);
        return "role-list";
    }

    @RequestMapping("/save")
    public String save(Role role) throws Exception {
        roleService.save(role);
        return "redirect:findAll.do";
    }


}
