package com.example.tangthu_app_be.common.util.excel;

public class ExcelHeaderItem {
    private String content;
    private Integer startCol;
    private Integer lastCol;
    private Integer columnWidth;
    private boolean isMerge;

    public ExcelHeaderItem() {
    }

    public ExcelHeaderItem(String content, Integer startCol, Integer lastCol, boolean isMerge) {
        this.content = content;
        this.startCol = startCol;
        this.lastCol = lastCol;
        this.isMerge = isMerge;
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

    public Integer getColumnWidth() {
        return columnWidth;
    }

    public void setColumnWidth(Integer columnWidth) {
        this.columnWidth = columnWidth;
    }

    public boolean isMerge() {
        return isMerge;
    }

    public void setMerge(boolean merge) {
        isMerge = merge;
    }
}
