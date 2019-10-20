package com.blog2.backend.controller;

import com.blog2.backend.Common.ResponseModel;
import com.blog2.backend.model.entity.User;
import com.blog2.backend.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api("测试")
@RestController
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class HelloController {

    final private UserService userServiceImpl;

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
        } catch (AccountException e) {
            return ResponseModel.fail(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return ResponseModel.fail("Shiro密码错误");
        }

    }

    @ApiOperation(value = "注册", notes = "注册用户")
    @PostMapping("signIn")
    @ResponseBody
    public ResponseModel signIn(@RequestBody User user) {
        User sqlUser = userServiceImpl.signIn(user);
        if (sqlUser == null) {
            return ResponseModel.fail("账号已存在");
        }
        return ResponseModel.success("注册成功");
    }


}
