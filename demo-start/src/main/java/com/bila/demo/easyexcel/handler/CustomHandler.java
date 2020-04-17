package com.bila.demo.easyexcel.handler;

import java.util.List;

import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.util.StyleUtil;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;

import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * @Author: Magician
 * @Desc:
 * @Date: 2020/04/13
 * @Modify By:
 */
public class CustomHandler implements CellWriteHandler {
    @Override
    public void beforeCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row,
                                 Head head, Integer columnIndex, Integer relativeRowIndex, Boolean isHead) {

    }

    @Override
    public void afterCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Cell cell,
                                Head head, Integer relativeRowIndex, Boolean isHead) {

    }

    @Override
    public void afterCellDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder,
                                 List<CellData> cellDataList, Cell cell, Head head, Integer relativeRowIndex,
                                 Boolean isHead) {
        Workbook workbook = writeSheetHolder.getParentWriteWorkbookHolder().getWorkbook();
        if (isHead) {
            WriteCellStyle headCellStyle = new WriteCellStyle();
            headCellStyle.setLocked(false);

            CellStyle cellStyle = StyleUtil.buildHeadCellStyle(workbook, headCellStyle);
            cell.setCellStyle(cellStyle);
        }

        if (!isHead && cell.getColumnIndex() == 2) {
            CreationHelper createHelper = workbook.getCreationHelper();
            Hyperlink hyperlink = createHelper.createHyperlink(HyperlinkType.URL);
            hyperlink.setAddress("https://www.baidu.com");
            cell.setHyperlink(hyperlink);


            WriteCellStyle headCellStyle = new WriteCellStyle();

            WriteFont writeFont = new WriteFont();
            writeFont.setColor(IndexedColors.BLUE.getIndex());
            writeFont.setUnderline(Font.U_SINGLE);
            headCellStyle.setWriteFont(writeFont);

            CellStyle cellStyle = StyleUtil.buildHeadCellStyle(workbook, headCellStyle);
            cell.setCellStyle(cellStyle);

        }
    }
}
