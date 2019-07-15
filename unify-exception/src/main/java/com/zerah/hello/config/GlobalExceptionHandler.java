package com.zerah.hello.config;

import com.zerah.hello.entity.ErrorInfo;
import com.zerah.hello.exception.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: hello-demo
 * @author: Mr.Zerah
 * @create: 2019-07-15 22:07
 * @description: 全局异常处理类
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, MyException e) throws Exception {
        ErrorInfo<String> ei = new ErrorInfo<>();
        ei.setMessage(e.getMessage());
        ei.setCode(ErrorInfo.ERROR);
        ei.setData("Some Data");
        ei.setUrl(req.getRequestURL().toString());
        return ei;
    }
}
