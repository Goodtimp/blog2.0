package com.blog2.backend.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blog2.backend.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @Author: goodtimp
 * @Date: 2019/9/19 17:24
 * @description :  用户表
 */
@Data
@TableName("user")
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {
    @TableId
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long userId;

    @NotNull
    private String userPassword;

    @NotNull
    private String userName;

    @NotNull
    private String phone;

    /**
     * 1普通用户 2权限用户 3管理员
     */
    @NotNull
    @Min(1)
    @Max(3)
    private Integer permission;

    private String avatar;
}
