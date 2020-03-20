package com.ls.project.handler;

import com.ls.project.utils.RespBean;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private RespBean exceptionHandler(HttpServletRequest req, Exception e) {
        return RespBean.error("出现错误!",e.getMessage());
    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    public RespBean handleAuthorizationException(UnauthorizedException e) {
        return RespBean.error("无此权限,请联系管理员!");
    }
}
