package com.example.myProject.dto.response.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardListResponseDto {

    private Long boardId;

    private String title;

    private String writer;

    private Integer viewCount;

    private String createdAt;

    /*public static BoardListResponseDto fromBoard(Board board) {
        return BoardListResponseDto.builder()
                .boardId(board.getBoardId())
                .title(board.getTitle())
                .writer(board.getMember().getName())
                .viewCount(board.getViewCount())
                .createdAt(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm").format(board.getCreatedAt()))
                .build();
    }*/

}
