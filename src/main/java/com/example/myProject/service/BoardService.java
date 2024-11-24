package com.example.myProject.service;

import com.example.myProject.domain.Board;
import com.example.myProject.domain.Enum.StatusYn;
import com.example.myProject.domain.Member;
import com.example.myProject.dto.request.ModifyBoardRequestDto;
import com.example.myProject.dto.request.RegisterBoardRequestDto;
import com.example.myProject.dto.response.board.BoardDetailResponseDto;
import com.example.myProject.dto.response.board.BoardListResponseDto;
import com.example.myProject.repository.BoardRepository;
import com.example.myProject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {

    private final BoardRepository boardRepository;

    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public List<BoardListResponseDto> getBoards() {
        List<Board> boards = boardRepository.findByDelYn(StatusYn.N.getStatus());

        return boards.stream()
                .map(BoardListResponseDto::fromBoard)
                .toList();
    }

    public String registerBoard(RegisterBoardRequestDto requestDto) {
        Member member = memberRepository.findById(1L)
                .orElseThrow(() -> new IllegalArgumentException("not found"));

        Board board = boardRepository.save(Board.createBoard(requestDto, member));
        if (board.getBoardId() == null) {
            return "fail";
        } else {
            return "ok";
        }
    }

    @Transactional(readOnly = true)
    public BoardDetailResponseDto getBoardById(Long boardId) {

        Board board = findBoard(boardId);
        return BoardDetailResponseDto.from(board);
    }

    public void updateBoard(ModifyBoardRequestDto requestDto) {
        Board board = findBoard(requestDto.getBoardId());
        board.updateBoard(requestDto);
    }

    public void deleteBoard(Long boardId) {
        Board board = findBoard(boardId);
        board.deleteBoard();
    }

    private Board findBoard(Long boardId) {
        return boardRepository.findByBoardId(boardId);
    }
}
