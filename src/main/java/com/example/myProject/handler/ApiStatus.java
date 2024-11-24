package com.example.myProject.handler;

import lombok.Getter;

@Getter
public enum ApiStatus {
    SUCCESS("success")
    ,ERROR("error")
    ;

    private final String status;

    ApiStatus(String status) {
        this.status = status;
    }
}
