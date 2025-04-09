package com.company.msa.repository;

import com.company.msa.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, String> {
    // 특정 게시글(postId)에 대한 모든 댓글을 가져오기 위한 메서드
    List<Reply> findByPostId(Long postId);
}
