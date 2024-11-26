package com.example.myProject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberJoinRequestDto {

    private String username;

    private String email;

    private String phone;

    private String birthDay;

    private String password;

    private String confirmPassword;
}
