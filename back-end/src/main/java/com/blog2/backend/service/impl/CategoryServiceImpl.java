package com.blog2.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog2.backend.dao.CategoryMapper;
import com.blog2.backend.model.entity.Category;
import com.blog2.backend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    final private CategoryMapper cateMapper;

    @Override
    public List<Category> getAllCategory() {
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Category::getDelFlag, 0);
        return cateMapper.selectList(queryWrapper);
    }

    @Override
    public Boolean insertCategory(Category category) {
        return cateMapper.insert(category) == 1 ? true : false;
    }

    @Override
    public Boolean editCategory(Category cate) {
        return cateMapper.updateById(cate) == 1 ? true : false;
    }

    @Override
    public Boolean deleteCategory(Long id) {
        return cateMapper.deleteById(id) == 1 ? true : false;
    }
}
