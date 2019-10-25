package com.blog2.backend.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blog2.backend.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("blog_comment")
public class Comment extends BaseEntity {
    @TableId
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long commentId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @NotNull
    private Long articleId;
    /**
     * user name
     */
    @NotBlank
    private String userName;

    /**
     * user email
     */
    private String userEmail;

    /**
     * comment content
     */
    @NotBlank
    private String content;

    /**
     * 发表时间
     */
    @NotNull
    private Date postedTime;

    /**
     * 点赞数量
     */
    private Integer likeNumber;

}
