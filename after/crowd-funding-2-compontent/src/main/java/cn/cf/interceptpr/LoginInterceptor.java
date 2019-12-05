package cn.cf.interceptpr;

import cn.cf.entity.Admin;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/12/5 - 16:01
 * @description ：
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        Admin admin = (Admin)session.getAttribute("LOGIN_ADMIN");
        if (admin  == null){
            request.setAttribute("MESSAGE","违法操作，请先登录！！！");
            request.getRequestDispatcher("/WEB-INF/admin-login.jsp").forward(request,response);
            return false;
        }
        return true;
    }
    /**
     * controller执行之后，渲染视图之前
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
