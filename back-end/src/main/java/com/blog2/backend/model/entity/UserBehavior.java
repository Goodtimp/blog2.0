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
 * @Date: 2019/9/19 17:23
 * @description :  用户行为
 */
@Data
@TableName("user_behavior")
@AllArgsConstructor
@NoArgsConstructor
public class UserBehavior extends BaseEntity {
    @TableId
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long userBehaviorId;

    /**
     * 用户行为 1点赞 2评论 3修改（管理员）
     */
    @NotNull
    private Integer type;

    /**
     * Ip地址
     */
    @NotNull
    private String ip;

    /**
     * 浏览器标识，可以为"",不能为null
     */
    @NotNull
    private String userAgent;

    /**
     * 操作的文章Id
     */
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long articleId;


    /**
     * 操作的评论Id，回复，评论需要此字段不为空,此字段最好为空时最好默认为0
     */

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long commentId;
}
