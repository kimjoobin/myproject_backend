package com.example.myProject.dto.response.board;

import com.example.myProject.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDetailResponseDto {

    private Long boardId;

    private String title;

    private String writer;

    private String contents;

    private String createdAt;

    public static BoardDetailResponseDto from(Board board) {
        return BoardDetailResponseDto.builder()
                .boardId(board.getBoardId())
                .title(board.getTitle())
                .writer(board.getMember().getName())
                .contents(board.getContents())
                .createdAt(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(board.getCreatedAt()))
                .build();
    }
}
