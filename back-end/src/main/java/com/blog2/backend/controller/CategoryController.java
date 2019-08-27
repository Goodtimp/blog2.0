package com.blog2.backend.controller;

import com.blog2.backend.model.entity.Category;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Api("文章分类管理")
@RestController
@RequestMapping("/cate")
public class CategoryController {
    @GetMapping("/getAll")
    @ResponseBody
    public String getAllCategory(){
        Category cate=new Category();
    }
}
