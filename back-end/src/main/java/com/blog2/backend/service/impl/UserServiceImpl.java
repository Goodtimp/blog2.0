package com.blog2.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog2.backend.common.Tools;
import com.blog2.backend.dao.UserMapper;
import com.blog2.backend.enums.DelFlagEnum;
import com.blog2.backend.exception.UserException;
import com.blog2.backend.model.entity.User;
import com.blog2.backend.service.UserService;
import org.apache.shiro.crypto.hash.Md5Hash;
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
    @Deprecated
    public User login(String username, String password) throws UserException {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getUserName, username).eq(User::getDelFlag, DelFlagEnum.NORMAL.getCode());
        User user = this.getOne(queryWrapper);
        if (user == null) throw new UserException("用户信息不存在");

        String loginPassword = addSaltForPassword(password, user.getSalt());
        if (loginPassword.equals(user.getUserPassword())) {
            return user;
        } else throw new UserException("用户名或密码错误");
    }


    @Override
    public User getUserByName(String name) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getUserName, name).eq(User::getDelFlag, DelFlagEnum.NORMAL.getCode());
        return this.getOne(queryWrapper);
    }

    @Override
    public User signIn(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getDelFlag, DelFlagEnum.NORMAL.getCode())
                .and(e -> e.eq(User::getPhone, user.getPhone())
                        .or().eq(User::getUserName, user.getUserName())
                        .or().eq(User::getUserName, user.getPhone())
                        .or().eq(User::getPhone, user.getUserName()));
        User sqlUser = this.getOne(queryWrapper);
        if (sqlUser != null) {
            return null;
        }

        user.setSalt(Tools.getRandomString(20)); // 获取长度为20的盐
        String saltPass = addSaltForPassword(user.getUserPassword(), user.getSalt());// shiro中加密必须要用Md5Hash
        user.setUserPassword(saltPass);
        user.setPermission(1); // 普通用户注册
        user.setCreate();
        this.save(user);
        return user;
    }

    @Override
    public User changePassword(String param, String Password) {
        return null;
    }


    private String addSaltForPassword(String password, String salt) {
        return new Md5Hash(password, salt, 2).toString();// shiro中默认加密必须要用Md5Hash
    }
}
