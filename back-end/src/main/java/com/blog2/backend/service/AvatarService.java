package com.blog2.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog2.backend.model.entity.Avatar;
import org.springframework.stereotype.Service;

/**
 * @Author: goodtimp
 * @Date: 2019/9/24 19:18
 * @description :  头像列表（用于游客评论时的头像）
 */
@Service
public interface AvatarService extends IService<Avatar> {
}
