package com.example.myProject.repository;

import com.example.myProject.domain.Board;
import com.example.myProject.repository.custom.CustomBoardRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long>, CustomBoardRepository {

    List<Board> findByDelYnOrderByCreatedAtDesc(String delYn);

    Board findByBoardId(Long boardId);
}
