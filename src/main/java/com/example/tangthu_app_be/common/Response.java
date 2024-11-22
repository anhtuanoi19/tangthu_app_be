package com.example.tangthu_app_be.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Response implements Serializable {
    private static final long serialVersionUID = -9035179706238790613L;

    private String status;
    private String message;
    private Object data;
    private Object optional;

    public Response(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}