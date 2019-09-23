package com.blog2.backend.controller;

import com.blog2.backend.model.entity.Category;
import com.blog2.backend.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Api("文章分类管理")
@RestController
@RequestMapping("/cate")
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class CategoryController {
    private final CategoryService categoryServiceImpl;

    @ApiOperation(value = "获取所有分类并排序", notes = "获取所有分类后并根据orderNum排序")
    @GetMapping("/getAll")
    @ResponseBody
    public List<Category> getAllCategory() {
        return categoryServiceImpl.getAllCategory();
    }

    @ApiOperation(value = "添加分类")
    @PostMapping("/save")
    @ResponseBody
    public String insert(@RequestBody @Valid Category category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "2";
        }
        return "3";
    }
}
