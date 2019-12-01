package cn.cf.controller;

import cn.cf.entity.Admin;
import cn.cf.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
       /* mv.setViewName("getAll");
        return mv;*/
        return "admin-getAll";
    }
}
