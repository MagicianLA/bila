package com.bila.demo.easyexcel;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.merge.LoopMergeStrategy;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.excel.write.style.column.SimpleColumnWidthStyleStrategy;

import com.bila.demo.easyexcel.data.DownloadData;
import com.bila.demo.easyexcel.handler.CustomHandler;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Magician
 * @Desc:
 * @Date: 2020/04/03
 * @Modify By:
 */
@RestController
public class ExcelController {


    @RequestMapping(value = "/download")
    public void download(HttpServletResponse response) {

        try {
            ServletOutputStream outputStream = response.getOutputStream();
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            String fileName = URLEncoder.encode("测试", "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");

            LoopMergeStrategy loopMergeStrategy = new LoopMergeStrategy(2, 0);
            SimpleColumnWidthStyleStrategy styleStrategy = new SimpleColumnWidthStyleStrategy(30);


            ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream())
                .registerWriteHandler(loopMergeStrategy)
                .registerWriteHandler(styleStrategy)
                .registerWriteHandler(new CustomHandler())
                .head(head()).build();
            WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
            excelWriter.write(data(), writeSheet);

            excelWriter.finish();
            outputStream.flush();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<DownloadData> data() {
        List<DownloadData> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            DownloadData data = new DownloadData();
            data.setString("   字符串" + 0);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }

    private List<List<String>> head() {
        List<List<String>> list = new ArrayList<List<String>>();
        List<String> head0 = new ArrayList<String>();
        //head0.add("字符串" );
        head0.add("字符串1");

        List<String> head1 = new ArrayList<String>();
        //head1.add("字符串");
        head1.add("字符串2");


        List<String> head2 = new ArrayList<String>();
        head2.add("日期");
        list.add(head0);
        list.add(head1);
        list.add(head2);
        return list;
    }
}
