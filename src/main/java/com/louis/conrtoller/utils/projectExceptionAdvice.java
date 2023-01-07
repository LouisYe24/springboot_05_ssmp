package com.louis.conrtoller.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//作为springmvc的异常处理器
//1.业务层和数据层都会抛到表现层，定义控制层处理器
//@ControllerAdvice
@RestControllerAdvice//组合了resposebody
public class projectExceptionAdvice {
    @ExceptionHandler//这个方法定义可以拦截所有的异常信息,后面可以加（）里面放异常.class，分别处理异常。
    public R doException(Exception ex){
        //记录日志
        //通知运维
        //通知开发
        ex.printStackTrace();//让控制台显示异常信息!!!!!!!!!
        return new R("服务器故障，请稍后再试!");
    }
}
