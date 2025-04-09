package com.company.msa.repository;

import com.company.msa.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    // JpaRepository를 상속받으면 findAll(), save(), deleteById() 등을 자동 제공
}
