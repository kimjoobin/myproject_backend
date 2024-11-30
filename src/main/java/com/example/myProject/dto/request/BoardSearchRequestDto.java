package com.example.myProject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardSearchRequestDto {
    
    private int page = 1;   // 현재 페이지 번호
    private int pageSize = 10;  // 페이지당 게시글 수
    private int perPageSize = 10;   // 하단 페이징 개수
    private String searchType;  // 검색 타입
    private String searchValue; // 검색어
}
