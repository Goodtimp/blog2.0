package com.blog2.backend.exception;

import com.blog2.backend.common.model.ResponseModel;
import com.blog2.backend.jwt.JwtFilter;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: goodtimp
 * @Date: 2019/10/23 15:45
 * @description :  异常拦截
 */
@RestControllerAdvice
public class ExceptionController {

    private final Logger logger = LoggerFactory.getLogger(JwtFilter.class);

    // 捕捉shiro的异常
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException.class)
    @ResponseBody
    public ResponseModel handle401(ShiroException e) {
        System.out.println(e);
        logger.error(e.getMessage());
        return ResponseModel.fail(401, e.getMessage());
    }

    // 捕捉UnauthorizedException
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    public ResponseModel handle401() {
        System.out.println(401);
        logger.error("401，无权访问！");
        return ResponseModel.fail(401, "无权访问！");
    }

    // 捕捉其他所有异常
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseModel globalException(HttpServletRequest request, Throwable ex) {
        System.out.println(ex.getMessage());
        logger.error(ex.getMessage());
        return ResponseModel.fail(getStatus(request).value(), ex.getMessage());
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}