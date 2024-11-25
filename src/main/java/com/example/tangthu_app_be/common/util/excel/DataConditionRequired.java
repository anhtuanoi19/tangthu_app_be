package com.example.tangthu_app_be.common.util.excel;


public @interface DataConditionRequired {
    String nameField();

    String[] value();
}