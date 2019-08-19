package cn.bm.ssm.controller;

import cn.bm.ssm.domain.Role;
import cn.bm.ssm.domain.UserInfo;
import cn.bm.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * user相关的controller
 */
@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(String userId,String[] ids)throws Exception{
        userService.addRoleToUser(userId,ids);
//        return "redirect:findAll.do";
        return "redirect:findById.do?id="+userId;
    }

    /**
     * 通过id查询用户所没有的权限并进行添加
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/findUserByIdAndAllRole")
    public String findUserByIdAndAllRole(String id , Model model) throws Exception{
        UserInfo user = userService.findById(id);
        List<Role> roleList = userService.findUserByIdAndRole(id);
        model.addAttribute("roleList",roleList);
        model.addAttribute("user",user);
        return "user-role-add";
    }

    /**
     * 查询用户详情
     * @return
     */
    @RequestMapping("/findById")
    public String findById(String id , Model model) throws Exception {
        UserInfo user = userService.findById(id);
        model.addAttribute("user",user);
        return "user-show";
    }

    /**
     * 添加用户
     * @return
     */
    @RequestMapping("/save")
    public String save(UserInfo userInfo) throws Exception {
        userService.save(userInfo);
        return "redirect:findAll.do";
    }

    /**
     * 查询所有的用户
     * @param modelAndView
     * @return
     */
    @RequestMapping("/findAll")
    @RolesAllowed("ADMIN")
    public ModelAndView findAll(ModelAndView modelAndView) throws Exception {
        List<UserInfo> userList = userService.findAll();
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }
}
