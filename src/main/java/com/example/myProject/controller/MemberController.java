package com.example.myProject.controller;

import com.example.myProject.dto.request.MemberJoinRequestDto;
import com.example.myProject.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/V1.0/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("")
    public void joinMember(@RequestBody MemberJoinRequestDto requestDto) {
        memberService.joinMember(requestDto);
    }
}
