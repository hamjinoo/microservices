package com.project.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.board.model.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

}
