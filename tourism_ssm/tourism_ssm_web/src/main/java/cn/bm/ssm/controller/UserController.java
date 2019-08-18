package cn.bm.ssm.controller;

import cn.bm.ssm.domain.UserInfo;
import cn.bm.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * user相关的controller
 */
@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询用户详情
     * @return
     */
    @RequestMapping("/findById")
    public String findById(String id , Model model){
        UserInfo user = userService.findById(id);
        model.addAttribute("user",user);
        return "user-show";
    }

    /**
     * 添加用户
     * @return
     */
    @RequestMapping("/save")
    public String save(UserInfo userInfo){
        userService.save(userInfo);
        return "redirect:findAll.do";
    }

    /**
     * 查询所有的用户
     * @param modelAndView
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(ModelAndView modelAndView){
        List<UserInfo> userList = userService.findAll();
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }
}
