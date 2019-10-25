package com.blog2.backend.common.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: goodtimp
 * @Date: 2019/10/21 9:13
 * @description :  分析的excel Mode
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnalyzeModel extends BaseRowModel {
    @ExcelProperty(value = "姓名", index = 0)
    private String name;

    @ExcelProperty(value = "密码", index = 1)
    private String password;

    @ExcelProperty(value = "年龄", index = 2)
    private Integer age;

}
