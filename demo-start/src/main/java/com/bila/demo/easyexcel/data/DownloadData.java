package com.bila.demo.easyexcel.data;

import java.util.Date;

import com.alibaba.excel.annotation.ExcelProperty;

import lombok.Data;

/**
 * @Author: Magician
 * @Desc:
 * @Date: 2020/04/03
 * @Modify By:
 */
@Data
public class DownloadData {
    @ExcelProperty("字符串标题")
    private String string;
    @ExcelProperty("日期标题")
    private Date date;
    @ExcelProperty("数字标题")
    private Double doubleData;

}
