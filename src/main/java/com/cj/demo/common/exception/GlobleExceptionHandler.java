package com.cj.demo.common.exception;

import com.cj.demo.common.Result.Result;
import com.cj.demo.common.Result.ResultType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * 全局异常处理类
 */
@ControllerAdvice//所谓加强Controller就是@ControllerAdvice注解，有这个注解的类中的方法的某些注解会应用到所有的Controller里，其中就包括@ExceptionHandler注解。
@ResponseBody//REST风格接口
public class GlobleExceptionHandler {

    @ExceptionHandler(value = Exception.class)//异常处理(@ControllerAdvice注解注释的controller层和此注解注释的方法,会对所有controller层抛出的异常进行统一处理)
    public Result ExceptionHandler(HttpServletRequest request, Exception e){
        String msg = null;
        if (e instanceof ConstraintViolationException){
            ConstraintViolationException ex = (ConstraintViolationException)e;
            Set<ConstraintViolation<?>> cvs = ex.getConstraintViolations();
            for (ConstraintViolation cv : cvs) {
                msg = cv.getMessage();
                break;
            }
        }
        return new Result(ResultType.PARAM_ERROR, msg);
    }
}
