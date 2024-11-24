package com.example.myProject.handler;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ApiResponse<T> {

    private final ApiStatus status;
    private final T data;
    private int code;
    private String message;
    private String description;
    private LocalDateTime timeStamp;

    public static <T> ApiResponse<T> success(T data) {
        return ApiResponse.<T>builder()
                .status(ApiStatus.SUCCESS)
                .data(data)
                .description("success")
                .timeStamp(LocalDateTime.now())
                .build();
    }

    public static <T> ApiResponse<T> error(String message) {
        return ApiResponse.<T>builder()
                .status(ApiStatus.ERROR)
                .message(message)
                .description("error")
                .timeStamp(LocalDateTime.now())
                .build();
    }
}
