package com.blog2.backend.controller;

import com.blog2.backend.model.entity.Category;
import com.blog2.backend.service.CategoryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Api("文章分类管理")
@RestController
@RequestMapping("/cate")
public class CategoryController {
    @Autowired
    private CategoryService categoryServiceImpl;

    @GetMapping("/getAll")
    @ResponseBody
    public List<Category> getAllCategory() {
        return categoryServiceImpl.getAllCategory();
    }
}
