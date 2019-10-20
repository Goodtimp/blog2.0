package com.blog2.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog2.backend.Common.Tools;
import com.blog2.backend.dao.UserMapper;
import com.blog2.backend.enums.DelFlag;
import com.blog2.backend.model.entity.User;
import com.blog2.backend.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * @Author: goodtimp
 * @Date: 2019/10/1 13:13
 * @description :
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User getUserByPhone(String phone) {
        return null;
    }

    @Override
    public User login(String username, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getUserName, username).eq(User::getDelFlag, DelFlag.NORMAL.getCode());
        User user = this.getOne(queryWrapper);
        String loginPassword = DigestUtils.md5DigestAsHex(addSaltForPassword(password, user.getSalt()).getBytes());
        if (loginPassword.equals(user.getUserPassword())) {
            return user;
        }
        return null;
    }

    @Override
    public User loginByPhone(String phone, String password) {
        return null;
    }

    @Override
    public User loginByName(String name, String password) {
        return null;
    }

    @Override
    public User signIn(User user) {
        user.setSalt(Tools.getRandomString(20)); // 获取长度为20的盐
        String saltPass = user.getUserPassword() + user.getSalt();
        user.setUserPassword(DigestUtils.md5DigestAsHex(saltPass.getBytes()));
        user.setCreate();
        this.save(user);
        return user;
    }

    @Override
    public User changePassword(String param, String Password) {
        return null;
    }


    private String addSaltForPassword(String password, String salt) {
        return password + salt;
    }
}
