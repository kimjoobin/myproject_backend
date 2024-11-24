package com.example.myProject.repository;

import com.example.myProject.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findByDelYn(String delYn);

    Board findByBoardId(Long boardId);
}
