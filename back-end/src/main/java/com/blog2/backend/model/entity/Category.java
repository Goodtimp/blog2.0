package com.blog2.backend.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blog2.backend.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@TableName("category")
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseEntity {

    @TableId
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long categoryId;

    @NotNull(message = "category不允许为空")
    private String categoryName;

    @NotNull(message = "分类标记图不允许为空")
    private String categoryImage;

    @NotNull(message = "排序顺序不允许为空")
    private Integer sortNumber;

    // 删除标记 1为删除 0为正常
    private Integer delFlag = 0;


}
