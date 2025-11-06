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

import com.project.board.model.Board;
import com.project.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class BoardController {

  private final BoardService boardService;

  // GET /api/boards - 전체 조회
  @GetMapping
  public ResponseEntity<List<Board>> list() {
    List<Board> boards = boardService.findAll();
    return ResponseEntity.ok(boards);
  }

  // GET /api/boards/{id} - 상세 조회
  @GetMapping("/{id}")
  public ResponseEntity<Board> get(@PathVariable Long id) {
    Board board = boardService.findById(id);
    return ResponseEntity.ok(board);
  }

  // POST /api/boards - 생성
  @PostMapping
  public ResponseEntity<Board> create(@RequestBody Board board) {
    Board savedBoard = boardService.save(board);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedBoard);
  }

  // PUT /api/boards/{id} - 수정
  @PutMapping("/{id}")
  public ResponseEntity<Board> update(
      @PathVariable Long id,
      @RequestBody Board board) {
    Board updatedBoard = boardService.update(id, board);
    return ResponseEntity.ok(updatedBoard);
  }

  // DELETE /api/boards/{id} - 삭제
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    boardService.delete(id);
    return ResponseEntity.noContent().build();
  }
}

