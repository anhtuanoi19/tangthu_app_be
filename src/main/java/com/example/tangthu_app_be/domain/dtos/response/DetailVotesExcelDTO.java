package com.example.tangthu_app_be.domain.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetailVotesExcelDTO {
    private String header;
    private String value;
    private int colHeader;
    private int colValue;
}
