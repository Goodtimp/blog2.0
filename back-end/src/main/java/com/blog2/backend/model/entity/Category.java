package com.blog2.backend.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@TableName("category")
public class Category {

    @TableId
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long categoryId;

    @NotNull(message = "category不允许为空")
    private String categoryName;

    @NotNull(message = "分类标记图不允许为空")
    private String categoryImage;

    @NotNull(message = "排序顺序不允许为空")
    private Integer  sortNumber;

    // 删除标记 1为删除 0为正常
    private Integer delFlag;

    //创建时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

}
