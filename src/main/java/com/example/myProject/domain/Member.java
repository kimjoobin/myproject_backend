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

    private String phone;

    @Column(name = "refresh_token", columnDefinition = "VARCHAR(500) COMMENT 'refresh token'")
    private String refreshToken;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public static Member createMember(MemberJoinRequestDto requestDto) {
        return Member.builder()
                .name(requestDto.getUsername())
                .email(requestDto.getEmail())
                .password(requestDto.getPassword())
                .phone(requestDto.getPhone())
                .birthDate(requestDto.getBirthDay())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
