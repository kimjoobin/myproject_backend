package com.example.myProject.domain;

import com.example.myProject.domain.Enum.StatusYn;
import com.example.myProject.dto.request.MemberJoinRequestDto;
import com.example.myProject.dto.request.ModifyBoardRequestDto;
import com.example.myProject.dto.request.RegisterBoardRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String title;

    private String contents;

    private Integer viewCount;

    private String delYn;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public static Board createBoard(RegisterBoardRequestDto requestDto, Member member) {
        return Board.builder()
                .member(member)
                .title(requestDto.getTitle())
                .contents(requestDto.getContents())
                .viewCount(0)
                .delYn(StatusYn.N.getStatus())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public void updateBoard(ModifyBoardRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.updatedAt = LocalDateTime.now();
    }

    public void deleteBoard() {
        this.delYn = StatusYn.Y.getStatus();
    }
}
