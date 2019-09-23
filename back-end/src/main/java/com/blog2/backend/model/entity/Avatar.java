package com.blog2.backend.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blog2.backend.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @Author: goodtimp
 * @Date: 2019/9/19 17:21
 * @description :  用户头像表
 */
@Data
@TableName("avatar")
@AllArgsConstructor
@NoArgsConstructor
public class Avatar extends BaseEntity {
    @TableId
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long avatarId;

    @NotNull
    private String avatarPath;

    @NotNull
    private String avatarName;

}
