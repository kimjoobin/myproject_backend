package com.example.myProject.controller;

import com.example.myProject.dto.request.ModifyBoardRequestDto;
import com.example.myProject.dto.request.RegisterBoardRequestDto;
import com.example.myProject.dto.response.board.BoardDetailResponseDto;
import com.example.myProject.dto.response.board.BoardListResponseDto;
import com.example.myProject.handler.ApiResponse;
import com.example.myProject.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/V1.0/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("")
    public ResponseEntity<ApiResponse<List<BoardListResponseDto>>> getBoards() {
        try {
            List<BoardListResponseDto> boards = boardService.getBoards();
            return ResponseEntity.ok(ApiResponse.success(boards));
        } catch (Exception e) {
            return ResponseEntity.ok(ApiResponse.error(e.getMessage()));
        }
    }

    @PostMapping("")
    public ResponseEntity<ApiResponse<Void>> registerBoard(@RequestBody RegisterBoardRequestDto requestDto) {
        String getResponse = boardService.registerBoard(requestDto);
        if ("ok".equals(getResponse)) {
            return ResponseEntity.ok(ApiResponse.success(null));
        } else {
            return ResponseEntity.ok(ApiResponse.error(getResponse));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BoardDetailResponseDto>> getBoardById(@PathVariable("id") Long boardId) {
        BoardDetailResponseDto response = boardService.getBoardById(boardId);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    @PutMapping("")
    public void updateBoard(@RequestBody ModifyBoardRequestDto requestDto) {
        boardService.updateBoard(requestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable("id") Long boardId) {
        boardService.deleteBoard(boardId);
    }
}
