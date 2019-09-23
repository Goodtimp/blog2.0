package com.blog2.backend.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blog2.backend.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @Author: goodtimp
 * @Date: 2019/9/19 17:22
 * @description : 标签
 */
@Data
@TableName("tag")
@AllArgsConstructor
@NoArgsConstructor
public class Tag extends BaseEntity {
    @TableId
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long tagId;

    @NotNull
    private String tagName;

    @NotNull
    @Min(0)
    private Integer tagNumber;
}
