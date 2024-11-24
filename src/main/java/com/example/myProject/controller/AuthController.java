package com.example.myProject.controller;

import com.example.myProject.dto.request.LoginRequestDto;
import com.example.myProject.dto.request.MemberJoinRequestDto;
import com.example.myProject.handler.ApiResponse;
import com.example.myProject.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/V1.0/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/join")
    public ResponseEntity<ApiResponse<String>> joinMember(@RequestBody MemberJoinRequestDto requestDto) {
        String getResponse = authService.joinMember(requestDto);
        if (getResponse.equals("OK")) {
            return ResponseEntity.ok(ApiResponse.success(getResponse));
        } else {
            return ResponseEntity.ok(ApiResponse.error(getResponse));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> userLogin(@RequestBody LoginRequestDto requestDto) {
        String getResponse = authService.userLogin(requestDto);
        if (getResponse.equals("OK")) {
            return ResponseEntity.ok("Success login");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(getResponse);
        }
    }

    @PostMapping("/logout")
    public void logout() {
        authService.logout();
    }
}
