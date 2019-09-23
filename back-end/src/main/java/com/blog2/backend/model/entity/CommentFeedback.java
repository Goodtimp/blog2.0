package com.blog2.backend.model.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.blog2.backend.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: goodtimp
 * @Date: 2019/9/19 17:24
 * @description :  评论回复关联表
 */
@Data
@TableName("comment_feedback")
@AllArgsConstructor
@NoArgsConstructor
public class CommentFeedback extends BaseEntity {
    @TableId
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long feedbackId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long commentId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long feedbackForId;
}
