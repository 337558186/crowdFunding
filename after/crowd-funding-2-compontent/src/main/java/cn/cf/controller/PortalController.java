package cn.cf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/12/3 - 16:27
 * @description ：
 */
@Controller
public class PortalController {

    /**
     * 从数据库加载首页需要显示的数据
     * @return
     */
    @RequestMapping("/index")
    public String showIndex(){

        return "index-page";
    }
}
