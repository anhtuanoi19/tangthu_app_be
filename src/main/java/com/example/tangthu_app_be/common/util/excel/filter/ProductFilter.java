package com.example.tangthu_app_be.common.util.excel.filter;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@SuperBuilder
@NoArgsConstructor
public class ProductFilter {

    private List<String> categoryNames;
    private List<String> productType;
    private List<String> productStatus;
    private Integer numOfFeeYear;

    private String keyWord;
    private String productName;
    private String productCode;
    private Integer numOfContractYear;
    private Long categoryId;

    public String getCategoryName() {
        if (categoryNames == null || categoryNames.isEmpty())
            return null;

        return categoryNames.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(","));
    }

    public String getProductTypeStr() {
        if (productType == null || productType.isEmpty())
            return null;

        return productType.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(","));
    }

    public String getProductStatusStr() {
        if (productStatus == null || productStatus.isEmpty())
            return null;

        return productStatus.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(","));
    }

}
