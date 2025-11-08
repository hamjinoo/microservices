package com.project.board.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import com.project.board.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    // 게시판별 페이징 조회 (JPA Query Method)
    Page<Post> findByBoardId(Long boardId, Pageable pageable);
}
