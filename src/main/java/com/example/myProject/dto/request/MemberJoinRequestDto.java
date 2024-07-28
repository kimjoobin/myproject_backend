package com.example.myProject.dto.request;

import lombok.Getter;

@Getter
public class MemberJoinRequestDto {

    private String email;

    private String password;

    private String name;

    private String birthDate;
}
