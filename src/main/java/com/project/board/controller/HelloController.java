package com.project.board.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    // GET /api/hello
    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring boot!";
    }

    @GetMapping("/hello/board")
    public String helloBoard() {
        return "welcome to Board API!";
    }

    @GetMapping("/info")
    public Map<String, Object> getInfo(){
        Map<String, Object> info = new HashMap<>();
        info.put("name", "Board API");
        info.put("version", "1.0.0");
        info.put("status", "running");
        return info;
    }
    
}
