package com.example.tangthu_app_be.domain.dtos.response;

public class BaseResponseDTO {
    private String message = "Success";
    private Integer status = 200;


    public BaseResponseDTO(String message, Integer status) {
        this.message = message;
        this.status = status;
    }

    public BaseResponseDTO() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
