package com.example.tangthu_app_be.common.util.excel.filter;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class ReportFilter {
    protected String keyword;
    private List<Long> areaIds;
    private List<Long> branchIds;
    private List<Long> transOfficeIds;

    public String getAreaIdStr() {
        if (areaIds == null || areaIds.isEmpty())
            return null;

        return areaIds.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(","));
    }

    public String getBranchIdStr() {
        if (branchIds == null || branchIds.isEmpty())
            return null;

        return branchIds.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(","));
    }

    public String getOfficeIdStr() {
        if (transOfficeIds == null || transOfficeIds.isEmpty())
            return null;

        return transOfficeIds.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(","));
    }

    protected String arrayToStr(Long[] arr) {
        if (arr == null || arr.length == 0)
            return null;

        return Arrays.stream(arr)
                .map(Objects::toString)
                .collect(Collectors.joining(","));
    }
}
