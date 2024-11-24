package com.example.myProject.repository;

import com.example.myProject.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByEmail(String email);

    Member findByEmailAndPassword(String email, String password);
}
