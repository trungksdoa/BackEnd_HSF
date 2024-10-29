package com.koisystem.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse {
    private String message;
    private Object data;

    public static ApiResponse success(String message, Object data) {
        return ApiResponse.builder()
                .message(message)
                .data(data)
                .build();
    }

    public static ApiResponse success(Object data) {
        return success("Success", data);
    }
}
