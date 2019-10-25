package com.blog2.backend.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blog2.backend.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@TableName("blog_user")
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "用户实体类")
public class User extends BaseEntity {
    @TableId
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @ApiModelProperty(name = "userId", value = "用户Id")
    private Long userId;

    @NotNull
    @ApiModelProperty(name = "userPassword", value = "用户password")
    private String userPassword;

    @NotNull
    @ApiModelProperty(name = "userName", value = "userName")
    private String userName;

    @NotNull
    @ApiModelProperty(name = "phone", value = "phone")
    private String phone;

    /**
     * 1普通用户 2权限用户 3管理员
     */
    @Min(1)
    @Max(3)
    private Integer permission;

    @ApiModelProperty(name = "avatar", value = "avatar")
    private String avatar;

    /**
     * 密码加盐
     */
    private String salt;
}
