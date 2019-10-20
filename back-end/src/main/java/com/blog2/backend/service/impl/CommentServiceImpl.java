package com.blog2.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog2.backend.dao.CommentMapper;
import com.blog2.backend.model.entity.Comment;
import com.blog2.backend.service.CommentService;

/**
 * @Author: goodtimp
 * @Date: 2019/10/20 18:52
 * @description :  用户评论表
 */
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
}
