package com.blog2.backend.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blog2.backend.model.entity.Category;
import com.blog2.backend.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Api("文章分类管理")
@RestController
@RequestMapping("/cate")
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class CategoryController {
    private final CategoryService categoryServiceImpl;

    @ApiOperation(value = "获取所有分类并排序", notes = "获取所有分类后并根据ResponseBodyOrderNum排序")
    @GetMapping("/getAll")
    @ResponseBody
    public IPage<Category> getAllCategory() {
        return categoryServiceImpl.getAllCategory();
    }

}
