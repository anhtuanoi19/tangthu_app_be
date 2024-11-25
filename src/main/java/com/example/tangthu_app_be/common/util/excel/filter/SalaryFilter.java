package com.example.tangthu_app_be.common.util.excel.filter;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@SuperBuilder
public class SalaryFilter extends ReportFilter {
    private String keyword;
    private List<Long> salesMemberIds;
    private Long fromNumOfContract;
    private Long toNumOfContract;
    private Long fromNumOfCancel;
    private Long toNumOfCancel;
    private Long fromResultMonthRevenue;
    private Long toResultMonthRevenue;
    private Long fromRevenue;
    private Long toRevenue;
    private Long fromSalarySalesAmount;
    private Long toSalarySalesAmount;
    private Long fromArrearsAmount;
    private Long toArrearsAmount;
    private Long fromSalaryTotalAmount;
    private Long toSalaryTotalAmount;

    public String getMemberIdStr() {
        if (salesMemberIds == null || salesMemberIds.isEmpty())
            return null;

        return salesMemberIds.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(","));
    }
}
