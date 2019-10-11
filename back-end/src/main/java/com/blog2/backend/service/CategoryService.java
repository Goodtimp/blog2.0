package com.blog2.backend.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blog2.backend.model.entity.Category;

public interface CategoryService extends IService<Category> {
    /**
     * 得到所有
     *
     * @return
     */
    IPage<Category> getAllCategory();

    /**
     * 新增
     *
     * @param cate
     * @return
     */
    Boolean insertCategory(Category cate);


    /**
     * 修改
     *
     * @param cate
     * @return
     */
    Boolean editCategory(Category cate);


    /**
     * 删除 逻辑删除
     *
     * @param id
     * @return
     */
    Boolean deleteCategory(Long id);
}
