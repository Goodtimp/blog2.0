package com.blog2.backend.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blog2.backend.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.beans.IntrospectionException;
import java.util.Date;

/**
 * @Author: goodtimp
 * @Date: 2019/9/19 17:21
 * @description :  文章表
 */
@Data
@TableName("blog_article")
@AllArgsConstructor
@NoArgsConstructor
public class Article extends BaseEntity {
    @TableId
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long articleId;

    @NotNull
    private String articleName;

    @NotNull
    private Date postedTime;

    @NotNull
    private Integer hits;

    @NotNull
    private Integer likeNumber;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long categoryId;

    @NotNull
    private Integer type;

    private Date endTime;

    private String content;

    @NotNull
    private String tagIds;
}
