package com.project.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.board.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
