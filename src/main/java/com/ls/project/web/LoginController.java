package com.ls.project.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ls.project.entity.User;
import com.ls.project.service.UserService;
import com.ls.project.utils.RespBean;
import com.ls.project.utils.VerificationCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@RestController
@RequestMapping("/system")
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public RespBean login(@RequestBody Map params) {
        /**
         * 使用shiro编写认证操作
         */
        String userName = params.get("userName").toString();
        String password = params.get("userPassword").toString();
        String code = params.get("code").toString();
        Boolean rememberMe = (Boolean) params.get("rememberMe");
        Subject subject = SecurityUtils.getSubject();
        String verify_code = subject.getSession().getAttribute("verify_code").toString();
        if (code == null || verify_code == null || "".equals(code) || !verify_code.toLowerCase().equals(code.toLowerCase())) {
            //验证码不正确
            return RespBean.error("验证码不正确");
        }
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        token.setRememberMe(rememberMe);
        try{
            User user = userService.getUserByUserName(userName);
            if (!user.getEnabled().equals("1")) {
                return RespBean.error("已被禁用，请联系管理员!");
            }
            subject.login(token);
            return RespBean.ok("登录成功!",user);
        }catch (UnknownAccountException e){
            return RespBean.error("用户名不存在!");
        }catch(IncorrectCredentialsException e){
            return RespBean.error("密码错误!");
        }
    }

    @GetMapping("/isAuthenticated")
    public RespBean authenticated() {
        Subject subject = SecurityUtils.getSubject();
        boolean isAuthenticated = subject.isAuthenticated() || subject.isRemembered();
        System.out.println(subject.isAuthenticated());
        System.out.println(subject.isRemembered());
        return isAuthenticated ? RespBean.ok("已认证", true) : RespBean.error("未登录，请先登录!", false);
    }

    @GetMapping("/logout")
    public RespBean logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return RespBean.ok("退出成功!");
    }

    @GetMapping("/verifyCode")
    public void verifyCode(HttpSession session, HttpServletResponse resp) throws IOException {
        VerificationCode code = new VerificationCode();
        BufferedImage image = code.getImage();
        String text = code.getText();
        session.setAttribute("verify_code", text);
        VerificationCode.output(image,resp.getOutputStream());
    }
}
