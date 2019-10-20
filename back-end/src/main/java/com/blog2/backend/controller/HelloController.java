package com.blog2.backend.controller;

import com.blog2.backend.Common.ResponseModel;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    @ResponseBody
    public String hello() {
        return "hello world!";
    }

    @GetMapping("/login")
    @ResponseBody
    public ResponseModel login(String name, String password) {
        /**
         * 使用Shiro编写认证操作
         */
        //1.获取Subject
        Subject subject = SecurityUtils.getSubject();

        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);

        //3.执行登录方法
        try {
            subject.login(token); // 如果不报错则成功

            return ResponseModel.success("token", token);
        } catch (UnknownAccountException e) {
            return ResponseModel.fail("用户名不存在");
        } catch (IncorrectCredentialsException e) {
            return ResponseModel.fail("密码错误");
        }

    }
}
