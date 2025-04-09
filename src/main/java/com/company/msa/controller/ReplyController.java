package com.company.msa.controller;

import com.company.msa.entity.Reply;
import com.company.msa.repository.ReplyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/replies")
public class ReplyController {

    private final ReplyRepository replyRepository;

    public ReplyController(ReplyRepository replyRepository) {
        this.replyRepository = replyRepository;
    }

    @GetMapping("/post/{postId}")
    public List<Reply> getRepliesByPost(@PathVariable Long postId) {
        return replyRepository.findByPostId(postId);
    }

    @PostMapping
    public Reply createReply(@RequestBody Reply reply) {
        return replyRepository.save(reply);
    }
}
