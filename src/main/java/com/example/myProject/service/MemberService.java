package com.example.myProject.service;

import com.example.myProject.domain.Member;
import com.example.myProject.dto.request.MemberJoinRequestDto;
import com.example.myProject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;


    public void joinMember(MemberJoinRequestDto requestDto) {
        Member saveMember = memberRepository.save(Member.createMember(requestDto));
    }
}
