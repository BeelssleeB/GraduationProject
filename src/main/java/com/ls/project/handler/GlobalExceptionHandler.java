package com.ls.project.handler;

import com.ls.project.utils.RespBean;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    public RespBean handleAuthorizationException(UnauthorizedException e) {
        return RespBean.error("无此权限,请联系管理员");
    }

    @ExceptionHandler(UnknownAccountException.class)
    @ResponseBody
    public RespBean handleUnknownAccountException(UnknownAccountException e) {
        return RespBean.error("用户名不存在");
    }

    @ExceptionHandler(LockedAccountException.class)
    @ResponseBody
    public RespBean handleLockedAccountException(LockedAccountException e) {
        return RespBean.error("已被禁用，请联系管理员");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public RespBean handleIllegalArgumentException(IllegalArgumentException e) {
        return RespBean.error("输入的旧密码不正确");
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private RespBean exceptionHandler(HttpServletRequest req, Exception e) {
        return RespBean.error("出现错误", e.getMessage());
    }
}
