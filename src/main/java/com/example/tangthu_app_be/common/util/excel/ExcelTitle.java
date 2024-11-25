package com.example.tangthu_app_be.common.util.excel;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExcelTitle {
    private String title;

    private String dateExportTitle;

    private String dateExportPattern;

    private String fileDateTitle;

    private String fileDate;

    public ExcelTitle(String title, String fileDateTitle, String fileDate) {
        this.title = title;
        this.fileDateTitle = fileDateTitle;
        this.fileDate = fileDate;
    }
}
