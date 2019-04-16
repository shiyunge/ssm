package com.fable.common.exception;

import com.fable.common.bean.vo.Result;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;

/**
 * 全局异常解析器
 *
 * @author afeey
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * 业务异常处理
     *
     * @param e 异常
     * @return JSON视图
     */
    @ExceptionHandler(BusinessException.class)
    public Result businessException(BusinessException e, HandlerMethod handler) {
        return new Result(false, e.getCode(), e.getMessage());
    }

    /**
     * 全部异常
     *
     * @param e 异常
     * @return JSON视图
     */
    @ExceptionHandler(Exception.class)
    public Result allException(Exception e, HandlerMethod handler) {
        e.printStackTrace();
        return new Result(false, HttpStatus.INTERNAL_SERVER_ERROR.toString(), "服务器内部处理异常", e.getMessage());
    }
}
 
 
