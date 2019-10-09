package com.blog2.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog2.backend.dao.UserMapper;
import com.blog2.backend.model.entity.User;
import com.blog2.backend.service.UserService;
import org.springframework.stereotype.Service;

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
        return null;
    }

    @Override
    public User changePassword(String param, String Password) {
        return null;
    }
}
