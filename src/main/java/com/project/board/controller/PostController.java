package com.project.board.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.board.model.Post;
import com.project.board.service.PostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

  private final PostService postService;

  // GET /api/posts - 전체 조회
  @GetMapping
  public ResponseEntity<List<Post>> list() {
    List<Post> posts = postService.findAll();
    return ResponseEntity.ok(posts);
  }

  // GET /api/posts/{id} - 상세 조회
  @GetMapping("/{id}")
  public ResponseEntity<Post> get(@PathVariable Long id) {
    Post post = postService.findById(id);
    return ResponseEntity.ok(post);
  }

  // POST /api/posts - 생성
  @PostMapping
  public ResponseEntity<Post> create(@RequestBody Post post) {
    Post savedPost = postService.save(post);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedPost);
  }

  // PUT /api/posts/{id} - 수정
  @PutMapping("/{id}")
  public ResponseEntity<Post> update(
      @PathVariable Long id,
      @RequestBody Post post) {
    Post updatedPost = postService.update(id, post);
    return ResponseEntity.ok(updatedPost);
  }

  // DELETE /api/posts/{id} - 삭제
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    postService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
