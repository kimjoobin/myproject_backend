package com.example.myProject.controller;

import com.example.myProject.dto.request.LoginRequestDto;
import com.example.myProject.dto.request.MemberJoinRequestDto;
import com.example.myProject.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/V1.0/member")
public class MemberController {

    private final MemberService memberService;


}
