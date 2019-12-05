package cn.cf.controller;

import cn.cf.entity.Admin;
import cn.cf.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/12/1 - 14:06
 * @description ：
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 查询所有用户
     * @param mv
     * @return
     */
    @RequestMapping("/getAll")
    public String getAll(ModelAndView mv){

        List<Admin> admins = adminService.getAll();
        mv.addObject("admins",admins);
        return null;
    }

    /**
     * 管理员用户登录
     * @return
     */
    @RequestMapping("/login")
    public String login(@RequestParam("loginAcct")String loginAcct, @RequestParam("userPswd")String userPswd, Model model, HttpSession session){

        System.out.println("执行登录方法");
        Admin admin = adminService.login(loginAcct,userPswd);
        if (admin == null){
            model.addAttribute("MESSAGE","账号或者密码错误");
            return "admin-login";
        }
        //保持登录状态
        session.setAttribute("LOGIN_ADMIN",admin);
        return "admin-main";
    }

    /**
     * 管理员退出登录
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "index-page";
    }
}
