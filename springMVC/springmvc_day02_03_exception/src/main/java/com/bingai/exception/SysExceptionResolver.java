package com.bingai.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**异常处理器
 * @author bingai
 * @create 2019-12-25 9:37
 */
public class SysExceptionResolver implements HandlerExceptionResolver{
    /**
     * 处理异常业务逻辑
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param ex
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
        //获取到异常对象
        SysException e = null;
        if(ex instanceof SysException){
            e = (SysException)ex;
        }else {
            e = new SysException("系统正在维护。。。");
        }
        //创建ModeAndView对象
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMsg",e.getMessage());
        mv.setViewName("error");

        return mv;
    }

}
