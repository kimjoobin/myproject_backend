package com.example.myProject.domain;

import com.example.myProject.dto.request.MemberJoinRequestDto;
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
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String name;

    private String email;

    private String password;

    private String birthDate;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public static Member createMember(MemberJoinRequestDto requestDto) {
        return Member.builder()
                .name(requestDto.getName())
                .email(requestDto.getEmail())
                .password(requestDto.getPassword())
                .birthDate(requestDto.getBirthDate())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
