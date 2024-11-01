package com.koisystem.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServiceResponse<T> {
    private String message;
    private T data;
    private boolean success;

    public static <T> ServiceResponse<T> success(String message, T data) {
        return ServiceResponse.<T>builder()
                .message(message)
                .data(data)
                .success(true)
                .build();
    }

    public static <T> ServiceResponse<T> error(String message) {
        return ServiceResponse.<T>builder()
                .message(message)
                .success(false)
                .build();
    }
} 