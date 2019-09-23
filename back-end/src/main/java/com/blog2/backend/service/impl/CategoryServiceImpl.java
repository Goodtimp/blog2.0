package com.blog2.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blog2.backend.dao.CategoryMapper;
import com.blog2.backend.model.entity.Category;
import com.blog2.backend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class CategoryServiceImpl implements CategoryService {

    final private CategoryMapper cateMapper;


    @Override
    public List<Category> getAllCategory() {
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Category::getDelFlag, 0);
        return cateMapper.selectList(queryWrapper);
    }

    /**
     * 新增
     *
     * @return
     */
    @Override
    public Boolean insertCategory(Category category) {
        return cateMapper.insert(category) == 1 ? true : false;
    }

}
