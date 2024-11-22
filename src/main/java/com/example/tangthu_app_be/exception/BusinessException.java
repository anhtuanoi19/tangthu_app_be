package com.example.tangthu_app_be.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessException extends RuntimeException {
    private String errorCode;

    public BusinessException(String errorCode) {
        super();
        this.errorCode = errorCode;
    }
}
