package com.example.tangthu_app_be.common.util.excel;

import org.apache.poi.ss.usermodel.IndexedColors;

import java.util.List;

public class ExcelHeader {

    List<ExcelHeaderItem> excelHeaderItemList;
    private String content;
    private Integer startCol;
    private Integer lastCol;
    private Integer columnWidth;
    private boolean isMerge;
    private Integer startRow;
    private Integer endRow;
    private IndexedColors indexedColors;
    private Boolean isItem;
    private boolean isRate = false;
    private boolean isEmpty = false; // nếu muốn để rate mà vẫn muốn empty khi null

    public ExcelHeader(String content) {
        this.content = content;
    }

    public ExcelHeader(String content, Integer startCol, Integer lastCol, boolean isMerge) {
        this.content = content;
        this.startCol = startCol;
        this.lastCol = lastCol;
        this.isMerge = isMerge;
    }

    public ExcelHeader(String content, Integer startCol, Integer lastCol, boolean isMerge, boolean isItem) {
        this.content = content;
        this.startCol = startCol;
        this.lastCol = lastCol;
        this.isMerge = isMerge;
        this.isItem = isItem;
    }

    public ExcelHeader(String content, Integer startCol, Integer lastCol, boolean isMerge, IndexedColors indexedColors) {
        this.content = content;
        this.startCol = startCol;
        this.lastCol = lastCol;
        this.isMerge = isMerge;
        this.indexedColors = indexedColors;
    }

    public ExcelHeader(String content, Integer startCol, Integer lastCol, boolean isMerge,
                       IndexedColors indexedColors, boolean isItem) {
        this.content = content;
        this.startCol = startCol;
        this.lastCol = lastCol;
        this.isMerge = isMerge;
        this.indexedColors = indexedColors;
        this.isItem = isItem;
    }

    public ExcelHeader(String content, Integer startCol, Integer lastCol, boolean isMerge,
                       IndexedColors indexedColors, boolean isItem, boolean isRate) {
        this.content = content;
        this.startCol = startCol;
        this.lastCol = lastCol;
        this.isMerge = isMerge;
        this.indexedColors = indexedColors;
        this.isItem = isItem;
        this.isRate = isRate;
    }

    public ExcelHeader(String content, Integer startCol, Integer lastCol, boolean isMerge,
                       IndexedColors indexedColors, boolean isItem, boolean isRate, boolean isEmpty) {
        this.content = content;
        this.startCol = startCol;
        this.lastCol = lastCol;
        this.isMerge = isMerge;
        this.indexedColors = indexedColors;
        this.isItem = isItem;
        this.isRate = isRate;
        this.isEmpty = isEmpty;
    }

    public ExcelHeader(String content, Integer startCol, Integer lastCol, Integer startRow, Integer endRow, boolean isMerge) {
        this.content = content;
        this.startCol = startCol;
        this.lastCol = lastCol;
        this.startRow = startRow;
        this.endRow = endRow;
        this.isMerge = isMerge;
    }

    public ExcelHeader() {
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public Boolean getItem() {
        return isItem;
    }

    public void setItem(Boolean item) {
        isItem = item;
    }

    public List<ExcelHeaderItem> getExcelHeaderItemList() {

        return excelHeaderItemList;
    }

    public void setExcelHeaderItemList(List<ExcelHeaderItem> excelHeaderItemList) {
        this.excelHeaderItemList = excelHeaderItemList;
    }

    public boolean isRate() {
        return isRate;
    }

    public void setRate(boolean rate) {
        isRate = rate;
    }

    public Boolean isItem() {
        return isItem;
    }

    public IndexedColors getIndexedColors() {
        return indexedColors;
    }

    public void setIndexedColors(IndexedColors indexedColors) {
        this.indexedColors = indexedColors;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    public Integer getEndRow() {
        return endRow;
    }

    public void setEndRow(Integer endRow) {
        this.endRow = endRow;
    }

    public Integer getColumnWidth() {
        return columnWidth;
    }

    public void setColumnWidth(Integer columnWidth) {
        this.columnWidth = columnWidth;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStartCol() {
        return startCol;
    }

    public void setStartCol(Integer startCol) {
        this.startCol = startCol;
    }

    public Integer getLastCol() {
        return lastCol;
    }

    public void setLastCol(Integer lastCol) {
        this.lastCol = lastCol;
    }

    public boolean isMerge() {
        return isMerge;
    }

    public void setMerge(boolean merge) {
        isMerge = merge;
    }
}
