package com.company.msa.repository;

import com.company.msa.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    /*
        1. board_id 값이 주어지는 boardId와 일치하는 게시글을 Post에서 찾아서 반환한다.
        2. Spring Data JPA의 규칙이다. - findBy + Board(Post 클래스의 필드) + Id(Board 클래스의 필드)
     */
    List<Post> findByBoardId(Long boardId);
}

/*
게시글을 List<Post>로 담는 이유0
- 게시글이 여러 개 존재할 가능성이 있기 때문에 List<Post>로 받아야 한다.

 */