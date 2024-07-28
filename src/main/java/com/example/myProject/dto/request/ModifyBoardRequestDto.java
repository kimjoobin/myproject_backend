package com.example.myProject.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ModifyBoardRequestDto extends RegisterBoardRequestDto {

    private Long boardId;
}
