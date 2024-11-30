package com.example.myProject.service;

import com.example.myProject.domain.Member;
import com.example.myProject.dto.request.LoginRequestDto;
import com.example.myProject.dto.request.MemberJoinRequestDto;
import com.example.myProject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public String joinMember(MemberJoinRequestDto requestDto) {
        if (!StringUtils.hasText(requestDto.getEmail())) {
            return "이메일을 입력해주세요.";
        }

        requestDto.setPassword(passwordEncoder.encode(requestDto.getPassword()));

        Member saveMember = memberRepository.save(Member.createMember(requestDto));
        if (saveMember.getMemberId() != null) {
            System.out.println("saveMember = " + saveMember);
            return "OK";
        } else {
            return "FAIL";
        }
    }

    public String userLogin(LoginRequestDto requestDto) {
        Member member = memberRepository.findByEmail(requestDto.getEmail());

        if (!passwordEncoder.matches(requestDto.getPassword(), member.getPassword())) {
            throw new IllegalArgumentException("Invalid not password!");
        }

        return "OK";
    }

    public void logout() {
    }
}
