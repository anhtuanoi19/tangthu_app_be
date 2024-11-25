package com.example.tangthu_app_be.common.util.excel.filter;

public @interface DataValidation {
    public String code();

    public String value();

    public int length() default -1;

    public String regex() default "";

    public String errorMessage() default "";
}