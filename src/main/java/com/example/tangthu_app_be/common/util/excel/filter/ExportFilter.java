package com.example.tangthu_app_be.common.util.excel.filter;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class ExportFilter extends ReportFilter {
    private Long districtId;
    private String keyword;
    private String bankContractNo;
    private String searchType;
    private Long customerId;
    private String salesMemberIdArray;
    private String consultantMemberIdArray;
    private String refMemberIdArray;
    private String productIdArray;
    private Integer paymentPeriod;
    private Integer currentContractYear;
    private Integer currentFeeYear;
    private Integer numOfContractYear;
    private String salesChannel;
    private String consultantType;
    private String customerType;
    private String expireStatus;
    private String auditStatus;
    private String paymentSource;
    private Date fromApplyFormDate;
    private Date toApplyFormDate;
    private Date fromIssueDate;
    private Date toIssueDate;
    private Date fromLastPayDate;
    private Date toLastPayDate;
    private Date fromExpireDate;
    private Date toExpireDate;
    private Double fromBasicAmount;
    private Double toBasicAmount;
    private Double fromExtraAmount;
    private Double toExtraAmount;
    private Double fromTotalAmount;
    private Double toTotalAmount;
    private String orderByClause;
    private String contractStatus;
    private Date fromHandOverDate;
    private Date toHandOverDate;
    private Integer filterStatus;

}
