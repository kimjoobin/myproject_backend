package com.example.myProject.controller;

import com.example.myProject.dto.request.ModifyBoardRequestDto;
import com.example.myProject.dto.request.RegisterBoardRequestDto;
import com.example.myProject.dto.response.board.BoardDetailResponseDto;
import com.example.myProject.dto.response.board.BoardListResponseDto;
import com.example.myProject.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/V1.0/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("")
    public List<BoardListResponseDto> getBoards() {
        return boardService.getBoards();
    }

    @PostMapping("")
    public void registerBoard(@RequestBody RegisterBoardRequestDto requestDto) {
        boardService.registerBoard(requestDto);
    }

    @GetMapping("{id}")
    public BoardDetailResponseDto getBoardById(@PathVariable("id") Long boardId) {
        return boardService.getBoardById(boardId);
    }

    @PutMapping("")
    public void updateBoard(@RequestBody ModifyBoardRequestDto requestDto) {
        boardService.updateBoard(requestDto);
    }
}
