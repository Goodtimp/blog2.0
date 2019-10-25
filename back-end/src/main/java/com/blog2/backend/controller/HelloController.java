package com.blog2.backend.controller;

import com.blog2.backend.common.model.ResponseModel;
import com.blog2.backend.enums.RedisEnum;
import com.blog2.backend.exception.UserException;
import com.blog2.backend.jwt.JwtToken;
import com.blog2.backend.jwt.JwtUtil;
import com.blog2.backend.model.entity.User;
import com.blog2.backend.redis.RedisUtil;
import com.blog2.backend.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

import static com.blog2.backend.enums.TokenEnum.REFRESH_TOKEN_EXPIRE_TIME;

@Api("测试")
@RestController
public class HelloController {
    @Autowired
     private RedisUtil redisUtil;
    @Autowired
     private UserService userServiceImpl;

    @GetMapping("/")
    @ResponseBody
    @RequiresPermissions("user:tt")
    public String hello() {
        return "hello world!";
    }

    @GetMapping("/test")
    @ResponseBody
    @RequiresPermissions("user:test")
    public String test() {
        return "hello test!";
    }

    @GetMapping("/login")
    @ResponseBody
    public ResponseModel login(String name, String password, HttpServletResponse httpServletResponse) {
        // 查询数据库中的帐号信息
        User user = userServiceImpl.login(name, password);

        // 新增token信息,如果已经有登陆过了下面会刷新refreshToken的时间戳，使得先登录的被t除去
        String currentTimeMillis = String.valueOf(System.currentTimeMillis());
        String token = JwtUtil.sign(user.getUserId().toString(), currentTimeMillis);
        // refreshToken
        redisUtil.set(RedisEnum.REFRESH_TOKEN_PREFIX.getCode() + user.getUserId().toString(),
                currentTimeMillis, Long.parseLong(REFRESH_TOKEN_EXPIRE_TIME.getCode()));
        // 修改sAuthorization返回AccessToken，时间戳为当前时间戳
        httpServletResponse.setHeader("Authorization", token);
        httpServletResponse.setHeader("Access-Control-Expose-Headers", "Authorization");
        return ResponseModel.success("Login Success.");
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
