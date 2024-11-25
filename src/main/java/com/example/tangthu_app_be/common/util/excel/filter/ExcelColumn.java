package com.example.tangthu_app_be.common.util.excel.filter;


import com.example.tangthu_app_be.common.util.excel.DataConditionRequired;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelColumn {
    String columnName();

    boolean required() default false;

    int exportOrder() default -1;

    String formula() default "";

    String regex() default "";

    String errorMessage() default "";

    int columnSize() default -1;

    int columnSizeLimit() default -1;

    DataValidation[] dataValidations() default {};

    DataConditionRequired dataConditionRequired() default @DataConditionRequired(nameField = "", value = {});

    String dependDataValidation() default "";

    boolean requiredDependData() default false;

    boolean rangedValue() default false;

    boolean checkPart() default false;

    long minValue() default 0;

    long maxValue() default 0;

    int minDayOffset() default 0;

    int maxDayOffset() default 0;

    boolean checkYear() default false;

    int yearOffset() default 0;

    String[] beforeOrEquals() default "";

    String[] afterOrEquals() default "";

    String validationClazz() default "";

    int maxLength() default -1;

    String datePattern() default "MM/dd/yyyy";

    String[] data() default {};

    int minLength() default -1;
}
