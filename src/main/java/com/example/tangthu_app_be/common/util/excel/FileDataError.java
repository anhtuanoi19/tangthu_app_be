package com.example.tangthu_app_be.common.util.excel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileDataError {
    private int rowIndex;
    private String description;
    private Timestamp createdAt;
    private String createdBy;
}
