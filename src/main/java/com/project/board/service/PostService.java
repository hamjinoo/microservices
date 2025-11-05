package com.project.board.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.board.model.Post;
import com.project.board.repository.PostRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class PostService {

  private final PostRepository postRepository;

  // 전체 조회
  public List<Post> findAll() {
    return postRepository.findAll();
  }

  // ID로 조회
  public Post findById(Long id) {
    return postRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다. ID: " + id));
  }

  // 저장 (생성 & 수정)
  @Transactional
  public Post save(Post post) {
    return postRepository.save(post);
  }

  // 수정
  @Transactional
  public Post update(Long id, Post post) {
    Post existingPost = findById(id);
    existingPost.setTitle(post.getTitle());
    existingPost.setContent(post.getContent());
    return postRepository.save(existingPost);
  }

  // 삭제
  @Transactional
  public void delete(Long id) {
    if (!postRepository.existsById(id)) {
      throw new RuntimeException("게시글을 찾을 수 없습니다. ID: " + id);
    }
    postRepository.deleteById(id);
  }
}
