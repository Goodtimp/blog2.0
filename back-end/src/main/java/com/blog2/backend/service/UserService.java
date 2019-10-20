package com.blog2.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog2.backend.model.entity.User;
import org.springframework.stereotype.Service;

/**
 * @Author: goodtimp
 * @Date: 2019/9/24 19:22
 * @description :  用户管理
 */

public interface UserService extends IService<User> {
    /**
     * 通过phone得到用户
     *
     * @param phone
     * @return
     */
    User getUserByPhone(String phone);

    /**
     * 通过手机号登录
     *
     * @param phone
     * @param password
     * @return 成功返回User对象，失败返回null
     */

    User login(String phone, String password);

    /**
     * 通过name登录
     *
     * @param name
     * @return
     */
    User getUserByName(String name);

    /**
     * 注册
     *
     * @param user
     * @return 返回注册后数据，注册失败返回null
     */
    User signIn(User user);

    /**
     * change password
     *
     * @param
     */
    User changePassword(String param, String Password);
}
