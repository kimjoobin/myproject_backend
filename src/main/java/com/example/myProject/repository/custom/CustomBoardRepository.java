package com.example.myProject.repository.custom;

import com.example.myProject.dto.request.BoardSearchRequestDto;
import com.example.myProject.dto.response.board.BoardListResponseDto;
import org.springframework.data.domain.Page;

public interface CustomBoardRepository {

    Page<BoardListResponseDto> getBoardList(BoardSearchRequestDto requestDto);
}
