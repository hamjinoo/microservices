package com.company.msa.controller;

import com.company.msa.entity.Board;
import com.company.msa.repository.BoardRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boards") // 기본 URL 설정
public class BoardController {

    private final BoardRepository boardRepository;

    // 생성자를 이용하여 BoardRepository 주입 (Dependency Injection)
    public BoardController(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @GetMapping
    public List<Board> getBoards() {
        return boardRepository.findAll();
    }

    @PostMapping
    public Board createBoard(@RequestBody Board board) {
        return boardRepository.save(board);
    }
}
