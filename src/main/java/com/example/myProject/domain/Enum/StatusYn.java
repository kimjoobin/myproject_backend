package com.example.myProject.domain.Enum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StatusYn {
    Y("Y")
    ,N("N")
    ;

    private String status;

    StatusYn(String status) {
        this.status = status;
    }
}
