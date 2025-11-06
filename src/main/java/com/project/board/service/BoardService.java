package com.project.board.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.board.model.Board;
import com.project.board.repository.BoardRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class BoardService {

  private final BoardRepository boardRepository;

  // 전체 조회
  public List<Board> findAll() {
    return boardRepository.findAll();
  }

  // ID로 조회
  public Board findById(Long id) {
    return boardRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("게시판을 찾을 수 없습니다. ID: " + id));
  }

  // 저장 (생성 & 수정)
  @Transactional
  public Board save(Board board) {
    return boardRepository.save(board);
  }

  // 수정
  @Transactional
  public Board update(Long id, Board board) {
    Board existingBoard = findById(id);
    existingBoard.setName(board.getName());
    return boardRepository.save(existingBoard);
  }

  // 삭제
  @Transactional
  public void delete(Long id) {
    if (!boardRepository.existsById(id)) {
      throw new RuntimeException("게시판을 찾을 수 없습니다. ID: " + id);
    }
    boardRepository.deleteById(id);
  }
}

