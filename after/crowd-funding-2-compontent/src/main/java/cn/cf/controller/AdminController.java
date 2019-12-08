package cn.cf.controller;

import cn.cf.entity.Admin;
import cn.cf.service.AdminService;
import com.github.pagehelper.PageInfo;
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
     * 用户管理-根据关键字查询分页
     * @param pageNum
     * @param pageSize
     * @param keyword
     * @return
     */
    @RequestMapping("/queryAdminListByKeyword")
    public String queryAdminListByKeyword(
            //如果页面为提供值，指定默认值
            @RequestParam(value = "pageNum",defaultValue = "1",required = false) Integer pageNum,
            @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
            @RequestParam(value = "keyword",defaultValue = "") String keyword,Model model) {

        PageInfo<Admin> adminPageInfo = adminService.queryForKeyword(pageNum, pageSize, keyword);
        model.addAttribute("pageInfo",adminPageInfo);
        return "admin-userManage";
    }

    /**
     * 管理员用户登录
     *
     * @return
     */
    @RequestMapping("/login")
    public String login(@RequestParam("loginAcct") String loginAcct, @RequestParam("userPswd") String userPswd, Model model, HttpSession session) {

        System.out.println("执行登录方法");
        Admin admin = adminService.login(loginAcct, userPswd);
        if (admin == null) {
            model.addAttribute("MESSAGE", "账号或者密码错误");
            return "admin-login";
        }
        //保持登录状态
        session.setAttribute("LOGIN_ADMIN", admin);
        return "redirect:/admin/to/main.html";
    }

    /**
     * 管理员退出登录
     *
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/index.html";
    }

    /**
     * 测试方法--查询所有用户
     *
     * @param mv
     * @return
     */
    @RequestMapping("/getAll")
    public String getAll(ModelAndView mv) {

        List<Admin> admins = adminService.getAll();
        mv.addObject("admins", admins);
        return null;
    }
}
