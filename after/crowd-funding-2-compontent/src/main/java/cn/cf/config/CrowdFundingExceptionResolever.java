package cn.cf.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/12/5 - 15:10
 * @description ：异常界面
 */

@ControllerAdvice
public class CrowdFundingExceptionResolever {

    @ExceptionHandler(value = Exception.class)  //exception执行以下方法
    public ModelAndView catchException(Exception exception){

        ModelAndView mv = new ModelAndView();
        mv.addObject("exception",exception);
        mv.setViewName("system-error");
        return mv;

    }
}
