package com.example.myProject.domain;

import lombok.Getter;

@Getter
public enum MemberRole {
    ROLE_USER("USER")
    ,ROLE_ADMIN("ADMIN")
    ;

    private final String role;

    MemberRole(String role) {
        this.role = role;
    }
}
