package com.example.tangthu_app_be.common.util.excel.filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdditionalContractRequestFilter {

    private Long transactionOfficeId;

    private String branchCode;

    private Long consultantMemberId;

    private Long auditMemberId;

    private String dispStatus;

    private Long month;

    private Long year;

}
