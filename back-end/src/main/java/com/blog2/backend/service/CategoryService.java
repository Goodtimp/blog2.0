package com.blog2.backend.service;

import com.blog2.backend.model.entity.Category;


import java.util.List;

public interface CategoryService {
    /**
     * 得到所有
     * @return
     */
    List<Category> getAllCategory();

    /**
     * 新增
     * @param cate
     * @return
     */
    Boolean insertCategory(Category cate);


}
