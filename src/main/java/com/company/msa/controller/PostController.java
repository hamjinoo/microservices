package com.company.msa.controller;

import com.company.msa.entity.Post;
import com.company.msa.repository.PostRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/board/{boardId}")
    public List<Post> getPostsByBoard(@PathVariable Long boardId) {
        return postRepository.findByBoardId(boardId);
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postRepository.save(post);
    }
}
