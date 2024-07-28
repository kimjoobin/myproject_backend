package com.example.myProject.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RegisterBoardRequestDto {

    private String title;

    private String contents;
}
