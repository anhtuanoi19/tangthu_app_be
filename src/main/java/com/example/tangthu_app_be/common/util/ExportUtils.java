package com.example.tangthu_app_be.common.util;

import com.example.tangthu_app_be.common.util.excel.ExcelColumn;
import com.example.tangthu_app_be.common.util.excel.ExcelHeader;
import com.example.tangthu_app_be.common.util.excel.ExcelHeaderItem;
import com.example.tangthu_app_be.common.util.excel.ExcelTitle;
import com.example.tangthu_app_be.domain.dtos.response.DetailVotesExcelDTO;
import com.google.common.collect.Lists;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class ExportUtils {
    private static final DecimalFormat doubleFormat = new DecimalFormat("#.##");

    public static ByteArrayInputStream onExport(List<ExcelColumn> lstColumn, List<?> lstData, int startRow, int startCol, ExcelTitle excelTitle, boolean displayIndex) throws Exception {
        return onExportMultipleSheet(lstColumn, lstData, startRow, startCol, excelTitle, displayIndex, 0);
    }

    public static ByteArrayInputStream onExportMultipleSheet(List<ExcelColumn> lstColumn, List lstData, int startRow, int startCol,
                                                             ExcelTitle excelTitle, boolean displayIndex, int partitionSize) throws Exception {
        SXSSFWorkbook workbook = null;
        try {
            workbook = new SXSSFWorkbook(1000);
            List<List> partition = new ArrayList<>();
            if (partitionSize == 0) {
                partitionSize = lstData.size();
            }
            if (partitionSize > 0) {
                partition = Lists.partition(lstData, partitionSize);
            } else {
                partition.add(new ArrayList<>());
            }

            for (int j = 0; j < partition.size(); j++) {
                Sheet sheet = workbook.createSheet(j == 0 ? "Data" : "Data " + (j + 1));
                CellStyle style = workbook.createCellStyle();
                Font font = workbook.createFont();
                font.setFontName(HSSFFont.FONT_ARIAL);
                style.setFont(font);
                int diff = getDiff(displayIndex);

                Row rowHeader = createFileTitle(startRow, startCol, excelTitle, workbook, sheet, (short) 500, (lstColumn.size() - 1 + diff));

                CellStyle cellStyleHeader = createStyleHeader(workbook);
                Font fontCell = workbook.createFont();
                fontCell.setFontName(HSSFFont.FONT_ARIAL);
                cellStyleHeader.setFont(fontCell);

                if (displayIndex) {
                    Cell cellIndex = rowHeader.createCell(startCol);
                    cellIndex.setCellValue("STT");
                    cellIndex.setCellStyle(cellStyleHeader);
                }
                for (int i = 0; i < lstColumn.size(); i++) {
                    Cell cellHeader = rowHeader.createCell(i + startCol + diff);
                    cellHeader.setCellValue(lstColumn.get(i).getTitle());
                    cellHeader.setCellStyle(cellStyleHeader);
                }
                AtomicInteger atomicInteger = new AtomicInteger(0);
                lstColumn.forEach(e -> {
                    if (e.getColumnWidth() != null) {
                        sheet.setColumnWidth(startCol + diff + atomicInteger.getAndIncrement(), e.getColumnWidth());
                    }
                });
                createFileOutput(lstColumn, partition.get(j), startRow, startCol, workbook, sheet, displayIndex, false);
            }

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } finally {
            if (workbook != null) {
                workbook.dispose();
                workbook.close();
            }
        }
    }

    public ByteArrayInputStream onExportNotMatchAudit(List<ExcelColumn> lstColumn, List<?> lstData, int startRow,
                                                      int startCol, ExcelTitle excelTitle, Boolean displayIndex, boolean isMonth) throws Exception {
        SXSSFWorkbook workbook = null;
        try {
            workbook = new SXSSFWorkbook(1000);
            Sheet sheet = workbook.createSheet("Data");
            int diff = this.getDiff(displayIndex);

            Row rowDateExport = createFileTitle(startRow, startCol, excelTitle, workbook, sheet, (short) 500, (lstColumn.size() - 1 + diff));
            Row rowHeader = sheet.createRow(startRow + 1);
            rowHeader.setHeight((short) 500);
            Cell mainCellLeft = rowDateExport.createCell(2);
            mainCellLeft.setCellValue("DỮ LIỆU CRM");
            CellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            Font newFont = mainCellLeft.getSheet().getWorkbook().createFont();
            newFont.setFontHeightInPoints((short) 18);
            newFont.setColor(HSSFColor.HSSFColorPredefined.WHITE.getIndex());
            newFont.setFontName(HSSFFont.FONT_ARIAL);
            cellStyle.setFont(newFont);
            cellStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.LIGHT_BLUE.getIndex());
            cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            mainCellLeft.setCellStyle(cellStyle);
            sheet.addMergedRegion(new CellRangeAddress(3, 3, 2, 11));

            Cell mainCellLeft2 = rowDateExport.createCell(12);
            mainCellLeft2.setCellValue("DỮ LIỆU HỢP ĐỒNG CTBH");
            CellStyle cellStyle2 = workbook.createCellStyle();
            cellStyle2.setAlignment(HorizontalAlignment.CENTER);
            cellStyle2.setVerticalAlignment(VerticalAlignment.CENTER);
            Font newFont2 = mainCellLeft2.getSheet().getWorkbook().createFont();
            newFont2.setFontHeightInPoints((short) 18);
            newFont2.setColor(HSSFColor.HSSFColorPredefined.WHITE.getIndex());
            newFont2.setFontName(HSSFFont.FONT_ARIAL);
            cellStyle2.setFont(newFont2);
            cellStyle2.setFillForegroundColor(HSSFColor.HSSFColorPredefined.RED.getIndex());
            cellStyle2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            mainCellLeft2.setCellStyle(cellStyle2);
            sheet.addMergedRegion(new CellRangeAddress(3, 3, 12, 17));

            if (!isMonth) {
                Cell mainCellLeft3 = rowDateExport.createCell(18);
                mainCellLeft3.setCellValue("TKCT");
                CellStyle cellStyle3 = workbook.createCellStyle();
                cellStyle3.setAlignment(HorizontalAlignment.CENTER);
                cellStyle3.setVerticalAlignment(VerticalAlignment.CENTER);
                Font newFont3 = mainCellLeft3.getSheet().getWorkbook().createFont();
                newFont3.setFontHeightInPoints((short) 18);
                newFont3.setColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
                newFont3.setFontName(HSSFFont.FONT_ARIAL);
                cellStyle3.setFont(newFont3);
                cellStyle3.setFillForegroundColor(HSSFColor.HSSFColorPredefined.LIGHT_YELLOW.getIndex());
                cellStyle3.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                mainCellLeft3.setCellStyle(cellStyle3);
            }

            CellStyle cellStyleHeader = createStyleHeader(workbook);

            if (Boolean.TRUE.equals(displayIndex)) {
                Cell cellIndex = rowHeader.createCell(startCol);
                cellIndex.setCellValue("STT");
                cellIndex.setCellStyle(cellStyleHeader);
            }
            for (int i = 0; i < lstColumn.size(); i++) {
                Cell cellHeader = rowHeader.createCell(i + startCol + diff);
                cellHeader.setCellValue(lstColumn.get(i).getTitle());
                cellHeader.setCellStyle(cellStyleHeader);
            }
            AtomicInteger atomicInteger = new AtomicInteger(0);
            lstColumn.forEach(e -> {
                if (e.getColumnWidth() != null) {
                    sheet.setColumnWidth(startCol + diff + atomicInteger.getAndIncrement(), e.getColumnWidth());
                }
            });

            return createFileOutput(lstColumn, lstData, 4, startCol, workbook, sheet, displayIndex, true);
        } finally {
            if (workbook != null) {
                workbook.dispose();
                workbook.close();
            }
        }
    }

    public ByteArrayInputStream onExportNotMatchAuditNonLife(List<ExcelColumn> lstColumn, List<?> lstData, int startRow,
                                                             int startCol, ExcelTitle excelTitle, Boolean displayIndex) throws Exception {
        SXSSFWorkbook workbook = null;
        try {
            workbook = new SXSSFWorkbook(1000);
            Sheet sheet = workbook.createSheet("Data");
            int diff = this.getDiff(displayIndex);

            Row rowDateExport = createFileTitle(startRow, startCol, excelTitle, workbook, sheet, (short) 500, (lstColumn.size() - 1 + diff));
            Row rowHeader = sheet.createRow(startRow + 1);
            rowHeader.setHeight((short) 500);
            Cell mainCellLeft = rowDateExport.createCell(2);
            mainCellLeft.setCellValue("DỮ LIỆU CRM");
            CellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            Font newFont = mainCellLeft.getSheet().getWorkbook().createFont();
            newFont.setFontHeightInPoints((short) 18);
            newFont.setColor(HSSFColor.HSSFColorPredefined.WHITE.getIndex());
            newFont.setFontName(HSSFFont.FONT_ARIAL);
            cellStyle.setFont(newFont);
            cellStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.LIGHT_BLUE.getIndex());
            cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            mainCellLeft.setCellStyle(cellStyle);
            sheet.addMergedRegion(new CellRangeAddress(3, 3, 2, 10));

            Cell mainCellLeft2 = rowDateExport.createCell(11);
            mainCellLeft2.setCellValue("DỮ LIỆU CTBH");
            CellStyle cellStyle2 = workbook.createCellStyle();
            cellStyle2.setAlignment(HorizontalAlignment.CENTER);
            cellStyle2.setVerticalAlignment(VerticalAlignment.CENTER);
            Font newFont2 = mainCellLeft2.getSheet().getWorkbook().createFont();
            newFont2.setFontHeightInPoints((short) 18);
            newFont2.setColor(HSSFColor.HSSFColorPredefined.WHITE.getIndex());
            newFont2.setFontName(HSSFFont.FONT_ARIAL);
            cellStyle2.setFont(newFont2);
            cellStyle2.setFillForegroundColor(HSSFColor.HSSFColorPredefined.RED.getIndex());
            cellStyle2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            mainCellLeft2.setCellStyle(cellStyle2);
            sheet.addMergedRegion(new CellRangeAddress(3, 3, 11, 17));

            Cell mainCellLeft3 = rowDateExport.createCell(18);
            mainCellLeft3.setCellValue("TKCT");
            CellStyle cellStyle3 = workbook.createCellStyle();
            cellStyle3.setAlignment(HorizontalAlignment.CENTER);
            cellStyle3.setVerticalAlignment(VerticalAlignment.CENTER);
            Font newFont3 = mainCellLeft3.getSheet().getWorkbook().createFont();
            newFont3.setFontHeightInPoints((short) 18);
            newFont3.setColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
            newFont3.setFontName(HSSFFont.FONT_ARIAL);
            cellStyle3.setFont(newFont3);
            cellStyle3.setFillForegroundColor(HSSFColor.HSSFColorPredefined.LIGHT_YELLOW.getIndex());
            cellStyle3.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            mainCellLeft3.setCellStyle(cellStyle3);
            sheet.addMergedRegion(new CellRangeAddress(3, 3, 18, 20));

            CellStyle cellStyleHeader = createStyleHeader(workbook);

            if (Boolean.TRUE.equals(displayIndex)) {
                Cell cellIndex = rowHeader.createCell(startCol);
                cellIndex.setCellValue("STT");
                cellIndex.setCellStyle(cellStyleHeader);
            }
            for (int i = 0; i < lstColumn.size(); i++) {
                Cell cellHeader = rowHeader.createCell(i + startCol + diff);
                cellHeader.setCellValue(lstColumn.get(i).getTitle());
                cellHeader.setCellStyle(cellStyleHeader);
            }
            AtomicInteger atomicInteger = new AtomicInteger(0);
            lstColumn.forEach(e -> {
                if (e.getColumnWidth() != null) {
                    sheet.setColumnWidth(startCol + diff + atomicInteger.getAndIncrement(), e.getColumnWidth());
                }
            });

            return createFileOutput(lstColumn, lstData, 4, startCol, workbook, sheet, displayIndex, true);
        } finally {
            if (workbook != null) {
                workbook.dispose();
                workbook.close();
            }
        }
    }


    private static Row createFileTitle(int startRow, int startCol, ExcelTitle excelTitle, Workbook workbook, Sheet sheet, short rowHeight, int numCol) {
        int rowTitle = startRow > 3 ? startRow - 3 : 0;
        if (excelTitle != null) {
            if (!DataUtils.isNullOrEmpty(excelTitle.getTitle())) {
                Row rowMainTitle = sheet.createRow(rowTitle);
                Cell mainCellTitle = rowMainTitle.createCell(startCol);
                mainCellTitle.setCellValue(excelTitle.getTitle().toUpperCase());
                CellStyle cellStyleTitle = getCellStyleTitle(workbook);
                Font newFont = mainCellTitle.getSheet().getWorkbook().createFont();
                newFont.setFontHeightInPoints((short) 18);
                newFont.setFontName(HSSFFont.FONT_ARIAL);
                newFont.setColor(HSSFColor.HSSFColorPredefined.WHITE.getIndex());
                cellStyleTitle.setFont(newFont);
                mainCellTitle.setCellStyle(cellStyleTitle);
                sheet.addMergedRegion(new CellRangeAddress(rowTitle, rowTitle, startCol, numCol));
            }
            if (!DataUtils.isNullOrEmpty(excelTitle.getDateExportPattern()) && !DataUtils.isNullOrEmpty(excelTitle.getDateExportTitle())) {
                Row rowDateExport = sheet.createRow(rowTitle + 1);
                Cell mainCellTitle = rowDateExport.createCell((numCol / 2) + 1);
                mainCellTitle.setCellValue(excelTitle.getDateExportTitle() + " : " + DataUtils.dateToString(new Date(), excelTitle.getDateExportPattern()));
                CellStyle cellStyle = createStyle(workbook);
                mainCellTitle.setCellStyle(cellStyle);
            }
            if (!DataUtils.isNullOrEmpty(excelTitle.getFileDateTitle()) && !DataUtils.isNullOrEmpty(excelTitle.getFileDate())) {
                Row rowDateExport = sheet.createRow(rowTitle + 1);
                int col = "Báo cáo kế hoạch kinh doanh ".equals(excelTitle.getFileDateTitle()) ? startCol : (numCol / 2);
                Cell mainCellTitle = rowDateExport.createCell(col);
                mainCellTitle.setCellValue(excelTitle.getFileDateTitle() + " : " + excelTitle.getFileDate());
                CellStyle cellStyle = createStyle(workbook);
                mainCellTitle.setCellStyle(cellStyle);

                if ("Báo cáo kế hoạch kinh doanh ".equals(excelTitle.getFileDateTitle())) {
                    sheet.addMergedRegion(new CellRangeAddress(rowTitle + 1, rowTitle + 1, startCol, numCol));
                }
            }
        }
        //Header
        Row rowHeader = sheet.createRow(startRow);
        rowHeader.setHeight(rowHeight);

        return rowHeader;
    }

    private static CellStyle createCellStyleHeader(Workbook workbook) {
        CellStyle cellStyleHeader = workbook.createCellStyle();
        Font hSSFFontHeader = createFontHeader(workbook);
        hSSFFontHeader.setFontName(HSSFFont.FONT_ARIAL);
        cellStyleHeader.setFont(hSSFFontHeader);
        cellStyleHeader.setAlignment(HorizontalAlignment.CENTER);
        cellStyleHeader.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyleHeader.setBorderLeft(BorderStyle.THIN);
        cellStyleHeader.setBorderBottom(BorderStyle.THIN);
        cellStyleHeader.setBorderRight(BorderStyle.THIN);
        cellStyleHeader.setBorderTop(BorderStyle.THIN);
        cellStyleHeader.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
        cellStyleHeader.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyleHeader.setWrapText(true);
        return cellStyleHeader;
    }

    private static CellStyle createCellStyle(Workbook workbook) {
        CellStyle cellStyleHeader = workbook.createCellStyle();
        Font hSSFFontHeader = createFontHeader(workbook);
        hSSFFontHeader.setFontName(HSSFFont.FONT_ARIAL);
        cellStyleHeader.setFont(hSSFFontHeader);
        cellStyleHeader.setAlignment(HorizontalAlignment.CENTER);
        cellStyleHeader.setVerticalAlignment(VerticalAlignment.CENTER);
        return cellStyleHeader;
    }

    private static Font createFontHeader(Workbook workbook) {
        Font hSSFFontHeader = workbook.createFont();
        hSSFFontHeader.setFontName(HSSFFont.FONT_ARIAL);
        hSSFFontHeader.setFontHeightInPoints((short) 10);
        hSSFFontHeader.setBold(true);
        return hSSFFontHeader;
    }

    public static CellStyle createStyleHeader(Workbook workbook) {
        CellStyle cellStyleHeader = createCellStyleHeader(workbook);
        Font hSSFFontHeader = createFontHeader(workbook);
        hSSFFontHeader.setFontName(HSSFFont.FONT_ARIAL);
        hSSFFontHeader.setColor(IndexedColors.BLACK.index);
        cellStyleHeader.setFont(hSSFFontHeader);
        return cellStyleHeader;
    }

    private static CellStyle createCellStyleHeader(Workbook workbook, IndexedColors indexedColors, Font font,
                                                   HorizontalAlignment horizontalAlignment) {
        CellStyle cellStyleHeader = workbook.createCellStyle();
        Font hSSFFontHeader = createFontHeader(workbook);
        hSSFFontHeader.setFontName(HSSFFont.FONT_ARIAL);
        cellStyleHeader.setFont(font != null ? font : hSSFFontHeader);
        cellStyleHeader.setAlignment(horizontalAlignment != null ? horizontalAlignment : HorizontalAlignment.CENTER);
        cellStyleHeader.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyleHeader.setBorderLeft(BorderStyle.THIN);
        cellStyleHeader.setBorderBottom(BorderStyle.THIN);
        cellStyleHeader.setBorderRight(BorderStyle.THIN);
        cellStyleHeader.setBorderTop(BorderStyle.THIN);
        cellStyleHeader.setFillForegroundColor(indexedColors != null ? indexedColors.index : IndexedColors.WHITE.index);
        cellStyleHeader.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyleHeader.setWrapText(true);
        return cellStyleHeader;
    }

    private static CellStyle createStyle(Workbook workbook) {
        CellStyle cellStyleHeader = createCellStyle(workbook);
        Font hSSFFontHeader = createFontHeader(workbook);
        hSSFFontHeader.setFontName(HSSFFont.FONT_ARIAL);
        cellStyleHeader.setFont(hSSFFontHeader);
        return cellStyleHeader;
    }

    private static ByteArrayInputStream createFileOutput(List<ExcelColumn> lstColumn, List<?> lstData, int startRow, int startCol,
                                                         Workbook workbook, Sheet sheet, boolean displayIndex, boolean isWriteFile) throws Exception {
        //trai
        CellStyle cellStyleLeft = getCellStyle(workbook, HorizontalAlignment.LEFT);
        //phai
        CellStyle cellStyleRight = getCellStyle(workbook, HorizontalAlignment.RIGHT);
        //giua
        CellStyle cellStyleCenter = getCellStyle(workbook, HorizontalAlignment.CENTER);

        CellStyle cellStyleNumber = getCellStyleNumber(workbook, HorizontalAlignment.RIGHT);

        writeDataReport(workbook, lstColumn, lstData, startRow, startCol, sheet, cellStyleLeft, cellStyleRight, cellStyleCenter, cellStyleNumber, displayIndex);
        if (isWriteFile) {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
        return null;
    }

    private static CellStyle getCellStyle(Workbook workbook, HorizontalAlignment horizontalAlignment) {
        CellStyle cellStyleCenter = workbook.createCellStyle();

        Font hSSFFont = workbook.createFont();
        hSSFFont.setFontName(HSSFFont.FONT_ARIAL);
        cellStyleCenter.setFont(hSSFFont);
        cellStyleCenter.setAlignment(horizontalAlignment);
        cellStyleCenter.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyleCenter.setBorderLeft(BorderStyle.THIN);
        cellStyleCenter.setBorderBottom(BorderStyle.THIN);
        cellStyleCenter.setBorderRight(BorderStyle.THIN);
        cellStyleCenter.setBorderTop(BorderStyle.THIN);
        cellStyleCenter.setWrapText(true);
        cellStyleCenter.setDataFormat((short) BuiltinFormats.getBuiltinFormat("@"));
        return cellStyleCenter;
    }

    private static CellStyle getCellStyleNumber(Workbook workbook, HorizontalAlignment horizontalAlignment) {
        DataFormat fmt = workbook.createDataFormat();
        CellStyle cellStyleCenter = workbook.createCellStyle();
        Font hSSFFont = workbook.createFont();
        hSSFFont.setFontName(HSSFFont.FONT_ARIAL);
        cellStyleCenter.setFont(hSSFFont);
        cellStyleCenter.setAlignment(horizontalAlignment);
        cellStyleCenter.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyleCenter.setBorderLeft(BorderStyle.THIN);
        cellStyleCenter.setBorderBottom(BorderStyle.THIN);
        cellStyleCenter.setBorderRight(BorderStyle.THIN);
        cellStyleCenter.setBorderTop(BorderStyle.THIN);
        cellStyleCenter.setWrapText(true);
        cellStyleCenter.setDataFormat(fmt.getFormat("#,##0"));
        return cellStyleCenter;
    }

    private static CellStyle getCellStyleTitle(Workbook workbook) {
        CellStyle cellStyleTitle = workbook.createCellStyle();
        cellStyleTitle.setAlignment(HorizontalAlignment.CENTER);
        cellStyleTitle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyleTitle.setFillForegroundColor(IndexedColors.GREEN.index);
        cellStyleTitle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Font hSSFFont = workbook.createFont();
        hSSFFont.setFontName(HSSFFont.FONT_ARIAL);
        hSSFFont.setFontHeightInPoints((short) 20);
        hSSFFont.setBold(true);
        hSSFFont.setColor(IndexedColors.WHITE.index);
        cellStyleTitle.setFont(hSSFFont);
        return cellStyleTitle;
    }

    private static void writeDataReport(Workbook workbook, List<ExcelColumn> lstColumn, List<?> lstData, int startRow, int startCol, Sheet sheet,
                                        CellStyle cellStyleLeft, CellStyle cellStyleRight, CellStyle cellStyleCenter, CellStyle cellStyleNumber,
                                        boolean displayIndex) throws IllegalAccessException, NoSuchFieldException {
        if (lstData != null && !lstData.isEmpty()) {
            Object firstRow = lstData.get(0);
            Map<String, Field> mapField = new HashMap<>();
            for (ExcelColumn column : lstColumn) {
                String header = column.getColumn();
                Field[] fs = ReflectorUtil.getAllFields(firstRow.getClass());
                Arrays.stream(fs).peek(f -> f.setAccessible(true)).filter(f -> f.getName().equals(header)).forEach(f -> mapField.put(header, f));
            }

            int diff = getDiff(displayIndex);
            FormulaEvaluator fev = workbook.getCreationHelper().createFormulaEvaluator();
            for (int i = 0; i < lstData.size(); i++) {
                Row row = sheet.createRow(i + startRow + 1);
                if (displayIndex) {
                    Cell cell = row.createCell(startCol);
                    cell.setCellValue(i + 1);
                    cell.setCellStyle(cellStyleCenter);
                }
                for (int j = 0; j < lstColumn.size(); j++) {
                    Cell cell = row.createCell(j + startCol + diff);
                    ExcelColumn column = lstColumn.get(j);
                    Object obj = lstData.get(i);
                    Field f = mapField.get(column.getColumn());
                    if (f != null) {
                        Object value = f.get(obj);
                        String text;
                        boolean isDouble = false;
                        if (value instanceof Double) {
                            isDouble = true;
                            text = doubleToString((Double) value);
                        } else if (value instanceof Instant) {
                            text = instantToString((Instant) value, column.getPattern());
                        } else if (value instanceof Date) {
                            text = dateToString((Date) value, column.getPattern());
                        } else if (value instanceof BigInteger) {
                            text = ((BigInteger) value).toString();
                        } else if (value instanceof BigDecimal) {
                            text = value.toString();
                        } else {
                            text = objectToString(value);
                        }
                        cell.setCellValue(text);
                        if (isDouble || value instanceof BigInteger || value instanceof BigDecimal) {
                            String tempValue = cell.getStringCellValue();
                            cell.setCellFormula("VALUE(" + tempValue + ")");
                            fev.evaluateInCell(cell);
                            cell.setCellStyle(cellStyleNumber);
                        } else {
                            setCellStyle(cell, column, cellStyleLeft, cellStyleRight, cellStyleCenter);
                        }
                    }
                }
            }
        }
    }

    private static void setCellStyle(Cell cell, ExcelColumn column, CellStyle cellStyleLeft, CellStyle cellStyleRight, CellStyle cellStyleCenter) {
        if (ExcelColumn.ALIGN_MENT.CENTER.equals(column.getAlign())) {
            cell.setCellStyle(cellStyleCenter);
        } else if (ExcelColumn.ALIGN_MENT.LEFT.equals(column.getAlign())) {
            cell.setCellStyle(cellStyleLeft);
        } else if (ExcelColumn.ALIGN_MENT.RIGHT.equals(column.getAlign())) {
            cell.setCellStyle(cellStyleRight);
        }
    }

    private static String instantToString(Instant value, String pattern) {
        return Optional.ofNullable(pattern).map(tmp -> {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(tmp);
            return dtf.format(LocalDateTime.ofInstant(value, ZoneId.of("GMT+7")));
        }).orElse("");
    }

    private static String dateToString(Date value, String pattern) {
        return Optional.ofNullable(pattern).map(tmp -> {
            SimpleDateFormat dtf = new SimpleDateFormat(tmp);
            return dtf.format(value);
        }).orElse("");
    }

    private static String objectToString(Object value) {
        return Optional.ofNullable(value).map(Object::toString).orElse("");
    }

    private static String doubleToString(Double value) {
        return Optional.ofNullable(value).map(tmp -> {
            String result = doubleFormat.format(tmp);
            if (result.endsWith(".0")) {
                result = result.split("\\.")[0];
            }
            return result;
        }).orElse("");
    }

    private static int getDiff(boolean displayIndex) {
        return displayIndex ? 1 : 0;
    }


    public static ByteArrayInputStream onExportNoneLife(List<List<ExcelHeader>> lstHeaders,
                                                        List<ExcelColumn> lstColumn, List lstData, int startRow, int startCol,
                                                        ExcelTitle excelTitle, boolean pDisplayIndex,
                                                        int partitionSize) throws Exception {
        SXSSFWorkbook workbook = null;
        try {
            workbook = new SXSSFWorkbook(1000);
            List<List> partition = new ArrayList<>();
            if (partitionSize == 0) {
                partitionSize = lstData.size();
            }
            if (partitionSize > 0) {
                partition = Lists.partition(lstData, partitionSize);
            } else {
                partition.add(new ArrayList<>());
            }
            int displayIndex = getDiff(pDisplayIndex);
            for (int j = 0; j < partition.size(); j++) {
                Sheet sheet = workbook.createSheet(j == 0 ? "Data" : "Data " + (j + 1));
                CellStyle style = workbook.createCellStyle();
                Font font = workbook.createFont();
                font.setFontName(HSSFFont.FONT_ARIAL);
                style.setFont(font);

                createFileTitle(startRow, startCol, excelTitle, workbook, sheet, (short) 500,
                        (lstColumn.size() + displayIndex - 1));

                int rowStartMerge = startRow + 1;
                int nextRow = startRow + 1;
                for (List<ExcelHeader> lsHeader : lstHeaders) {
                    Row rowTitle = sheet.createRow(nextRow);
                    int startMergeCol = startCol;
                    for (int i = 0; i < lsHeader.size(); i++) {
                        CellStyle cellStyleHeader = createStyleHeader(workbook);
                        Font fontCell = workbook.createFont();
                        fontCell.setFontName(HSSFFont.FONT_ARIAL);
                        cellStyleHeader.setFont(fontCell);
                        ExcelHeader e = lsHeader.get(i);
                        boolean isItem = e.isItem() != null && e.isItem();
                        cellStyleHeader = createCellStyleHeader(workbook, e.getIndexedColors(), isItem ?
                                fontCell : null, isItem ? HorizontalAlignment.CENTER : HorizontalAlignment.LEFT);
                        String content = lsHeader.get(i).getContent();
                        if (lsHeader.get(i).isMerge()) {
                            if (e.getStartCol() == null || e.getLastCol() == null) {
                                throw new Exception("Lỗi");
                            }
                            for (int k = e.getStartCol(); k <= e.getLastCol(); k++) {
                                if (k == e.getStartCol()) {
                                    setColumn(rowTitle, cellStyleHeader, e.getStartCol(), content);
                                } else
                                    setColumn(rowTitle, cellStyleHeader, k, null);
                            }
                            mergeCell(sheet,
                                    e.getStartRow() == null ? rowStartMerge : e.getStartRow() + rowStartMerge,
                                    e.getEndRow() == null ? rowStartMerge : e.getEndRow() + rowStartMerge,
                                    e.getStartCol(), e.getLastCol());

                            if (!DataUtils.isNullOrEmpty(e.getExcelHeaderItemList())) {
                                List<ExcelHeaderItem> itemLs = e.getExcelHeaderItemList();
                                Row rowTitleItem = sheet.createRow(rowTitle.getRowNum() + 1);
                                for (int i1 = 0; i1 < itemLs.size(); i1++) {
                                    setColumn(rowTitleItem, cellStyleHeader, itemLs.get(i1).getStartCol() != null ? itemLs.get(i1).getStartCol() : i1 + e.getStartCol(), itemLs.get(i1).getContent());
                                }
                            }
                            startMergeCol = 1 + e.getLastCol();
                        } else {
                            cellStyleHeader = createCellStyleHeader(workbook, e.getIndexedColors(), isItem ?
                                    fontCell : null, isItem ? HorizontalAlignment.CENTER : HorizontalAlignment.LEFT);
                            startMergeCol = e.getStartCol() == null ? startMergeCol : e.getStartCol();
                            setColumn(rowTitle, cellStyleHeader, startMergeCol, lsHeader.get(i).getContent());
                            startMergeCol++;
                        }
                        nextRow = e.getEndRow() != null && (e.getEndRow() + rowStartMerge) > nextRow ? e.getEndRow() + rowStartMerge : nextRow;
                    }
                    nextRow++;
                    rowStartMerge = nextRow;
                }
                startRow = nextRow - 1;
                AtomicInteger atomicInteger = new AtomicInteger(0);
                lstColumn.forEach(e -> {
                    if (e.getColumnWidth() != null) {
                        sheet.setColumnWidth(startCol + displayIndex + atomicInteger.getAndIncrement(), e.getColumnWidth());
                    }
                });
                createFileOutput(lstColumn, partition.get(j), startRow, startCol, workbook, sheet, pDisplayIndex, false);
            }

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } finally {
            if (workbook != null) {
                workbook.dispose();
                workbook.close();
            }
        }
    }

    private static void setColumn(Row title, CellStyle headerCellStyle1, int column, String content) {
        Cell cellTitle = title.createCell(column);
        if (!DataUtils.isNullOrEmpty(content)) {
            cellTitle.setCellValue(content);
        }
        cellTitle.setCellStyle(headerCellStyle1);
    }

    private static void mergeCell(Sheet sheet, int row, int lastRow, int column, int lastColumn) {
        CellRangeAddress cellMerge = new CellRangeAddress(row, lastRow, column, lastColumn);
        sheet.addMergedRegion(cellMerge);
    }

    public static ByteArrayOutputStream insertMoreAndSubject(List<DetailVotesExcelDTO> dataObject , ByteArrayInputStream byteArrayInputStream , int startRow) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(byteArrayInputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);

        // Định nghĩa vị trí dòng để chèn (sau dòng tiêu đề, dòng 1 là tiêu đề)

        // Duyệt qua danh sách thông tin yêu cầu và thêm vào các dòng
        for (int i = 0; i < dataObject.size(); i++) {
            // Kiểm tra nếu dữ liệu không phải null
            if (dataObject.get(i) != null) {

                    // Di chuyển các dòng dưới xuống một vị trí (nếu cần)
                    sheet.shiftRows(startRow, sheet.getLastRowNum(), 1);

                    // Tạo dòng mới tại vị trí đã được dịch chuyển
                    XSSFRow row = sheet.createRow(startRow); // Tạo dòng tại vị trí mới

                    // Ghi giá trị vào cột 4 (index 3)
                    XSSFCell cell = row.createCell(dataObject.get(i).getColHeader());
                    cell.setCellValue(dataObject.get(i).getHeader());

                    // Ghi giá trị vào cột 5 (index 4)
                    XSSFCell valueCell = row.createCell(dataObject.get(i).getColValue());
                    valueCell.setCellValue(dataObject.get(i).getValue());

                    // Tăng chỉ số dòng để tránh ghi đè
                    startRow++;
                }

        }

        // Lưu lại file sau khi thêm dòng
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        return out;
    }

}

