package com.zahuopu.controller;

import com.zahuopu.entity.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author bingai
 * @create 2020-01-11 0:37
 */
@ControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        System.out.println("调用了异常处理");
        return new Result(1,e.getMessage());
    }
}
