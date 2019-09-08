package com.blog2.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blog2.backend.dao.CategoryMapper;
import com.blog2.backend.model.entity.Category;
import com.blog2.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getAllCategory() {
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Category::getDelFlag, 0);
        return categoryMapper.selectList(queryWrapper);
    }
}
