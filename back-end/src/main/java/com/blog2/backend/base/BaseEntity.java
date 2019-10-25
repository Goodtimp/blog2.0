package com.blog2.backend.base;

import com.blog2.backend.common.Tools;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class BaseEntity {
    // 删除标志 正常：0 删除：1
    private Integer delFlag = 0;

    // 创建者name
    private String create_by;

    // 创建者Id
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long createById;

    // 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    // 更新者name
    private String updateBy;

    // 更新者Id
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long updateById;

    // 更新时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    // 备注
    private String remark;

    public void setUpdate() {
        // user
        this.updateTime = Tools.getGMT8Time();
    }
    public void setCreate() {
        // user
        this.updateTime = Tools.getGMT8Time();
        this.createTime = Tools.getGMT8Time();
    }
}
